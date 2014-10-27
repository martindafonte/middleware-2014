package org.bancodispatcher;

import javax.jms.Message;

public class ErrorHandler {
	
	public void handleFailed(Object m){
		System.out.println("***LOG :*** " + m.toString());
	}
}
