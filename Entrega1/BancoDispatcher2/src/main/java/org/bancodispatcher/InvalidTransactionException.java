package org.bancodispatcher;

public class InvalidTransactionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String causa;
	
	public InvalidTransactionException(String causa) {
		super(causa);
		this.setCausa(new String(causa.getBytes()));
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

}
