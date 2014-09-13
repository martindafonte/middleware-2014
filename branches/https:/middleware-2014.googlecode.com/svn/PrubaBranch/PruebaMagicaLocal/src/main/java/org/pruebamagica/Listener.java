package org.pruebamagica;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.sender.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Listener implements MessageListener {

	InputGateway gateway ;
	@SuppressWarnings("resource")
	public Listener() {
		super();
		gateway= new ClassPathXmlApplicationContext("META-INF/config.xml").getBean("inputGateway",InputGateway.class);
	}
	
	public void onMessage(Message message) {
		try {
			ObjectMessage om = (ObjectMessage) message;
			Object  t = om.getObject();
			Transaction t2 = (Transaction)t;
			gateway.process(t2);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
