package com.ai.learning.lambda.example2;

import java.time.LocalDate;
import java.util.function.Consumer;

import com.ai.learning.lambda.example2.Person.Sex;

@FunctionalInterface
public interface FIPersonCreator2 {
	public Person get(String nameArg, LocalDate birthdayArg,
            Sex genderArg, String emailArg); 

	default FIPersonCreator2 afterThat(Consumer<Person> inCp)
	{
		//These local variables are kept with the return function
		//like a closure!!
		
		//Remember who you are
		FIPersonCreator2 original = this;
		
		//To test maintenance of scope
		String testString = "hello";
		
		//To pass the person object back to the caller's desire
		Consumer<Person> cp = inCp;
		
		//Return an encapsulated function
		//that adheres to the same interface
		//this is at core interception
		return	(String nameArg, LocalDate birthdayArg,
            Sex genderArg, String emailArg) -> {
			Person p = original.get(nameArg, birthdayArg, genderArg, emailArg);
			inCp.accept(p);
			System.out.println("Inner stuff: " + testString);
			return p;
		};
	}
}//eof-class
