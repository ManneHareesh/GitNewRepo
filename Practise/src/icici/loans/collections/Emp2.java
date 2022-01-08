package icici.loans.collections;

public class Emp2 
{
	int eno;
	String ename;
	
	public Emp2(int eno, String ename) 
	{
		super();
		this.eno = eno;
		this.ename = ename;
	}
	
	public void display()
	{
		System.out.println("EmpId : " + eno + "  " +"Ename :" + ename);
	}
	
	public static void main(String[] args) 
	{
		Emp2 e = new Emp2(100, "Hareesh");
		e.display();
		
	}

}
