package icici.loans.homelones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedExceptionDemo 
{

	public static void m1() 
	{
		try 
		{
			BufferedReader b = new BufferedReader(new FileReader("d://abc.txt"));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		m1();
	}

}
