package org.pruebamagica;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.sender.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.format.annotation.DateTimeFormat;

public class Listener implements MessageListener {

	InputGateway gateway;

	@SuppressWarnings("resource")
	public Listener() {
		super();
		gateway= new ClassPathXmlApplicationContext("META-INF/config.xml").getBean("inputGateway",InputGateway.class);
	}
	
	public void onMessage(Message message) {
		try {
			ObjectMessage om = (ObjectMessage) message;
			Object obj = om.getObject();
			Transaction tran = (Transaction) obj;
			String fecha;
			String tipo;
			String tiempo;
			String moneda;
			String dispositivo;
			SimpleDateFormat sdf = new SimpleDateFormat();
			if ( /* fecha= */tran.getDate() != null) {
				sdf.applyPattern("ddmmyy");
				// sdf.parse(tran);
				if ((tiempo = tran.getTime()) != null) {
					sdf.applyPattern("HHmmss");
					sdf.parse(tiempo);
					if (((tipo = tran.getType()) != null)
							&& (tipo != "Débito" && tipo != "crédito" && tipo != "prepaga")) {
						if (((moneda = tran.getCurrency()) != null)
								&& (moneda != "UYU" && tipo != "USD")) {
							if (((dispositivo = tran.getDeviceType()) != null)
									&& (dispositivo != "POS"
											&& dispositivo != "WEB" && dispositivo != "ATM")) {
								gateway.process(tran);
								return;
							}
						}
					}
				}
			}
			//devolver un error
		} catch (JMSException e) {
			//registrar error
		} catch (ParseException e) {
			//registrar error
		}
	}
}
