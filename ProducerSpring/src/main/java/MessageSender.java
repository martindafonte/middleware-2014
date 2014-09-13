import java.util.Map;
import org.springframework.jms.core.JmsTemplate;
 
public class MessageSender<T,H> {
 
    private JmsTemplate jmsTemplate;
 
    public MessageSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
 
    public void send(Map<T,H> map) {
        jmsTemplate.convertAndSend(map);
    }
    
    public void send(Object o) {
        jmsTemplate.convertAndSend(o);
    }
 
}