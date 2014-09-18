package org.bancows;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="Transaction")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Transaction implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(required=true)
	private Long id;
	@XmlElement(required=true)
	private String date;
	@XmlElement(required=true)
	private String time;
	@XmlElement(required=true)
	private String type;
	@XmlElement(required=true)
	private String code;
	@XmlElement(required=true)
	private String commerceName;
	@XmlElement(required=true)
	private String cardNumber;
	@XmlElement(required=true)
	private String cardType;
	@XmlElement(required=true)
	private String currency;
	@XmlElement(required=true)
	private String deviceType;
	@XmlElement(required=true)
	private Double amount;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCommerceName() {
		return commerceName;
	}
	public void setCommerceName(String commerceName) {
		this.commerceName = commerceName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}