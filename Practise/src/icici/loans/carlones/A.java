package icici.loans.carlones;

public class A 
{
	 public int x=100;
	
	 public void m1()
	{
		System.out.println("i am m1 from A");
	} 
	 
	public static void main(String[] args) 
	{
		A a = new A();
		a.m1();
		System.out.println(a.x);
	}
 
}
