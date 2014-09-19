package org.producerweb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="transactionMB")
@RequestScoped
public class TransactionMB {

	private Transaction input;
	
	@PostConstruct
	public void init(){
		input = new Transaction();		
	}
	
	public String sendTransaction(){
		//TODO
		System.out.println("Envio transaccion");
		return null;
	}
	
	public Transaction getInput() {
		return input;
	}

	public void setInput(Transaction input) {
		this.input = input;
	}	
	
}
