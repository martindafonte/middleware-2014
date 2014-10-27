package org.bancodispatcher;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;





@SuppressWarnings("deprecation")
public class Main {

	static String log4j_file = "/home/bruno/workspace/BancoDispatcher2/src/main/java/org/bancodispatcher/log4j.properties"; 
	
	public static void main(String[] args) {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(log4j_file));
			PropertyConfigurator.configure(props);
//			BasicConfigurator.configure();
			BeanFactory factory = new XmlBeanFactory(new ClassPathResource("META-INF/initial.xml"));
			MessageReceiver receiver = (MessageReceiver)factory.getBean("messageReceiver");
			receiver.start();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}

}
