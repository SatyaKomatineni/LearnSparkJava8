package com.ai.learning.generics.example1;

import java.io.Console;
import java.util.function.Supplier;

class Test {
	@org.junit.jupiter.api.Test
	void test() 
	{
		test1();
		test2();
	}

	/*
	 * Test generic pair
	 */
	private void test1()
	{
		GenericPair<String,String> stringPair
			= new GenericPair<String,String>("first", "second");
		System.out.println("Test1:" + stringPair);
	}

	/*
	 * Test GenericPair with different Object types
	 */
	private void test2()
	{
		GenericPair<String,Integer> aPair
			= new GenericPair<String,Integer>("first", 42);
		
		System.out.println("Test2:" + aPair);
		
		//Access pair variables
		int second = aPair.getSecond();
		String first = aPair.getFirst();
		
		GenericPair<String,Integer> newPair
		= new GenericPair<String,Integer>(first,second);
		
		System.out.println("Test2:" + newPair);
	}
}//eof-class
