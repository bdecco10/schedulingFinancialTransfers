package bdecco.cvc.financialscheduling.to;

import java.time.LocalDate;

public class SchendulingTransferTO {

	private String sourceAccount;
	private String destinationAccount;
	private double valueTransfer;
	private String rate;
	private LocalDate dateTransfer;
	private LocalDate dateAppointment;
	
	
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
	public double getValueTransfer() {
		return valueTransfer;
	}
	public void setValueTransfer(double valueTransfer) {
		this.valueTransfer = valueTransfer;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public LocalDate getDateTransfer() {
		return dateTransfer;
	}
	public void setDateTransfer(LocalDate dateTransfer) {
		this.dateTransfer = dateTransfer;
	}
	public LocalDate getDateAppointment() {
		return dateAppointment;
	}
	public void setDateAppointment(LocalDate dateAppointment) {
		this.dateAppointment = dateAppointment;
	}
	
}
