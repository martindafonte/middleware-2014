package org.pruebamagica;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Listener implements MessageListener {
	
	
	public void onMessage(Message message) {
//		System.out.println("Listener onMessage");
		ApplicationContext context =  new ClassPathXmlApplicationContext("META-INF/config.xml");
//		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("META-INF/config.xml"));
		InputGateway gateway = context.getBean("inputGateway", InputGateway.class);
//		InputGateway gateway = (InputGateway)factory.getBean("inputGateway");
		gateway.process("hola");
	}

}
