package com.ai.learning.generics.example1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Test {
	@org.junit.jupiter.api.Test
	void test() 
	{
		test1();
		test2();
		test3();
		test4();
		test5();
		test7();
		test8();
		test9();
		test10();
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
	
	/*
	 * Test a generic method for derived types
	 */
	private void test5()
	{
		System.out.println("Test5 begins.");
		Collection<Simple> simples = new ArrayList<Simple>();
		simples.add(new Simple());
		simples.add(new Simple());
		
		GenericMethodTestClass1 c = new GenericMethodTestClass1();
		c.printAllSimples(simples);
		
		//You can also use the same function print the derived assets
		Collection<Derived> children = new ArrayList<Derived>();
		children.add(new Derived());
		children.add(new Derived());
		c.printAllSimples(children);
		
		System.out.println("Test5 ends.");
	}
	
	/*
	 * Test static variables in generics
	 * There is only ONE class instance of a generics class!
	 */
	private void test6()
	{
		GenericPair<Integer, Integer> intPair = 
				new GenericPair<Integer, Integer>(4,5);
		GenericPair<String, String> stringPair = 
				new GenericPair<String, String>("4","5");
		
		
		//This is correct
		String name = GenericPair.NAME;
		//No such thing to get to intPair.NAME
		//Or stringPair.NAME
		//Nor GenericPair<Integer, Integer>.NAME
		
		//This is an error
		//String name = GenericPair<Integer, Integer>.NAME;
		
		//So print out the name
		System.out.println("Test6:" + name);
	}
	
	/*
	 * Understant type casting of generics
	 * Due to the nature of a single class instance
	 */
	private void test7()
	{
		GenericPair<Integer, Integer> intPair = 
				new GenericPair<Integer, Integer>(4,5);
		GenericPair<String, String> stringPair = 
				new GenericPair<String, String>("4","5");
		
		
		GenericPair<Integer, Integer> intPair1;
		GenericPair<String, String> stringPair2;
		
		Object stringPairObject = stringPair;
		Object intPairObject = intPair;
		
		intPair1 = (GenericPair<Integer, Integer>)intPair;
		
		//Compiler error: Makes sense two different types
		//intPair1 = (GenericPair<Integer, Integer>)stringPair;
		
		//Succeeds at compile time and run time
		intPair1 = (GenericPair<Integer, Integer>)stringPairObject;
		intPair1 = (GenericPair)stringPair;
		
		//fails at run time as getFirst() returns a string
		//tries to convert it to an int
		//int first = intPair1.getFirst();
		
		System.out.println("Test7");
	}
	
	/*
	 * Better instantiation
	 */
	private void test8()
	{
		GenericPair<Integer, Integer> intPair = 
				new GenericPair<>(4,5);
		System.out.println("Test8:" + intPair);
	}
	
	/*
	 * Test add operations on generic collections
	 */
	private void test9()
	{
		//See c.addAllSimples() mehod to see what it does
		GenericMethodTestClass1 c = new GenericMethodTestClass1();
		c.addAllSimplesWrong(new ArrayList<Simple>());
		
		Simple s = new Simple();
		Derived d = new Derived();
		GenericPair<Integer,Integer> intPair = new GenericPair<>(1,2);
		
		List<Simple> simples = new ArrayList<>();
		c.addAllSimplesFixed(simples, s);
		c.addAllSimplesFixed(simples, d);
		
		//Compiler error
		//Method type is inferred
		//c.addAllSimplesFixed(simples, intPair);
		
		List<Derived> deriveds = new ArrayList<>();
		//fails
		//c.addAllSimplesFixed(deriveds, s);
		c.addAllSimplesFixed(deriveds, d);
		
		System.out.println("Test9:" + simples);
	}
	
	private void test10()
	{
		//warning below
		List stringList = new ArrayList();
		
		//Doesn't know a hint
		//compile error
		//List stringList = new ArrayList<>();
		
		//Assigning to a traditional list
		//compiler warning
		List stringList1 = new ArrayList<String>();
		
		//This is fine
		List<String> stringList2 = new ArrayList<>();
		
		//compile error
		//if (stringList instanceof List<String>) {}
		
		if (stringList instanceof List) 
		{
			System.out.println("Test10:Passes instance test");
		}
		
		//if (stringList2 instanceof List<String>) {} 
		if (stringList2 instanceof List) 
		{
			System.out.println("Test10:Passes instance test");
		}
		
		//Casting: compiler warnings
		List<String> stringList3;
		stringList3 = (List<String>)stringList;
		stringList3 = (List)stringList;
		stringList3 = (List)stringList2;
		
		//No compiler warning
		stringList3 = (List<String>)stringList2;
		
		//compiler warnings
		Object stringList4 = stringList2;
		stringList3 = (List<String>)stringList4;
		stringList3 = (List)stringList4;

	}
}//eof-class
