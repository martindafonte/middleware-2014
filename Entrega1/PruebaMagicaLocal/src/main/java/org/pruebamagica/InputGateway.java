package org.pruebamagica;

import javax.jms.*;

public interface InputGateway {

	
	public void process(String msg);
}
