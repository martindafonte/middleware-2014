package org.pruebamagica;

import javax.jms.Message;

public class ErrorHandler {
	
	public void handleFailedOrder(Object m){
		System.out.println("***LOG :*** " + m.toString());
	}
}
