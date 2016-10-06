package base;

import java.util.Date;

public class Account {
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated;
	
	//Assume all accounts have the same interest rate
	public static double generalAnnualInterestRate = 0;
	
	public Account() {
		
	}
	
	public Account(int id, double balance) {
		this.setId(id);
		this.setBalance(balance);
		this.annualInterestRate = generalAnnualInterestRate;
		this.dateCreated = new Date();
	}
	
	//Getters and Setters
	public int getId() {
		return this.id;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double getAnnualInterestRate() {
		return this.annualInterestRate;
	}
	
	public Date getDateCreated() {
		return this.dateCreated;
	}
	
	public void setId(int set) {
		this.id = set;
	}
	
	public void setBalance(double set) {
		this.balance = set;
	}
	
	public void setRate(double set) {
		generalAnnualInterestRate = set;
		this.annualInterestRate = set;
	}
	
	public double getMonthlyInterestRate() {
		return (this.annualInterestRate / 12);
	}
	
	public void withdraw(double amount) throws InsufficientFundsException {
		if (amount > this.balance)
			throw new InsufficientFundsException(amount - balance);
		else
			this.balance -= amount;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
}