import javax.jms.Message;
import javax.jms.MessageListener;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
//import org.springframework.jms.core.JmsTemplate;

 
public class MessageReceiver extends DefaultMessageListenerContainer implements MessageListener {

	
//	private JmsTemplate jmsTemplate;
//	
//	public MessageReceiver(JmsTemplate jmsTemplate) {
//        this.jmsTemplate = jmsTemplate;
//    }
	
	@Override
	public void onMessage(Message arg0) {
//		jmsTemplate.receive();
		System.out.println("MESSAGE" + arg0.toString());
	}
 
    
 
}
