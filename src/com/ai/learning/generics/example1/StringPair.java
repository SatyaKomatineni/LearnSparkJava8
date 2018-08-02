package com.ai.learning.generics.example1;

/*
 * Demonstrates concretizing a generic base
 */
public class StringPair 
extends GenericPair<String, String>
{
    StringPair(String a, String b)
    {
        super(a,b);
    }
}
