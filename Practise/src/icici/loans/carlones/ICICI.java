package icici.loans.carlones;

public class ICICI implements Rbi, Rbi1

{
	public static void main(String[] args) 
	{
		ICICI i = new ICICI();
		i.deposit();
		i.withdrawl();
		i.ministatement();
	}

	@Override
	public void withdrawl() 
	{
		System.out.println("i am overriden withdrawal in ICICI");
	}

	@Override
	public void deposit() 
	{
		System.out.println("i am overriden deposit in ICICI");	
	}

	@Override
	public void ministatement() 
	{
		System.out.println("i am overriden ministatement in ICICI");	
	}

}
