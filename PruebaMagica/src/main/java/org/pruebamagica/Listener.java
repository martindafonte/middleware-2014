package org.pruebamagica;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;

import org.springframework.jms.listener.SessionAwareMessageListener;

public class Listener implements SessionAwareMessageListener {
	
	private InputGateway gateway;
	
	public Listener(InputGateway gateway){
		this.gateway = gateway;
	}
	
//	public void onMessage(Message message) {
//		System.out.println("Esta es la posta");
//	}

	public void onMessage(Message message, Session session) throws JMSException {
		System.out.println("Esta es la posta");
	}

}
