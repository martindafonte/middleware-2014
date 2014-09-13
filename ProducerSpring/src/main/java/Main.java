import java.security.Timestamp;
import java.util.Date;
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
		long i = 0;
		Transaction t;
		while(true){
			try {
				t = new Transaction();
				t.setId(i++);
				t.setDate((new Date()).toString());
				t.setTime((new Date()).toString());
				t.setType(i % 4 == 0 ? "RET" : "DEP");
				t.setCode("codigo");
				t.setCommerceName("comercio");
				t.setCardNumber("1111111");
				t.setCardType("DEB");
				t.setCurrency("SI");
				t.setDeviceType(i % 4 == 0 ? "POS" : "ATM");
				t.setAmount(2000.0);
				
//				map = new HashMap<String, String>();
//				map.put("Nombre", "Bruno");
//				map.put("Apellido", "Strasser");
				
				sender.send(t);
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
