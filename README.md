# ParamTest

input format example:(Accurate condition)
-----------------------------------------
Enter the number of semi optional params?
2
What are the semi optional params?(in single line with spaces)
name age gender occupation
What are the semi optional params?(in single line with spaces)
area street village city state country
What are the request params given?(in single line with spaces)
name gender area village state country
What is the required count for semioptional query validation?[name, age, gender, occupation]
2
What is the required count for semioptional query validation?[area, street, village, city, state, country]
4

OutPut:
--------
Process the Request



input format example:(Inaccurate condition)
-------------------------------------------
Enter the number of semi optional params?
2
What are the semi optional params?(in single line with spaces)
name age gender occupation
What are the semi optional params?(in single line with spaces)
area street village city state country
What are the request params given?(in single line with spaces)
name age gender area street city state
What is the required count for semioptional query validation?[name, age, gender, occupation]
3
What is the required count for semioptional query validation?[area, street, village, city, state, country]
3

OutPut:
-------
Count of the semi optional params [area, street, village, city, state, country] is not satisfied. Wanted = 3. Given = 4
