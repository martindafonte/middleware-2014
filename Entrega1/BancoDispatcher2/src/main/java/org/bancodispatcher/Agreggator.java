package org.bancodispatcher;

import java.util.List;

import org.producerweb.Transaction;

public class Agreggator{ 

	public List<Transaction> process(List<Transaction> l){
		System.out.println("LLAMO AL AGREGGATOR");
		return l;
	}
	
}
