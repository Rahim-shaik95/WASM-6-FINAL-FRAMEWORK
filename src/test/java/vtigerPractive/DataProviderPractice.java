package vtigerPractive;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@Test(dataProvider ="phones")
	public void addToCartTest(String name ,String  model, int price , int qty)
	{
		System.out.println("phone name is : "+name+"model : "+model+"price : "+price +"quantity"+qty);
	}
	
	@DataProvider(name="phones")
	  public Object[][] getdata()
	  {
		Object [][] data =new Object[3][4];
		
		data[0][0] ="poco";
		data[0][1]="f1";
		data[0][2]=20000;
		data[0][3]=10;
		
		data[1][0] ="mi";
		data[1][1]="011";
		data[1][2]=22000;
		data[1][3]=12;
		
		data[2][0] ="vivo";
		data[2][1]="456";
		data[2][2]=22000;
		data[2][3]=15;
		return data;
		
	  }
}
