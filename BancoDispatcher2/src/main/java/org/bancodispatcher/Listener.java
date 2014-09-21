package org.bancodispatcher;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.producerweb.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.messaging.support.ErrorMessage;

public class Listener implements MessageListener {

	InputGateway gateway;

	@SuppressWarnings("resource")
	public Listener() {
		super();
		gateway = new ClassPathXmlApplicationContext("META-INF/config.xml")
				.getBean("inputGateway", InputGateway.class);
	}

	public void onMessage(Message message) {

		try {

			ObjectMessage om = (ObjectMessage) message;
			Object obj = om.getObject();
			Transaction tran = (Transaction) obj;
			String fecha;
			String tipo;
			String cardType;
			String tiempo;
			String moneda;
			String dispositivo;
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
			if ((fecha = tran.getDate()) != null) {

				try {
					sdf.parse(fecha);
				} catch (Exception e) {
					throw new InvalidTransactionException(
							"fecha inválida");
				}

				if ((tiempo = tran.getTime()) != null) {
					sdf = new SimpleDateFormat("HHmmss");

					try {
						sdf.parse(tiempo);
					} catch (Exception e) {
						throw new InvalidTransactionException(
								"tiempo inválido");
					}

					if (((tipo = tran.getType()) != null)
							&& (tipo.equals("Compra")
									|| tipo.equals("Depósito") || tipo
										.equals("Consulta de saldo"))) {

						if (((cardType = tran.getCardType()) != null)
								&& (cardType.equals("Débito")
										|| cardType.equals("Crédito") || cardType.equals("Prepaga"))) {

							if (((moneda = tran.getCurrency()) != null)
									&& (moneda.equals("UYU") || moneda.equals("USD"))) {

								if (((dispositivo = tran.getDeviceType()) != null)
										&& (dispositivo.equals("POS")
												|| dispositivo.equals("WEB") 
												|| dispositivo.equals("ATM"))) {

									gateway.process(tran);

								} else {
									throw new InvalidTransactionException(
											"dispositivo inválido: "
													+ dispositivo);
								}

							} else {
								throw new InvalidTransactionException(
										"moneda inválida: " + moneda);
							}

						} else {
							throw new InvalidTransactionException(
									"tipo de tarjeta inválido: " + cardType);
						}

					} else {
						throw new InvalidTransactionException(
								"tipo de transacción inválido: " + tipo);
					}

				} else {
					throw new InvalidTransactionException("tiempo inválido");
				}

			} else {
				throw new InvalidTransactionException("fecha inválida");
			}

		} catch (Exception e) {
			gateway.processError(e);
		}

	}
}
