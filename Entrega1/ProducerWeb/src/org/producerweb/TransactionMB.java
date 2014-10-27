package org.producerweb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;


@ManagedBean(name="transactionMB")
@RequestScoped
public class TransactionMB {


	private Transaction input;
	
	@PostConstruct
	public void init(){
		input = new Transaction();		
	}

	public String sendTransaction(){
		
		try {
		
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat sdf2 = new SimpleDateFormat("ddMMyyyy");
			Date d = sdf.parse(input.getDate());
			input.setDate(sdf2.format(d));
			input.setTime(input.getTime().replaceAll(":", ""));
			thread(new Producer(input), false);
			System.out.println("Envió transaccion");
			input = new Transaction();
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String sendTransactionError(){
		thread(new Producer(input), false);
		System.out.println("Envió transaccion");
		return null;
	}
	
	public String sendRandomTransaction(){
		
		thread(new ProducerRandoms(), false);
		return null;		
	}
	
	
	public static void thread(Runnable runnable, boolean daemon) {
		Thread brokerThread = new Thread(runnable);
		brokerThread.setDaemon(daemon);
		brokerThread.start();
	}

	public static class Producer implements Runnable {

		private Transaction t;

		public Producer(Transaction t) {
			this.t = t;
		}

		public void run() {

			try {

				ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
						ActiveMQConnectionFactory.DEFAULT_BROKER_BIND_URL);

				Connection connection = connectionFactory.createConnection();
				connection.start();

				Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

				Destination destination = session.createQueue("QUEUE_NAME");

				MessageProducer producer = session.createProducer(destination);
				producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

				ObjectMessage message = session.createObjectMessage(t);
				producer.send(message);

				session.close();
				connection.close();

			} catch (Exception e) {
				System.out.println("Caught: " + e);
				e.printStackTrace();
			}
		}
	}
	
	public static class ProducerRandoms implements Runnable {


		public void run() {

			try {
				
				for(long i=0; i < 1000; i++){
					
					Transaction t = new Transaction();
					t.setId(i);


					java.util.Date date = new java.util.Date(); 
					java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("ddMMyyyy");
					java.text.SimpleDateFormat stf=new java.text.SimpleDateFormat("HHmmss");
					String fecha = sdf.format(date);
					String time = stf.format(date);

					t.setDate(fecha);
					t.setTime(time);
					
					if(i%3 == 0){
						t.setType("Compra");
					}else if(i%3 == 1){
						t.setType("Depósito");
					}else{
						t.setType("Consulta de saldo");
					}
					
					t.setCode("codigo");
					t.setCommerceName("comercio");
					t.setCardNumber("1111111");
					
					if(i%3 == 0){
						t.setCardType("Débito");
					}else if(i%3 == 1){
						t.setCardType("Crédito");
					}else{
						t.setCardType("Prepaga");
					}
					
					t.setCurrency( i%2 == 0 ? "UYU" : "USD");
					
					if(i%3 == 0){
						t.setDeviceType("POS");
					}else if(i%3 == 1){
						t.setDeviceType("WEB");
					}else{
						t.setDeviceType("ATM");
					}
					
					t.setAmount(2000.0);

					ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
							ActiveMQConnectionFactory.DEFAULT_BROKER_BIND_URL);
	
					Connection connection = connectionFactory.createConnection();
					connection.start();
	
					Session session = connection.createSession(false,
							Session.AUTO_ACKNOWLEDGE);
	
					Destination destination = session.createQueue("QUEUE_NAME");
	
					MessageProducer producer = session.createProducer(destination);
					producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	
					ObjectMessage message = session.createObjectMessage(t);
					producer.send(message);
	
					session.close();
					connection.close();
				
				}

			} catch (Exception e) {
				System.out.println("Caught: " + e);
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	public Transaction getInput() {
		return input;
	}

	public void setInput(Transaction input) {
		this.input = input;
	}	
	
}
