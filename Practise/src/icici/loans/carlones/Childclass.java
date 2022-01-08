package icici.loans.carlones;

public class Childclass extends FirstAbstract
{

	public static void main(String[] args) 
	{
		Childclass obj = new Childclass();
		obj.m1();
		obj.m2();
	}
	 public void m1()
	 {
		 System.out.println("i am m1 overriden from ChildClass");
	 }

	@Override
	public void m2() 
	{
		System.out.println("i am m2 overriden in Childclass");
	}
}
