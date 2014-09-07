package org.pruebamagica;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

 
public class MessageReceiver extends DefaultMessageListenerContainer{

	public MessageReceiver() {
		super();
		ApplicationContext context =  new ClassPathXmlApplicationContext("META-INF/config.xml");
		InputGateway gateway = context.getBean("inputGateway", InputGateway.class);
		this.setMessageListener( new Listener(gateway));
    }
	
}