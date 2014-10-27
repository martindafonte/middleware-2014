package org.bancodispatcher;

import org.producerweb.Transaction;


public interface InputGateway {

	
	public void process(Transaction msg);
}
