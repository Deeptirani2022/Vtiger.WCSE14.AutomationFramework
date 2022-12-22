package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**This class contains generic methods related to excel sheet
 * @author Deepti
 * 
 * */
public class ExcelFileUtility {
	
	/**
	 * This method will take the value from excel sheet for respective sheet name
	 * row number and cell number
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum 
	 * @param cellNum
	 * @return 
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * */
	
	public String readDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNum);
		Cell ce = rw.getCell(cellNum);
		String value = ce.getStringCellValue();
		wb.close();
		return value;
	}

	/**
	 * This method will take the value from excel sheet for respective sheet name
	 * row number and cell number
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum 
	 * @param cellNum
	 * @return 
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * */
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		wb.close();
		return rowCount;
	}
	
	public void writeDataIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNum);
		Cell ce = rw.createCell(cellNum);
		
		ce.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(IConstantantsUtility.ExcelFilePath);
		wb.write(fos);
		
		wb.close();
		fos.close();
	}

	/**
	 * This method will read multiple data into the data provider
	 * @param sheetName
	 * @return
	 * 
	 * 
	 * **/
	
	public Object[][] readMultipleDataIntoDataProvider(String sheetName) {
		
		try {
			FileInputStream fis = new FileInputStream(IConstantantsUtility.ExcelDataProviderPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet(sheetName);
			int lastRow = sheet.getLastRowNum();//-----row
			int lastCell = sheet.getRow(0).getLastCellNum();//-----Cell
			
			Object[][] data = new Object[lastRow][lastCell];
			
			for(int i = 0; i<lastRow; i++)
			{
				for(int j=0; j<lastCell; j++)
				{
					 data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
				}
			}
			
			return data;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

}
