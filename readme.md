# Introduction/Goal
1. To exercise and learn Jdk 8, Spark, RxJava
2. Learn using sample code

# Generics
## com.ai.learning.generics.example1 demonstrates

[You can find this package here](/src/com/ai/learning/generics/example1)

[The main driver class you want to see for this is here](/src/com/ai/learning/generics/example1/Test.java)

1. Design a generic GenericPair class with two input types
2. See what methods can be used on generic type instance variables
3. Implement a toString() method in a generic way
4. Test a string pair
6. Test an <string, int> pair
7. Test basic generic methods for <?> and &lt;object&gt;
8. Test static variables
9. Test raw type casting of generics
10. Test simpler (non-paranoid) syntax for geneic instantiation
11. Test <? extends Base> approach for collections of derived classes
12. Realize you cannot use ? outside of a <?> . 
13. To provide generic adds on a list, exercise generic methods
14. Examine instanceof generic types
15. Examine casting of generic types

# Lambda Functions
## com.ai.learning.lambda.example1 demonstrates: Lambda Function Basics

[You can find this package here](/src/com/ai/learning/lambda/example1)

[The main driver class you want to see for this is here](/src/com/ai/learning/lambda/example1/Test.java)
 
1. Instantiated interfaces as lambda functions. (Single method interfaces)
2. Parameters to lambda functions
3. Passing around lambda functions
4. Default methods
5. Static values in interfaces
6. Basic syntax of Lambda functions
7. Scope of lambda functions
8. Target typing and type inference
9. Avoiding types and parenthesis
10. Gentle introduction to a supplier

## com.ai.learning.lambda.example2 demonstrates: Method References

[You can find this package here](/src/com/ai/learning/lambda/example2)

[The main driver class you want to see for this is here](/src/com/ai/learning/lambda/example2/Test.java)

1. This is an exercise in method references
2. Use arrays to sort using lambda comparators
3. Use lists to sort using lambda comparators
4. Use inline lambda functions
5. Use static method reference (Type::staticMethod)
6. Use instance method reference (uses self as one of the arguments. Type::instMethd)
7. Use arbitrary object instance method reference (objectRef::instUtilityMethod) 
8. Use static methods (Type.staticMethod)
9. Understand Supplier functional contract
10. Show how interface default methods are used for before and after (interceptors like) functionality
11. Show how Type::new method reference is used 

# Streams
## com.ai.learning.streams.example1 demonstrates: Streams Basics

[You can find this package here](/src/com/ai/learning/streams/example1)

[The main driver class you want to see for this is here](/src/com/ai/learning/streams/example1/Test.java)

1. Dip the toe into streams
2. Pipelines
3. Source
4. Intermediate operations/streams
5. terminal operations
6. Aggregate operations
7. Reductions
8. How to use a collect method with a custom collector
9. Use Collectors.toList()

# Directory structure (Guide to Contributors)
1. [/docs/general/readme.md] (./docs/general/readme.md)

# Key External links

1. [Here is a learning folder for Java 8 and Lambda functions](http://www.satyakomatineni.com/akc/display?url=NotesIMPTitlesURL&ownerUserId=satya&folderId=389&order_by_format=news)
2. [More external links on Java lambda functions](http://www.satyakomatineni.com/item/5422)