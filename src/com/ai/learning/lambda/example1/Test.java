package com.ai.learning.lambda.example1;

import static org.junit.jupiter.api.Assertions.*;

class Test {

	@org.junit.jupiter.api.Test
	void test() 
	{
		test1();
		test2();
		test3();
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
}
