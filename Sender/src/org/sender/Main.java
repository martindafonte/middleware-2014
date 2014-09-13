package org.sender;

import java.util.Date;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

public class Main {

	public Main() {
		super();
	}

	public static void main(String[] args) throws Exception {

		thread(new HelloWorldProducer(), false);

	}

	public static void thread(Runnable runnable, boolean daemon) {
		Thread brokerThread = new Thread(runnable);
		brokerThread.setDaemon(daemon);
		brokerThread.start();
	}

	public static class HelloWorldProducer implements Runnable {
		public void run() {

			
			try {
				
				Transaction t;
				
				for (long i = 0; i < 10000; i++) {

					ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
							ActiveMQConnectionFactory.DEFAULT_BROKER_BIND_URL);

					Connection connection = connectionFactory
							.createConnection();
					connection.start();

					Session session = connection.createSession(false,
							Session.AUTO_ACKNOWLEDGE);

					Destination destination = session.createQueue("QUEUE_NAME");

					MessageProducer producer = session
							.createProducer(destination);
					producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

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

					ObjectMessage message = session.createObjectMessage(t);
					producer.send(message);

					session.close();
					connection.close();
					Thread.sleep(10000);
				}

			} catch (Exception e) {
				System.out.println("Caught: " + e);
				e.printStackTrace();
			}
		}
	}

	public static class HelloWorldConsumer implements Runnable,
			ExceptionListener {
		public void run() {
			try {

				// Create a ConnectionFactory
				ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
						ActiveMQConnectionFactory.DEFAULT_BROKER_BIND_URL);

				// Create a Connection
				Connection connection = connectionFactory.createConnection();
				connection.start();

				connection.setExceptionListener(this);

				// Create a Session
				Session session = connection.createSession(false,
						Session.AUTO_ACKNOWLEDGE);

				// Create the destination (Topic or Queue)
				Destination destination = session.createQueue("TEST.FOO");

				// Create a MessageConsumer from the Session to the Topic or
				// Queue
				MessageConsumer consumer = session.createConsumer(destination);

				// Wait for a message
				Message message = consumer.receive(1000);

				if (message instanceof TextMessage) {
					TextMessage textMessage = (TextMessage) message;
					String text = textMessage.getText();
					System.out.println("Received: " + text);
				} else {
					System.out.println("Received: " + message);
				}

				consumer.close();
				session.close();
				connection.close();
			} catch (Exception e) {
				System.out.println("Caught: " + e);
				e.printStackTrace();
			}
		}

		public synchronized void onException(JMSException ex) {
			System.out.println("JMS Exception occured.  Shutting down client.");
		}
	}
}