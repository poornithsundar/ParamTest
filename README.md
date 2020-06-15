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
1
What are the 2 semi optional params?(In single line with commas)
cuty,state,country
What is the max limit for this semi optional params?
2
What are the request params given?(in single line with commas)
name,age,state

OutPut:
-------
Exception in thread "main" com.CountException: Count of the semi optional params [cuty, state, country] is not satisfied. Wanted = 2. Given = 1
	at com.Validate_Params.doSemiValidateParams(Validate_Params.java:37)
	at com.Validate_Params.main(Validate_Params.java:82)
