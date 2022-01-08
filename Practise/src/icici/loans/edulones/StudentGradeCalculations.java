package icici.loans.edulones;

import java.util.Scanner;

public class StudentGradeCalculations 
{

	public static void main(String[] args) 
	{
		int[] mark = new int[5];
		float sum = 0, avg;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("enter marks obtained in 5 subjects: ");
		for (int i=0; i<5; i++)
		{
			mark[i]= scan.nextInt();
			sum = sum + mark[i];
		}
		
		System.out.println("sum of 5 subjects is = " +sum);
		
		avg = sum/5;
		System.out.println("Average of 5 subjects is =" +avg);
		
		System.out.println("your Grade is");
		if(avg>80)
		{
			System.out.println("A");
		}
		else if(avg>60 && avg<=80)
		{
			System.out.println("B");	
		}
		else if(avg>40 && avg<=60)
		{
			System.out.println("C");	
		}
		else
		{
			System.out.println("D");
		}
	}

}
