package com.ai.learning.generics.example1;

public class GenericPair<X,Y> 
{
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
