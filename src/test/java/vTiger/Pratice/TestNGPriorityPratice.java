package vTiger.Pratice;

import org.testng.annotations.Test;

public class TestNGPriorityPratice {

	@Test(priority = 1)
	public void createCustomerTest()
	{
		System.out.println("Create customer");
	}
	
	@Test(priority = -1)
	public void modifyCustomerTest()
	{
		System.out.println("modify customer");
	}
	
	@Test(priority = -9)
	public void deleteCustomerTest()
	{
		System.out.println("Delete customer");
	}
}
