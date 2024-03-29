package org.bancodispatcher;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.xml.bind.annotation.XmlElement;

import org.producerweb.Transaction;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.mysql.jdbc.Driver;

public class LegacyAdapter {

	
	
	@SuppressWarnings("unchecked")
	public void process(Transaction m) throws Exception{
//			System.out.println("LLEGO AL LEGACY: " + m.getDeviceType());
			SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
			
			//dataSource.setDriverClass((Class<Driver>)Class.forName("com.mysql.jdbc.Driver"));
	        //dataSource.setDriverClass(com.mysql.jdbc.Driver);
			Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
			Object driver = BeanUtils.instantiateClass(clazz);
			dataSource.setDriver((Driver) driver);
	        dataSource.setUsername("root");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/middleware");
	        dataSource.setPassword(".lh2324");

	        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

//	        System.out.println("inserting");
//	        jdbcTemplate.execute("drop table customers if exists");
//	        jdbcTemplate.execute("create table customers(" +
//	                "id serial, first_name varchar(255), last_name varchar(255))");
//
//	        String[] names = "John Woo;Jeff Dean;Josh Bloch;Josh Long".split(";");
//	        for (String fullname : names) {
//	            String[] name = fullname.split(" ");
//	            System.out.printf("Inserting customer record for %s %s\n", name[0], name[1]);
//	            jdbcTemplate.update(
//	                    "INSERT INTO customers(first_name,last_name) values(?,?)",
//	                    name[0], name[1]);
//	        }
	        
	    	Long id = m.getId();
	    	String date = m.getDate();
	    	String time = m.getTime();
	    	
	    	String fullDate=date+" "+time;
	    		    	
	    	java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("ddMMyyyy HHmmss");
	    	java.text.SimpleDateFormat sqlSDF=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	java.util.Date newDate = sdf.parse(fullDate);
	    	fullDate = sqlSDF.format(newDate);
	    	
//	    	String sqlDate=newDate
//	    	
	    	//java.sql.Datetime sqlDate = new Datetime(newDate);

	    	   	    	
	    	
	    	//String time = m.getTime();
	    	String type = m.getType();
	    	if(type == "Compra"){
	    		type = "C";	    		
	    	}else if(type == "Depósito"){
	    		type = "D";	    		
	    	}else{
	    		type = "S"; 		
	    	}	    	
	    	
	    	String code = m.getCode();
	    	String commerceName= m.getCommerceName();
	    	String cardNumber =m.getCardNumber();
	    	
	    	String cardType = m.getCardType();
	    	cardType = cardType.substring(0,0);
	    	
	    	String currency = m.getCurrency();	    	
	    	Double amount=m.getAmount();
	    	
	        	
	    	String query="insert into transactions (id,datetime,transaction_type,commerce_code,commerce_name,card_number,card_type,currency_code,amount) values ("
	    				  + "'"+id+"'"+","+"'"+fullDate+"'"+","+"'"+type+"'"+","+"'"+code+"'"+","+"'"+commerceName+"'"+","+"'"+cardNumber+"'"+","+"'"+cardType+"'"+","+"'"+currency+"'"+","+"'"+amount+"'"+")";
	    			
//	    	 System.out.println(query);		
	        jdbcTemplate.update(query);	
	     	
	      
	        		
	        
	}
	
}
