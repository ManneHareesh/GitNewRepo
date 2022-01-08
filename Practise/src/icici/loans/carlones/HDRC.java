package icici.loans.carlones;

public class HDRC implements Rbi

{

	public static void main(String[] args) 
	{
		HDRC h = new HDRC();
		h.deposit();
		h.withdrawl();
	}

	@Override
	public void withdrawl() 
	{
		System.out.println("i am overriden withdrawl in HDRC");	
	}

	@Override
	public void deposit() 
	{
		System.out.println("i am overriden deposit in HDRC");	
	}

}
