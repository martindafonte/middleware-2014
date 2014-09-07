package org.pruebamagica;
import javax.jms.Message;
import javax.jms.MessageListener;

public class Listener implements MessageListener {
	
	private InputGateway gateway;
	
	public Listener(InputGateway gateway){
		this.gateway = gateway;
	}
	
	public void onMessage(Message message) {
		gateway.process(message);
	}

}
