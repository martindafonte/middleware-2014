package org.pruebamagica;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


@SuppressWarnings("deprecation")
public class Main {

	public static void main(String[] args) {

//		ApplicationContext context =  new ClassPathXmlApplicationContext("META-INF/initial.xml");
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("META-INF/initial.xml"));
		MessageReceiver receiver = (MessageReceiver)factory.getBean("messageReceiver");
//		MessageReceiver receiver = context.getBean("messageReceiver", MessageReceiver.class);
		receiver.start();
				
	}

}
