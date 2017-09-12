package bdecco.cvc.financialscheduling.entity;

import java.io.Serializable;

public class TransferEntity implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String sourceAccount;
	private String destinationAccount;
	private String valueTransfer;
	private String rate;
	private String dateTransfer;
	private String dateAppointment;
	
	public String getValueTransfer() {
		return valueTransfer;
	}
	public void setValueTransfer(String valueTransfer) {
		this.valueTransfer = valueTransfer;
	}
	public String getSourceAccount() {
		return sourceAccount;
	}
	public void setSourceAccount(String sourceAccount) {
		this.sourceAccount = sourceAccount;
	}
	public String getDestinationAccount() {
		return destinationAccount;
	}
	public void setDestinationAccount(String destinationAccount) {
		this.destinationAccount = destinationAccount;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getDateTransfer() {
		return dateTransfer;
	}
	public void setDateTransfer(String dateTransfer) {
		this.dateTransfer = dateTransfer;
	}
	public String getDateAppointment() {
		return dateAppointment;
	}
	public void setDateAppointment(String dateAppointment) {
		this.dateAppointment = dateAppointment;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
