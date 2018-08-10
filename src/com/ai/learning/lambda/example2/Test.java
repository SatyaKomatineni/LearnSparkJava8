package com.ai.learning.lambda.example2;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

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
		test7();
		test8();
	}

	/*
	 * Exercise method references
	 * Sort an array using lambda function
	 */
	private void test1()
	{
		List<Person> peopleRoster = Person.createRoster();
		
		//Get an array of right size
		Person peopleArray[] = new Person[peopleRoster.size()];
		//populate it
		peopleRoster.toArray(peopleArray);
		
		//Prints well
		System.out.println("Test1: Unsorted" + peopleRoster);
		
		//Only prints the array address
		System.out.println("Test1:" + peopleArray);
		
		List<Person> newPeopleRoster = Arrays.asList(peopleArray);
		System.out.println("Test1:" + newPeopleRoster);
		
		//This will sort the array in place
		Arrays.sort(peopleArray, 
				(a,b) -> a.birthday.compareTo(b.birthday)
				);
		System.out.println("Test1:" + Arrays.asList(peopleArray));
		
	}

	/*
	 * Uses static method call from a lambda function
	 */
	private void test2()
	{
		Person peopleArray[] = Person.createRoseterAsArray(); 
		
		//This will sort the array in place
		//Uses lambda function
		//Uses static method with explicit call
		Arrays.sort(peopleArray, 
				(a,b) -> Person.compareByAge(a, b)
				);
		System.out.println("Test2:" + Arrays.asList(peopleArray));
	}
	
	/*
	 * Static method reference: Type::staticMethod
	 * 
	 * Uses a static method reference 
	 * as a lambda function directly
	 * This is called a method reference
	 */
	private void test3()
	{
		Person peopleArray[] = Person.createRoseterAsArray(); 
		
		//This will sort the array in place
		//Explicit method ref syntax
		//Notice no parameters explicitly specified
		Arrays.sort(peopleArray, Person::compareByAge);
		System.out.println("Test3:" + Arrays.asList(peopleArray));
	}
	
	/*
	 * Do the sort from list directly
	 * Method reference by static reference
	 */
	private void test4()
	{
		List<Person> peopleList = Person.createRoster();
		peopleList.sort(Person::compareByAge);
		System.out.println("Test4: sorted by age:" + peopleList);
	}
	
	/*
	 * Method reference by an instance method: (Type::instanceMethod) 
	 * It is an instance method
	 * but no object is around
	 * it assumes any arbitrary object
	 * Notice how this instance method takes only one argument
	 */
	private void test5()
	{
		List<Person> peopleList = Person.createRoster();
		peopleList.sort(Person::instMethodCompareByAge);
		System.out.println("Test5: sorted by age:" + peopleList);
	}
	
	/*
	 * Method reference by an instance method of an object: Object::instanceMethod
	 * Object is specific
	 * Notice the object::method() syntax and not
	 * object.method() syntax.
	 * Also see how this method takes 2 arguments
	 */
	private void test6()
	{
		Person anyPerson = Person.createFred();
		List<Person> peopleList = Person.createRoster();
		peopleList.sort(anyPerson::instUtilityMethodCompareByAge);
		System.out.println("Test6: sorted by age:" + peopleList);
	}
	
	private void test7()
	{
		List<Person> peopleList = Person.createRoster();
		
		List<Person> newPeopleList = Person.transferPeopleTo(peopleList, ArrayList::new);
		Set<Person> newPeopleSet = Person.transferPeopleTo(peopleList, HashSet::new);
		
		System.out.println("Test7: as a list" + newPeopleList);
		System.out.println("Test7: as a set" + newPeopleSet);
	}
	
	//To test default methods that can be used
	//to intercept or alter the original behavior.
	private void test8()
	{
		//Get a function that can create a person
		FIPersonCreator2 fip = (Person::new);
		
		//What do you want once the person is created
		//say that
		Consumer<Person> cp = (p) -> {
			System.out.println("From Test8: " + p);
		};
		
		//Now you can do this
		//Notice that the person is printed
		//every time it is created
		Person person = createPerson(fip.afterThat(cp));
		System.out.println("From Test8: at the end:" + person);
		
		//afterThat returns the same interface as "fip"
		//and hides the original "fip" in the belly
	}
	
	//Used by test8()
	private Person createPerson(FIPersonCreator2 creator)
	{
		return creator.get("Fred",
        		IsoChronology.INSTANCE.date(1980, 6, 20),
        		Person.Sex.MALE,
        		"fred@example.com");
	}
}//eof-class
