package com.ai.learning.lambda.example1;

import java.util.function.Supplier;

class Test {

	@org.junit.jupiter.api.Test
	void test() 
	{
		test1();
		test2();
		test3();
		test5();
		test6();
		test61();
		test62();
		test7();
	}

	/*
	 * Traditional way of implementing an SMI
	 */
	private void test1()
	{
		SingleMethodInterface smi = new DefaultSMImplementation();
		smi.doSomeThing();
	}

	/*
	 * Instantiating an interface as a lambda function 
	 */
	private void test2()
	{
		SingleMethodInterface smi = () -> 
		{
			System.out.println("Hello world");
		};
		smi.doSomeThing();
	}
	
	/*
	 * Calling it inline for taking a function pointer
	 */
	private void test3()
	{
		test4(
				()->{
					System.out.println("From test3");
				}
		);
	}
	private void test4(SingleMethodInterface smi)
	{
		smi.doSomeThing();
	}
	
	
	private void test5()
	{
		//Implementing interface methods with input and return values
		SingleMethodInterface2 smi2 = (String ins) -> {
			return ins.concat(" + concatenated string");
		};
		
		//Use of default method
		String s = smi2.doSomeThing(smi2.getSomeReadOnlyString());
		System.out.println("From Test 5:" + s);
	}
	
	//Demonstrate the inner class-ness of lambda functions 
	String instanceVar = " + Instance variable";
	private void test6()
	{
		//Implementing interface methods with input and return values
		SingleMethodInterface2 smi2 = (String ins) -> {
			String s = ins.concat(" + concatenated string");
			s = s.concat(instanceVar);
			return s;
		};
		
		//Use of default method
		String s = smi2.doSomeThing(smi2.getSomeReadOnlyString());
		System.out.println("From Test 6:" + s);
	}
	
	//Demo target typing, where types are avoided 
	private void test61()
	{
		//Implementing interface methods with input and return values
		SingleMethodInterface2 smi2 = (ins) -> {
			String s = ins.concat(" + concatenated string");
			s = s.concat(instanceVar);
			return s;
		};
		
		//Use of default method
		String s = smi2.doSomeThing(smi2.getSomeReadOnlyString());
		System.out.println("From Test 61:" + s);
	}
	
	//Demo target typing, where types are avoided
	//Parentheses is omitted for a single argument
	private void test62()
	{
		//Implementing interface methods with input and return values
		SingleMethodInterface2 smi2 = ins -> {
			String s = ins.concat(" + concatenated string");
			s = s.concat(instanceVar);
			return s;
		};
		
		//Use of default method
		String s = smi2.doSomeThing(smi2.getSomeReadOnlyString());
		System.out.println("From Test 62:" + s);
	}	

	public void test7()
	{
		Supplier<Integer> ip = () -> 42;
		System.out.println("Test7: Using supplier:" + ip.get());
	}

}
