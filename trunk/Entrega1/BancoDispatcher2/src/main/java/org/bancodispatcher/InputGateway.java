package org.bancodispatcher;

import org.producerweb.Transaction;


public interface InputGateway {

	
	public void process(Transaction msg);
	
	public void processError(Throwable m);
	
}
