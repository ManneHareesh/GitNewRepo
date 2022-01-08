package icici.loans.carlones;

public class B extends A // is a relationship
{
	public void m2()
	{
		System.out.println("i am m2 from B");
	}
	
	public void m1()
	{
		System.out.println("i am overriden  m1 from A");
	} 

	public static void main(String[] args) 
	{
		A a = new A(); // has a relationship
		a.m1();
		System.out.println(a.x);
		
		B b = new B();
		b.m2();
		b.m1();
		System.out.println(b.x);
		
	// we can use parent class variable to refer or hold child class objects
		A Obj = new B();
		Obj.m1();
		
		
		
	}

}
