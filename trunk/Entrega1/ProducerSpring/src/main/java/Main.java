import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


@SuppressWarnings("deprecation")
public class Main {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
		
		MessageSender<String, String> sender = (MessageSender<String, String>) factory.getBean("messageSender");
		Map<String, String> map = new HashMap<String, String>();
		map.put("Nombre", "Bruno");
		map.put("Apellido", "Strasser");
		sender.send(map);
		try {
			Thread.sleep(10000);
			sender.send(map);
			Thread.sleep(10000);
			sender.send(map);
			Thread.sleep(10000);
			sender.send(map);
			Thread.sleep(10000);
			sender.send(map);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
