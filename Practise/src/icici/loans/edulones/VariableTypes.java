package icici.loans.edulones;

public class VariableTypes 
{
	// primitive variable
	int x = 100; // instance or non-static or instance-global variable 
	static String cname = "vmware"; // static variable or static global-variable
	static float roi = 8.5f; // static variable or static global-variable
	static VariableTypes obj;  // static non primitive variable - defining class object globally
	
	public void m1()
	{
		int x = 200; // local variable
		System.out.println(x);
		
		System.out.println(x);
		System.out.println(this.x); // it will access instance variable
		System.out.println(cname);
		System.out.println(VariableTypes.cname);
	}
	
	public static void m2()
	{
		VariableTypes obj = new VariableTypes(); // non-primitive local variable
		System.out.println(obj.x);
		System.out.println(VariableTypes.cname);
	}
	
	public static void main(String[] args) 
	{
	VariableTypes obj = new VariableTypes(); // non-primitive local variable
	System.out.println(obj.x);
	System.out.println(VariableTypes.cname); 
	System.out.println(roi);
	}
}
