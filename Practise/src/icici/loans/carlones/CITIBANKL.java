package icici.loans.carlones;

public class CITIBANKL implements Rbi
{

	public static void main(String[] args) 
	{
		CITIBANKL c = new CITIBANKL();
		c.deposit();
		c.withdrawl();
	}

	@Override
	public void withdrawl() 
	{
		System.out.println("i am overriden withdrawl in CITIBANKL");
	}

	@Override
	public void deposit() 
	{
		System.out.println("i am overriden deposit in CITIBANKL");	
	}

}
