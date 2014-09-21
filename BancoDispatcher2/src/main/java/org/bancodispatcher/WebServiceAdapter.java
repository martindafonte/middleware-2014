package org.bancodispatcher;

import org.producerweb.Transaction;



public class WebServiceAdapter {


	
	public void process(Transaction m){
//		
		System.out.println("LLEGO AL WEB SERVICE: "+ m.getDeviceType().equals("POS"));
	}
}
