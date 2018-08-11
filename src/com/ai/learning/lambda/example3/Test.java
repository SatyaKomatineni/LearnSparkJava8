package com.ai.learning.lambda.example3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.ai.learning.generics.example1.Simple;
import com.ai.learning.lambda.example2.Person;

class Test {

	@org.junit.jupiter.api.Test
	void test() 
	{
		test1();
		test2();
	}
	
	
	/*
	 * Wetting the feet with streams. 
	 * printing a collection of objects as a stream
	 * use foreach()
	 */
	private void test1()
	{
		Collection<Person> people =
				Person.createRoster();
		people.stream().forEach((p) -> {
				System.out.println("Test1: Person:" + p);
			}
		);
	}

	/*
	 * Use filtering. 
	 * Uses predicate functions
	 */
	private void test2()
	{
		Collection<Person> people =
				Person.createRoster();
		people.stream()
			//Notice syntax simplification
			.filter(p -> p.gender == Person.Sex.FEMALE )
			.forEach(p -> System.out.println("Test2: Female only:" + p));
	}
	

}//eof-class
