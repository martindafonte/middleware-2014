package org.pruebaws;

import org.sender.Transaction;


public interface InputGateway {

	
	public void process(Transaction msg);
}
