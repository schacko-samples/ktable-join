package com.example.ktablejoin;

public class MyValueContainer {

	private Cashflow cashflow;
	private Contract contract;

	public MyValueContainer() {

	}

	public MyValueContainer(Cashflow cashflow, Contract contract) {
		this.cashflow = cashflow;
		this.contract = contract;
	}

	public Cashflow getCashflow() {
		return cashflow;
	}

	public void setCashflow(Cashflow cashflow) {
		this.cashflow = cashflow;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}
}
