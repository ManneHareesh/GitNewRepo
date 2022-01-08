package icici.loans.carlones;

public class SecondClass 
{
	int a = 100, b = 200, result;
	
	public void add()
	{
		result = a+b;
		System.out.println("addition of a and b is: " + result);
	}
	public void sub()
	{
		result = a-b;
		System.out.println("subtraction of a and b is: " + result);
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Hello");
		 SecondClass obj = new SecondClass();
		 obj.add();
		 obj.sub();
	}

}
