package com.ai.learning.generics.example1;

public class GenericPair<X,Y> 
{
	//To demo static variables
	//There is only one instance of this class
	//irrespective of the number of objects it creates.
	public static String NAME="GenericPair";
	
	//Error: as statics cannot be genericised
	//because there is only one class
	//public static X someVariable;
	
	//instance variables
	private X x;
	private Y y;
	public GenericPair(X inX, Y inY)
	{
		x = inX;
		y = inY;
	}
	
	public X getFirst() { return x;}
	public Y getSecond() { return y;}
	
	public String toString()
	{
		return x.toString() + ":" + y.toString();
	}
}
