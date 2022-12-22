package vTiger.Pratice;

import org.testng.annotations.Test;

public class TestNGEnabled {

	@Test
	public void createCustomerTest()
	{
		System.out.println("Create customer");
	}
	
	@Test(enabled = false)
	public void modifyCustomerTest()
	{
		System.out.println("modify customer");
	}
	
	@Test
	public void deleteCustomerTest()
	{
		System.out.println("Delete customer");
	}
}
