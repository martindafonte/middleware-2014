import java.util.HashMap;
import java.util.Map;

import javax.jms.Message;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


@SuppressWarnings("deprecation")
public class Main {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
		Recibidor receiver = (Recibidor)factory.getBean("messageReceiver");
		receiver.start();
		
//		MessageSender<String, String> sender = (MessageSender<String, String>) factory.getBean("messageSender");
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("Nombre", "Bruno");
//		map.put("Apellido", "Strasser");
//		sender.send(map);

//		try {
//			Recibidor _rec = new Recibidor();
//			_rec.setBeanName("messageReceiver");
//			_rec.setDestinationName("QUEUE_NAME");
//			_rec.start();
//			Thread.sleep(10000);
//			sender.send(map);
//			Thread.sleep(10000);
//			sender.send(map);
//			Thread.sleep(10000);
//			sender.send(map);
//			Thread.sleep(10000);
//			sender.send(map);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
