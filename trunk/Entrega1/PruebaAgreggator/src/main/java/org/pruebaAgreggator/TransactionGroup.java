package org.pruebaAgreggator;

import java.io.Serializable;
import java.util.List;

import org.sender.Transaction;

public class TransactionGroup implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Transaction> ts;

	public List<Transaction> getTs() {
		return ts;
	}

	public void setTs(List<Transaction> ts) {
		this.ts = ts;
	}
	
}
