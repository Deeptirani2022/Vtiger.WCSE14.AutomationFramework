package vTiger.Pratice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPratice {

	@Test(dataProvider = "PhonesData")
	public void dataProviderPratice(String Name, String Model, int price, int qty)
	{
		
		System.out.println("test run  => "+Name+" "+Model+" "+price+" "+qty);
	}
	
	@DataProvider(name = "PhonesData")
	
		public Object[][] getData()
		{
			Object[][] data =  new Object[3][4];
			
			data[0][0] = "Samsung";
			data[0][1] = "M15";
			data[0][2] = 25000;
			data[0][3] = 12;
			
			data[1][0] = "OnePlus";
			data[1][1] = "10Pro";
			data[1][2] = 70000;
			data[1][3] = 5;
			
			data[2][0] = "IPhone";
			data[2][1] = "14Pro";
			data[2][2] = 125000;
			data[2][3] = 11;
			
			return data;
		}
	}

