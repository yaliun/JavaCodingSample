package com.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.main.Account;

public class AccountTest {
	
	@Test
	public void shouldHaveZero()
	{
		Account account = new Account();
		
		double current = account.getMoney();
		assertEquals(0,current,0.000001);
	}

	@Test
	public void shouldAddMoneyDeposit()
	{
		Account account = new Account();
		
		account.deposit(123.45);
		assertEquals(123.45,account.getMoney(),0.000001);

		account.deposit(200);
		assertEquals(323.45,account.getMoney(),0.000001);
	}

	@Test
	public void sholdMMM()
	{
		Account account = new Account();
		
		account.deposit(100);
		account.inposit(40);
		assertEquals(60,account.getMoney(),0.000001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotEnoughMoney()
	{
		Account account = new Account();
		
		account.deposit(100);
		account.inposit(140);
	}
}
