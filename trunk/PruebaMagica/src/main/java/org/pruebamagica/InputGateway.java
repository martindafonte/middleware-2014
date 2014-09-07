package org.pruebamagica;

import javax.jms.*;

public interface InputGateway {

	
	public void process(Message msg);
}
