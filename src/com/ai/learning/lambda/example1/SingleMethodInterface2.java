package com.ai.learning.lambda.example1;

public interface SingleMethodInterface2 {
	public static String NAME = "static string name";
	
	public String doSomeThing(String x);
	
	default String getSomeReadOnlyString()
	{
		return "\nFrom a default method";
	}
}
