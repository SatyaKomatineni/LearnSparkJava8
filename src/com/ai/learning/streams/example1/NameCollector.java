package com.ai.learning.streams.example1;

import java.util.ArrayList;
import java.util.List;

import com.ai.learning.lambda.example2.Person;

/*
 * To demonstrate custom collector
 * See Test5
 */
public class NameCollector 
{
	public List<String> names = new ArrayList<>();
	
	//The accept method
	public void addName(Person p)
	{
		names.add(p.name);
	}
	
	public void combine(NameCollector other)
	{
		names.addAll(other.names);
	}
}
