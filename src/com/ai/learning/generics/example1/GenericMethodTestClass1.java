package com.ai.learning.generics.example1;

import java.util.Collection;

public class GenericMethodTestClass1 {
	
	//The following cannot accept collection<string>
	//We are intentionally saying we accept ONLY 
	//a collection of objects. It IS the contract.
	void printCollection(Collection<Object> c) 
	{
	  for (Object e : c)  
	  {
		  System.out.println(e);
	  }
	}
	
	//The following can accept collection<string>
	//Here we are SPECIFYING a looser contract
	void printCollection2(Collection<?> c) 
	{
	  for (Object e : c)  
	  {
		  System.out.println(e);
	  }
	}
	
	/*
	 * Invalid syntax.
	 * 
	 * So a question mark is valid only as an argument of 
	 * generic spcification that is between <?>
	 * 	 
	 */
	//void printAnObject(? anyObjectType)	{}
	
	/*
	 * Show a generic of generics
	 */
	void printGenericPairs(Collection<GenericPair<String,String> > pairs)
	{
		for (GenericPair<String,String> gp: pairs)
		{
			String first = gp.getFirst();
			String second = gp.getSecond();
			System.out.println(new StringPair(first,second));
		}
	}
	
	/*
	 * Show how to work with derived collections
	 * This can take objects of type "Simple" and also "Derived"
	 */
	void printAllSimples(Collection<? extends Simple> simples)
	{
		for (Simple s:simples)
		{
			//you can call any methods of Simple 
			System.out.println(s.basef1());
			//but you can't call s.derivedf2()
		}
	}

}//eof-class
