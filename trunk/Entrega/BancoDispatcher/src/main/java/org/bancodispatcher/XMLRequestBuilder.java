package org.bancodispatcher;

import java.util.List;

import org.sender.Transaction;

public class XMLRequestBuilder {


	
//	private Jaxb2Marshaller marshaller;
//	
//	public XMLRequestBuilder(Jaxb2Marshaller marshaller){
//		this.marshaller = marshaller;
//	}
	
	public String transformWS(List<Transaction> l) {

		String ret = "<ban:receive xmlns:ban=\"http://bancows.org/\">";

		for (Transaction t : l) {

			ret += "<transaction>";
			ret += "<id>"+ t.getId() +"</id>";
			ret += "<date>"+ t.getDate() +"</date>";
			ret += "<time>"+ t.getTime() +"</time>";
			ret += "<type>"+ t.getType() +"</type>";
			ret += "<code>"+ t.getCode() +"</code>";
			ret += "<commerceName>"+ t.getCommerceName() +"</commerceName>";
			ret += "<cardNumber>"+ t.getCardNumber() +"</cardNumber>";
			ret += "<cardType>"+ t.getCardType() +"</cardType>";
			ret += "<currency>"+ t.getCurrency() +"</currency>";
			ret += "<deviceType>"+ t.getDeviceType() +"</deviceType>";
			ret += "<amount>"+ t.getAmount() +"</amount>";
			ret += "</transaction>";

		}

		ret += "</ban:receive>";

		return ret;

	}

}
