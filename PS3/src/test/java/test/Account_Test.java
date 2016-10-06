package test;

import base.InsufficientFundsException;
import base.Account;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Account_Test {
	
	static Account TestAccount;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		TestAccount = new Account(1122,20000);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		TestAccount.getId();
		TestAccount.getBalance();
		TestAccount.getAnnualInterestRate();
		TestAccount.getDateCreated();
		TestAccount.setBalance(20000);
		TestAccount.setRate(4.5);
		TestAccount.setId(1122);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAccount() throws InsufficientFundsException {
		TestAccount.withdraw(2500);
		TestAccount.deposit(3000);
		System.out.println("The balance is: " + TestAccount.getBalance()
		+ "\nThe monthly interest rate is: " + TestAccount.getMonthlyInterestRate()
		+ "\nThe account's creation date is: " + TestAccount.getDateCreated());

	}
	@Test(expected=InsufficientFundsException.class)
	public void testAccount2() throws InsufficientFundsException {
		TestAccount.withdraw(500000.0);
	}

}

