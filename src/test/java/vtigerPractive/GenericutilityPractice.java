package vtigerPractive;

import java.util.Random;

public class GenericutilityPractice {

	public static void main(String[] args) {    //calling or caller function 
		
		Random ran =new Random();
		int random =ran.nextInt(300);
		System.out.println(random);
		
		int ran1 =ran.nextInt(100);
		System.out.println(ran1);
		
		int value  =GenericutilityPractice.run(random,ran1);
		System.out.println(value);
	}
	
	public static  int run(int a,int b)  //called function
	{
		int c=a+b;
		return c;
	}
}
