package com.ai.learning.lambda.example2;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

public class Person {
	 
    public enum Sex {
        MALE, FEMALE
    }
   
    //Just generate your gets and sets
    //in real projects
    public String name; 
    public LocalDate birthday;
    public Sex gender;
    public String emailAddress;

    //Usual constructor
    Person(String nameArg, LocalDate birthdayArg,
            Sex genderArg, String emailArg) {
            name = nameArg;
            birthday = birthdayArg;
            gender = genderArg;
            emailAddress = emailArg;
        }  
    
    public int getAge() {
        return birthday
            .until(IsoChronology.INSTANCE.dateNow())
            .getYears();
    }
    
    public String toString()
    {
    	return name;
    }
    
    /*
     * Used as a static method reference
     */
    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }
    
    /*
     * Used as an instance method of this type to compare
     * Another kind of method reference
     * Notice it has to have 2 parameters
     * Usually this function is outside of a Person object
     * Like a utility class.
     */
    public int instUtilityMethodCompareByAge(Person a, Person b)
    {
    	return a.birthday.compareTo(b.birthday);
    }
    
    public int instMethodCompareByAge(Person b)
    {
    	return birthday.compareTo(b.birthday);
    }
    public static List<Person> createRoster() {
        
        List<Person> roster = new ArrayList<>();
        roster.add(
            new Person(
            "Fred",
            IsoChronology.INSTANCE.date(1980, 6, 20),
            Person.Sex.MALE,
            "fred@example.com"));
        roster.add(
            new Person(
            "Jane",
            IsoChronology.INSTANCE.date(1990, 7, 15),
            Person.Sex.FEMALE, "jane@example.com"));
        
        roster.add(
                new Person(
                "Bob",
                IsoChronology.INSTANCE.date(2000, 9, 12),
                Person.Sex.MALE, "bob@example.com"));
        
        roster.add(
            new Person(
            "George",
            IsoChronology.INSTANCE.date(1991, 8, 13),
            Person.Sex.MALE, "george@example.com"));
         
        return roster;
    }    
    
    public static Person[] createRoseterAsArray() {
		List<Person> peopleRoster = Person.createRoster();
		Person peopleArray[] = 
				peopleRoster.toArray(new Person[peopleRoster.size()]);
		return peopleArray;
    }
    
    public static Person createFred() {
            return new Person(
            "Fred",
            IsoChronology.INSTANCE.date(1980, 6, 20),
            Person.Sex.MALE,
            "fred@example.com");
    }
    
    public static Person createFredWitFI() {
    	
    	//Get a function pointer to a suitable constructor
    	FIPersonCreator pcFi = Person::new;
    	
    	//Notice the get function
        return pcFi.get(
        		"Fred",
        		IsoChronology.INSTANCE.date(1980, 6, 20),
        		Person.Sex.MALE,
        		"fred@example.com");
    }
    /*
     * It reads:
     * Transfer from current collection 
     * to any new collection which is determined by the
     * Supplier functional interface.
     * 
     * DEST is a type.
     * Person is a type
     * Collection<Person> is a type distinct from a Person
     * 
     * DEST then is an extension of the SPECIFIC type Collection<Person>
     * So DEST can be List<Person>
     *    Set<Person>
     *    etc...
     *    
     */
    public static <DEST extends Collection<Person> >
    DEST transferPeopleTo(Collection<Person> peopleCollection, 
    		Supplier<DEST> targetCollectionCreator)
    {
    	//This doesnt' work
    	//Collection<Person> targetPeopleCollection = 
    	DEST targetPeopleCollection = 
    			targetCollectionCreator.get();
    	for (Person p: peopleCollection)
    	{
    		targetPeopleCollection.add(p);
    	}
    	return targetPeopleCollection;
    }
    
}//eof-class
