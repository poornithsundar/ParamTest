# ParamTest

input format example:(Accurate condition)
-----------------------------------------
Enter the number of semi optional params?
2
What are the 1 semi optional params?(In single line with commas)
name,age,gender
What is the max limit for this semi optional params?
2
What are the 2 semi optional params?(In single line with commas)
street,city,state
What is the max limit for this semi optional params?
2
What are the request params given?(in single line with commas)
name,age,city,state

OutPut:
--------
Terminates Without Exception



input format example:(Inaccurate condition)
-------------------------------------------
Enter the number of semi optional params?
2
What are the 1 semi optional params?(In single line with commas)
name,age,gender
What is the max limit for this semi optional params?
2
What are the 2 semi optional params?(In single line with commas)
city,state,country
What is the max limit for this semi optional params?
1
What are the request params given?(in single line with commas)
name,city,country

OutPut:
-------
Jun 15, 2020 4:49:07 PM com.Validate_Params doSemiValidateParams
SEVERE: Count of the semi optional params [city, state, country] is not satisfied. Wanted = 1. Given = 2
Exception in thread "main" java.lang.Exception: Count of the semi optional params [city, state, country] is not satisfied. Wanted = 1. Given = 2
	at com.Validate_Params.doSemiValidateParams(Validate_Params.java:32)
	at com.Validate_Params.main(Validate_Params.java:74)
