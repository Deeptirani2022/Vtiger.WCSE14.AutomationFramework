package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String readFromSheet(String TCName, String columnName) throws EncryptedDocumentException, FileNotFoundException, IOException {
		String returnVal =null;
		Workbook wb = WorkbookFactory.create(new FileInputStream(IConstantantsUtility.ExcelFilePath));
		Sheet sheet = wb.getSheet("SheetName");
		int lastRowCount = sheet.getLastRowNum();
		Row header = sheet.getRow(0);
		Integer intTCName = null;
		Integer intColumnName=null;
		for (int i = 0; i < header.getLastCellNum(); i++) {
			boolean check1 = false;
			boolean check2 = false;
			Cell cell = header.getCell(i);
			if (cell.getStringCellValue().equalsIgnoreCase("TestCaseName")) {
				intTCName = i;
				check1 = true;
			}
			if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
				intColumnName = i;
				check2 = true;
			}
			if (check1 == true && check2 == true) {
				break;
			}

		}
		for (int i = 1; i < lastRowCount; i++) {
			
			Row row = sheet.getRow(i);
			Cell col = row.getCell(intTCName);
			if(col.getStringCellValue().equalsIgnoreCase(TCName)) {
				returnVal = row.getCell(intColumnName).getStringCellValue();
			}
			
		}
		return returnVal;

	}

}
