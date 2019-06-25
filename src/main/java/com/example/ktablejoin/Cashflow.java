package com.example.ktablejoin;

public class Cashflow {

	private String date;
	private float amount;
	private int contractId;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	@Override
	public String toString() {
		return "Cashflow{" +
				"date='" + date + '\'' +
				", amount=" + amount +
				", contractId=" + contractId +
				'}';
	}
}
