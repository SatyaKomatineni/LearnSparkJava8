package com.ai.learning.lambda.example2;

import java.time.LocalDate;

import com.ai.learning.lambda.example2.Person.Sex;

@FunctionalInterface
public interface FIPersonCreator {
	public Person get(String nameArg, LocalDate birthdayArg,
		            Sex genderArg, String emailArg); 
}
