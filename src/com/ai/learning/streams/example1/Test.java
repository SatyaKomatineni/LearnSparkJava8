package com.ai.learning.streams.example1;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.ai.learning.lambda.example2.Person;

class Test {

	@org.junit.jupiter.api.Test
	void test() 
	{
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
	}
	
	
	/*
	 * Wetting the feet with streams. 
	 * printing a collection of objects as a stream
	 * use foreach()
	 * 
	 * Explanation 1
	 * ****************
	 * 1. A collection has a stream method
	 * 2. See Collection API for stream() method
	 * 3. It returns a Stream<E> of objects of that type
	 * 
	 * 4. Stream API is available in java.util.stream package
	 * 5. foreach() takes a Consumer<? super T> object/function
	 * 
	 * 6. So foreach() allows any object worker that 
	 * that knows how to work with a person or its super class.
	 * 
	 * 7. In other words any utility classes
	 * that were built before for the base classes
	 * can be supplied here without changing them.
	 * 
	 * 8. this is possible only because the foreach 
	 * function says so, allowing all base class workers
	 * to be eligible for the compiler to allow
	 * 
	 * 9. In this case below, the worker is a 
	 * lambda function so the base class argument
	 * is not needed
	 * 
	 * 10. But if we had a utility function that
	 * works with objects (base class of Person) 
	 * we could have passed that interface in.
	 * 
	 * 11. Ofcourse that interface should confirm
	 * to the Consumer<> interface.
	 * 
	 * 12. The Consumer<> interface has a single method signature
	 * 
	 * 13. Consumer has a single abstract method accept(T)
	 * 
	 * 14. This method below uses the anonymous lambda function
	 * as its equivalence.
	 * 
	 * 15. Using a method reference any method can be used in 
	 * its place as long as the signatures match, minus the method name.
	 * 
	 * 16. Method name doesn't have to match when expressed as a
	 * lambda function
	 * 
	 * 17. See the Method References samples to understand this better.
	 *    
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
	
	/*
	 * To demonstrate a custom collector
	 * See NameCollector class that enables this functionality
	 * 
	 * Approach used by collect
	 * 
	 * 1. Createa new one with the Supplier interface: 
	 * NameCollector::new
	 * 
	 * 2. This is also what is returned and must match
	 * NameCollector peopleNames
	 * 
	 * 3. Repeatedly call NameCollector::addName(Person)
	 * 
	 * 4. If parallel, allow 
	 * NameCollector::combine(NameCollector another)
	 * to enhance the original NameCollector
	 * 
	 * 5. Finally return NameCollector which 
	 * is instantiated in step 1
	 * 
	 */
	private void test5()
	{
		Collection<Person> people =
				Person.createRoster();
		NameCollector peopleNames = 
				people.stream()
					.collect(NameCollector::new
							,NameCollector::addName
							,NameCollector::combine);
		System.out.println("Test5: peoples names:" + peopleNames.names);
					
	}
	
	/*
	 * Use the generic Collectors to do the same as aboe
	 * 
	 */
	private void test6()
	{
		Collection<Person> people =
				Person.createRoster();
		List<String> peopleNames = 
				people.stream()
					.map(p -> p.name) //just get a stream of names
					.collect(Collectors.toList()); //stick them in a list
		
		System.out.println("Test6: peoples names:" + peopleNames);
		
	}

}//eof-class
