package icici.loans.collections;

import java.util.ArrayList;

final class ListDemo 
{

	public static void main(String[] args) 
	{
		
	ArrayList<Object> a = new ArrayList<Object>();
	a.add(10);
	a.add("Hari");
	a.add(12.3f);
	a.add(10);
	a.add(20);
	a.add(30);
	
	System.out.println(a);
	System.out.println(a.isEmpty());
	System.out.println(a.size());
	System.out.println(a.get(1));
	System.out.println(a.indexOf("Hari"));
	System.out.println(a.hashCode());
	
	for(int i=0;i<a.size();i++ ) 
	{
		System.out.println(a.get(i));
	}
	
	System.out.println(a);
	a.add(40);
	System.out.println(a);
	a.add(1, "sai");
	System.out.println(a);
	a.set(1, "saikeerthan");
	System.out.println(a);
	
	System.out.println(a.subList(2, 6));
	System.out.println(a);
	System.out.println(a.contains("Hari"));
	
	a.remove(2);
	System.out.println(a);
	
	a.remove("saikeerthan");
	System.out.println(a);
	
	a.clear();
	System.out.println(a);
	
	}
}
