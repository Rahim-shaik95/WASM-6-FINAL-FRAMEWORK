package vTigerGenericLiberary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class contains generic methods to read and write the data into excel sheet
 * @author Rahim
 *
 */
public class ExcelFiLeLiberary {
	/**
	 * This method will read the data from excel sheet for the sheet name, row no
	 *  and cell no given by user
	 * @param Sheetname
	 * @param rowno
	 * @param cellno
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExceL(String Sheetname,int rowno,int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =new FileInputStream(IconstantsLiberary.exceLFilePath);
		Workbook wb =WorkbookFactory.create(fis);
		 Sheet sh=wb.getSheet(Sheetname);
		Row rw=sh.getRow(rowno);
		Cell ce= rw.getCell(cellno);
		 String value = ce.getStringCellValue();
		 wb.close();
		return value;
		
	}
	/**
	 * This method will provide the last row number utilized in a given sheet
	 * @param Sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String Sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =new FileInputStream(IconstantsLiberary.exceLFilePath);
		Workbook wb = WorkbookFactory.create(fis);
    	 Sheet sh= wb.getSheet(Sheetname);
          int  rowcount= sh.getLastRowNum();
          wb.close();
         return rowcount;
	}
	/**
	 * This method will write the data into excel sheet for user specified sheet,row no and cell no
	 * @param Sheetname
	 * @param rowno
	 * @param cellno
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName, int rowNo, int cellNo ,String value) throws EncryptedDocumentException,IOException{
		FileInputStream fis = new FileInputStream(IconstantsLiberary.exceLFilePath);
		Workbook wb =WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNo);
		Cell cel = rw.createCell(cellNo);
		cel.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IconstantsLiberary.exceLFilePath);
		wb.write(fos);
		wb.close();
		System.out.println("Data written successfully");
		
		 
	}
}
