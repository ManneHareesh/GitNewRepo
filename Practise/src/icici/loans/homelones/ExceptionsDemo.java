package icici.loans.homelones;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExceptionsDemo 
{

	public static void main(String[] args) 
	{
	int nr,dr,result;
	Scanner sc = new Scanner(System.in);
	
	Exception obj = new ArithmeticException();
	
	while (true) 
	{
		System.out.println("Enter the nr value: ");
		nr = sc.nextInt();
		
		System.out.println("Enter the dr value: ");
		dr = sc.nextInt();
		
		try 
		{
			result = nr / dr;
			System.out.println(result);
			break;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally
		{
			System.out.println("I am final");
		}
	}
	}

}
