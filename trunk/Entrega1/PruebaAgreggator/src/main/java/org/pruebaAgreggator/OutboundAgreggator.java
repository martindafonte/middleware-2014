package org.pruebaAgreggator;

import java.util.List;

import org.sender.Transaction;

public class OutboundAgreggator {

	
	public void process(List<Transaction> l){
		
//		List<Transaction> list = group.getTs();
		System.out.println("###########################");
		
		int i = 0;
		for(Transaction t : l){			
			System.out.println(""+ (i++) +" : "+ t.toString());			
		}
		
		System.out.println("###########################");
		
	}
	
}
