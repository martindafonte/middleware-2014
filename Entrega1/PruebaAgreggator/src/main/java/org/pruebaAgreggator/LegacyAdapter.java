package org.pruebaAgreggator;

import org.sender.Transaction;

public class LegacyAdapter {

		
	public void process(Transaction m){
			System.out.println("LLEGO AL LEGACY: " + m.getDeviceType().equals("ATM"));
	}
	
}
