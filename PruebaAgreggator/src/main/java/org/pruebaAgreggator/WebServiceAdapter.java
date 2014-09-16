package org.pruebaAgreggator;

import org.sender.Transaction;

public class WebServiceAdapter {


	
	public void process(Transaction m){
//		
		System.out.println("LLEGO AL WEB SERVICE: "+ m.getDeviceType().equals("POS"));
	}
}
