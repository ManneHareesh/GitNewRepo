package icici.loans.edulones;

import java.util.Scanner;

public class StudentCalculations 
{

	public static void main(String[] args) 
	{
		float a,b,res;
		char choice;
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.println("1. Addition\n");
			System.out.println("2. Subtraction\n");
			System.out.println("3. Multiplication\n");
			System.out.println("4. Division\n");
			System.out.println("5. Exit\n");
			System.out.println("Enter your choice:  ");
			choice = sc.next().charAt(0);
			switch(choice)
			{
			
		case '1' : System.out.println("Enter two numbers: ");
			a = sc.nextFloat();
			b = sc.nextFloat();
			res = a+b;
			System.out.println("Result = " +res);
			break;
			
		case '2' : System.out.println("Enter two numbers: ");
			a = sc.nextFloat();
			b = sc.nextFloat();
			res = a-b;
			System.out.println("Result = " +res);
			break;
				
		case '3' : System.out.println("Enter two numbers: ");
			a = sc.nextFloat();
			b = sc.nextFloat();
			res = a*b;
			System.out.println("Result = " +res);
			break;
			
		case '4' : System.out.println("Enter two numbers: ");
			a = sc.nextFloat();
			b = sc.nextFloat();
			res = a/b;
			System.out.println("Result = " +res);
			break;
			
		case '5' : System.exit(0);
			break;
			
		default : System.out.println("Wrong Choice!!!");
			break;
		
			}
			System.out.println("\n.....................................\n");
		}while(choice != 5);

	}

}
