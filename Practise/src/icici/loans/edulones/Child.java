package icici.loans.edulones;

 class Parent
 {
 	public void workhard()
 	{
 		System.out.println("Parent: wake up early and go to college");
 	}
 		
 	public void care()
 	{
 		System.out.println("Parent: Atmost care");
 	}

 }
public class Child extends Parent
{
	public void workhard()
 	{
 		System.out.println("Child: wake up any time and go to pub");
 	}
 		
 	public void care()
 	{
 		System.out.println("Child: i am in love");
 	}
 	
 	public static void main(String[] args) 
 	{
		Child c = new Child();
		c.workhard();
		c.care();
		
		Parent p = new Parent();
		p.workhard();
		p.care();
		
		Parent obj = new Child();
		obj.care();
		obj.workhard();
	}
}



