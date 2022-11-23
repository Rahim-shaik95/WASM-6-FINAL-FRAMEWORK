package vtigerPractive;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws Exception {
		
		//step 1 : read the file and load into fileInoutstream
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2 :create a workbook 
		Workbook wb =WorkbookFactory.create(fis);
		
	   // step 3 : navigate to required sheet 
		Sheet sh =wb.getSheet("Contacts");
		
		//step 4 :navigate to required row inside the sheet
		Row rw =sh.getRow(4);
		
		//step 5 :navigate to required cell inside the sheet
		Cell ce =rw.getCell(3);
		
		//Step6 :read the value present in the cell
		String value = ce.getStringCellValue();
		
		System.out.println(value);
		
	}
}
