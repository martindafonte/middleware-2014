package org.pruebamagica;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

 
public class MessageReceiver extends DefaultMessageListenerContainer{

	public MessageReceiver() {
		
		super();
//		ApplicationContext context =  new ClassPathXmlApplicationContext("META-INF/config.xml");
//		InputGateway gateway = context.getBean("inputGateway", InputGateway.class);
		this.setMessageListener( new Listener());
    }
	
}