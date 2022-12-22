package vTiger.Pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePratice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Step 1 : Load the file location into file input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2 : Create object of properties from java.util package
		Properties pObj = new Properties();
		
		//Step 3 : load file input stream into properties
		pObj.load(fis);
		
		//Step 4 : read the value key
		String value = pObj.getProperty("browser");
		System.out.println(value);
		
		
	}

}
