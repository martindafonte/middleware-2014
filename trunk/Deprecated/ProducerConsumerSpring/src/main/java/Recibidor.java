import java.io.Console;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;

import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.scheduling.SchedulingAwareRunnable;


public class Recibidor extends DefaultMessageListenerContainer {

	public Recibidor() {
		super();
		this.setMessageListener(new escuchador());
	}
}

class escuchador implements MessageListener{

	@Override
	public void onMessage(Message message) {
		System.out.println("Esta es la posta");	
	}
	
}
