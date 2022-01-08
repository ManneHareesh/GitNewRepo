package icici.loans.collections;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorDemo 
{

	public static void main(String[] args) 
	{
		ArrayList<String> s = new ArrayList<String>();
		s.add("oracle");
		s.add("oaktech");
		s.add("softq");
		s.add("vmware");
		
		System.out.println(s);
		
		ListIterator<String> val = s.listIterator();
		while(val.hasNext())
		{
			 String var = val.next();
			 if(var.equals("vmware"))
				 val.set("durgasoft");
			 else
				 val.remove(); 
		}
		System.out.println(s);
	}

}
