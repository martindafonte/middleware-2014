package org.bancodispatcher;

import org.sender.Transaction;



public interface InputGateway {

	
	public void process(Transaction msg);
}
