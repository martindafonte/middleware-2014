package org.bancodispatcher;

import java.text.SimpleDateFormat;

import javax.jms.ObjectMessage;

import org.producerweb.Transaction;
import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

public class Filter implements MessageSelector{

	
	
	public boolean accept(Message<?> message) {

		
		try {
			GenericMessage<Transaction> gm = (GenericMessage<Transaction>) message;
			Object obj = gm.getPayload();
			Transaction tran = (Transaction) obj;
			String fecha;
			String tipo;
			String tiempo;
			String moneda;
			String dispositivo;
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
			if ( (fecha = tran.getDate() ) != null) {
				sdf.parse(fecha);
				if ((tiempo = tran.getTime()) != null) {
					sdf = new SimpleDateFormat("HHmmss");
					sdf.parse(tiempo);
					if (((tipo = tran.getType()) != null)
							&& (tipo.equals("Débito") || tipo.equals("Crédito") || tipo.equals("Prepaga"))) {
						if (((moneda = tran.getCurrency()) != null)
								&& (moneda.equals("UYU") || tipo.equals("USD"))) {
							if (((dispositivo = tran.getDeviceType()) != null)
									&& (dispositivo.equals("POS") || 
										dispositivo.equals("WEB") || 
										dispositivo.equals("ATM") )) {
								
								return true;
							}
						}
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return false;
	}	
	
}
