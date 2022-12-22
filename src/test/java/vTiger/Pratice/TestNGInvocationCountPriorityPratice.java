package vTiger.Pratice;

import org.testng.annotations.Test;

public class TestNGInvocationCountPriorityPratice {

	@Test(invocationCount = 2,priority = 1)
	public void createCustomerTest()
	{
		System.out.println("Create customer");
	}
	
	@Test(invocationCount = 3,priority = -1)
	public void modifyCustomerTest()
	{
		System.out.println("modify customer");
	}
	
	@Test(priority = -9,invocationCount = 5)
	public void deleteCustomerTest()
	{
		System.out.println("Delete customer");
	}
}
