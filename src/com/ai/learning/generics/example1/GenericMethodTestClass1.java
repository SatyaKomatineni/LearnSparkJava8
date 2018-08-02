package com.ai.learning.generics.example1;

import java.util.Collection;

public class GenericMethodTestClass1 {
	
	//The following cannot accept collection<string>
	void printCollection(Collection<Object> c) 
	{
	  for (Object e : c)  
	  {
		  System.out.println(e);
	  }
	}
	
	//The following can accept collection<string>
	void printCollection2(Collection<?> c) 
	{
	  for (Object e : c)  
	  {
		  System.out.println(e);
	  }
	}
}//eof-class
