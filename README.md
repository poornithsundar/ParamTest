# ParamTest

input format example:(Accurate condition)
-----------------------------------------
Enter the number of semi optional params?
1
What are the 1 semi optional params?(In single line with commas)
name,age,gender
What is the max limit for this semi optional params?
2
What are the request params given?(in single line with commas)
name,age

OutPut:
--------
Process the Request



input format example:(Inaccurate condition)
-------------------------------------------
Enter the number of semi optional params?
1
What are the 1 semi optional params?(In single line with commas)
name, age
What is the max limit for this semi optional params?
1
What are the request params given?(in single line with commas)
{EMPTY STRING}

OutPut:
-------
Empty request is not allowed...!
