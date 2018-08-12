package com.ai.learning.streams.example1;

import java.util.Collection;

import com.ai.learning.lambda.example2.Person;

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
	
	/*
	 * Find the average age
	 */
	private void test3()
	{
		Collection<Person> people =
				Person.createRoster();
		double average = 
				people.stream()
			.mapToInt(p -> p.getAge())
			.average()
			.getAsDouble();
		
		System.out.println("Test3: average age:" + average);
	}
	/*
	 * Find the average age
	 * Use a method reference
	 * the method reference is an instance method
	 * The passed object is implied
	 * Notice getAge() takes no argument
	 * The input object is the target of that getAge()
	 * 
	 * or saying: Call that method on the incoming object
	 */
	private void test4()
	{
		Collection<Person> people =
				Person.createRoster();
		double average = 
				people.stream()
			.mapToInt(Person::getAge)
			.average()
			.getAsDouble();
		
		System.out.println("Test4: average age:" + average);
	}

}//eof-class
