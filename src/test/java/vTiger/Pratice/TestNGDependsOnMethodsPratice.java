package vTiger.Pratice;

import org.testng.annotations.Test;

public class TestNGDependsOnMethodsPratice {

	@Test
	public void createCustomerTest()
	{
		System.out.println("Create customer");
	}
	
	@Test(dependsOnMethods = "createCustomerTest")
	public void modifyCustomerTest()
	{
		System.out.println("modify customer");
	}
	
	@Test(dependsOnMethods = {"CreateCustomerTest","modifyCustomerTest"})
	public void deleteCustomerTest()
	{
		System.out.println("Delete customer");
	}
}
