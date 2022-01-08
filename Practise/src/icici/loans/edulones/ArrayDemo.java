package icici.loans.edulones;

import java.util.Scanner;

public class ArrayDemo 
{

	public static void main(String[] args) 
	{
		/*
		 * int[] a = {10, 20, 30, 40};
		 * 
		 * for(int i=0; i<a.length; i++)
		 * 
		 * System.out.println("a["+i+"]=" +a[i]);
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("enther the size of the arry");
		int asize = sc.nextInt();
		
		int[] a = new int [asize];
		int sum = 0;
		
		System.out.println("enter the array elements");
		for(int i=0; i<a.length;i++)
		{
		a[i] = sc.nextInt();
		System.out.println("a["+i+"]=" + a[i]);
		sum = sum+a[i];
		}
		
		System.out.println("sum fo the array is :" +sum);
	}

}
