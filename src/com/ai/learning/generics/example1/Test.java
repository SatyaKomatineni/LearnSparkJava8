package com.ai.learning.generics.example1;

import java.util.ArrayList;
import java.util.List;

class Test {
	@org.junit.jupiter.api.Test
	void test() 
	{
		test1();
		test2();
		test3();
		test4();
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

	/*
	 * Test a resolved generics derived class
	 * Where the generics are hidden.
	 */
	private void test3()
	{
		StringPair stringPair
			= new StringPair("first", "second");
		System.out.println("Test3:" + stringPair);
	}
	
	/*
	 * Test a few generic methods (not classes)
	 */
	private void test4()
	{
		GenericMethodTestClass1 c = new GenericMethodTestClass1();
		List<String> stringList = new ArrayList<String>();
		stringList.add(new String("1"));
		
		List<Object> objectList = new ArrayList<Object>();
		objectList.add(new String("1"));
		objectList.add(new String("2"));
		objectList.add(new String("3"));
		
		
		//Following fails
		//c.printCollection(stringList);
		
		System.out.println("Test4 begins.");
		//Following both methods work
		c.printCollection(objectList);
		c.printCollection2(stringList);
		
		System.out.println("Test4 ends.");
	}
}//eof-class
