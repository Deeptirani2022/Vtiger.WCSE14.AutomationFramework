package vTiger.Pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetPratice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException  {
		
		//Step 1 : load file location input stream 
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2 : Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3 : Navigate to required sheet
		Sheet sh = wb.getSheet("Contacts");
		
		//Sheet 4 : Navigate to required row
		Row rw = sh.getRow(4);
		
		//Step 5 : Navigate to required cell
		Cell ce = rw.getCell(2);
		
		//Step 6 : Capture the data present in that cell
		String value = ce.getStringCellValue();
		System.out.println(value);
		
		String value1 = rw.getCell(3).getStringCellValue();
		System.out.println(value1);
	}
}
