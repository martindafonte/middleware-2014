package org.pruebamagica;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Listener implements MessageListener {

	public void onMessage(Message message) {
		@SuppressWarnings("resource")
		InputGateway gateway = new ClassPathXmlApplicationContext("META-INF/config.xml").getBean("inputGateway",InputGateway.class);
		try {
			ObjectMessage om = (ObjectMessage) message;
			Transaction t = (Transaction) om.getObject();
			gateway.process(t);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
