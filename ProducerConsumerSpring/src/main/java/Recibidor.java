import java.io.Console;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.scheduling.SchedulingAwareRunnable;


public class Recibidor extends DefaultMessageListenerContainer {



	@Override
	protected Message receiveMessage(MessageConsumer consumer)
			throws JMSException {
		Message msg =consumer.receive();
		System.out.print(msg);
		System.out.print(msg.getStringProperty("Nombre"));
		return super.receiveMessage(consumer);
	}

	@Override
	protected void messageReceived(Object invoker, Session session) {
		System.out.println("Llego un mensaje");
		SchedulingAwareRunnable _async = ((SchedulingAwareRunnable)invoker);
		try {
			session.getMessageListener();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
 
}
