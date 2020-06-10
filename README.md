# ParamTest

input format example:(Accurate condition)

Enter the number of semi optional params?
2
What are the semi optional params?(in single line with spaces)
first_name last_name
What are the semi optional params?(in single line with spaces)
city state
What are the request params given?(in single line with spaces)
first_name state
Process the Request


input format example:(Inaccurate condition)
Enter the number of semi optional params?
2
What are the semi optional params?(in single line with spaces)
first_name last_name
What are the semi optional params?(in single line with spaces)
city state
What are the request params given?(in single line with spaces)
city first_name state
All the optional params should not be given .....![city, state]
