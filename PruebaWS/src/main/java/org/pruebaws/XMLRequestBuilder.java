package org.pruebaws;

import org.sender.Transaction;

public class XMLRequestBuilder {


	
//	private Jaxb2Marshaller marshaller;
//	
//	public XMLRequestBuilder(Jaxb2Marshaller marshaller){
//		this.marshaller = marshaller;
//	}
	
	public String transform(Transaction t){
		
		String ret = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://services.banco.org\">"
					+ "<soapenv:Header/>"
					+ "<soapenv:Body>"
					+"<ser:sendTransaction>"
		         	+ "<ser:t>"
		            + "<ser:amount>"+ t.getAmount() +"</ser:amount>"
		            + "<ser:cardNumber>"+ t.getCardNumber() +"</ser:cardNumber>"
		            + "<ser:cardType>"+ t.getCardType() +"</ser:cardType>"
		            + "<ser:code>"+ t.getCode() +"</ser:code>"
		            + "<ser:commerceName>"+ t.getCommerceName() +"</ser:commerceName>"
		            + "<ser:currency>"+ t.getCurrency() +"</ser:currency>"
		            + "<ser:date>"+ t.getDate() +"</ser:date>"
		            + "<ser:deviceType>"+ t.getDeviceType() +"</ser:deviceType>"
		            + "<ser:id>"+ t.getId() +"</ser:id>"
		            + "<ser:time>"+ t.getTime() +"</ser:time>"
		            + "<ser:type>"+ t.getType() +"</ser:type>"
		         + "</ser:t>"
		      + "</ser:sendTransaction>"
		   + "</soapenv:Body>"
		+ "</soapenv:Envelope>";
		
		return ret;
	}

}
