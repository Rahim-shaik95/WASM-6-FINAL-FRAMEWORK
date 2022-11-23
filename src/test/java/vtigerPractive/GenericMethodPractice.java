package vtigerPractive;

import java.io.IOException;

import vTigerGenericLiberary.ExcelFiLeLiberary;
import vTigerGenericLiberary.JavaLiberary;
import vTigerGenericLiberary.PropertyFileLiberary;

public class GenericMethodPractice {

	public static void main(String[] args) throws IOException {
		
		JavaLiberary jLib =new JavaLiberary();
		PropertyFileLiberary pLib =new PropertyFileLiberary();
		ExcelFiLeLiberary eLib=new ExcelFiLeLiberary();
		
	    String date =jLib.getSystemDate();
		System.out.println(date);
		String date1 =jLib.getSystemDateInFormat();
		System.out.println(date1);
		
	    String value =pLib.readDataFromPropertiesFile("browser");
		 System.out.println(value);
		String value1 =pLib.readDataFromPropertiesFile("username");
		System.out.println(value1);
		
		String val=eLib.readDataFromExceL("Organization", 1, 2);
		System.out.println(val);
		int  row= eLib.getRowCount("Contacts");
		System.out.println(row);
		
	    	eLib.writeDataIntoExcel("Organization",7 ,8, "Aro");
	    	
	    	 
	        
		
	}
	
	
}
