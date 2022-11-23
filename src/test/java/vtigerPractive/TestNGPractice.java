package vtigerPractive;

import org.testng.annotations.Test;

public class TestNGPractice {

	@Test(priority=3)
	public void createAccount()
	{
		System.out.println("account is created");
	}
	@Test(priority=2)
	public void modifyAccount()
	{
		System.out.println("account is modified ");
	}
	@Test(priority=1)
	public void deleteAccount()
	{
		System.out.println("account is deleted");
	}
}
