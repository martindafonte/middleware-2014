package org.pruebamagica;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


@SuppressWarnings("deprecation")
public class Main {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("META-INF/initial.xml"));
		MessageReceiver receiver = (MessageReceiver)factory.getBean("messageReceiver");
		receiver.start();
				
	}

}
