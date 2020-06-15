package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.logging.*; 

public class Validate_Params{
	static Logger logger = Logger.getLogger(Validate_Params.class.getName());
	static void doSemiValidateParams(List<String> requestParams, HashMap<List<String>,Integer> semiOptionalParamsList)throws Exception
	{
		FileHandler handler = new FileHandler("ParamTest-master/logs.txt");
		logger.addHandler(handler);
		logger.setLevel(Level.FINER); 
		for(List<String> semiOptionalParams : semiOptionalParamsList.keySet())
		{
			int max_count = semiOptionalParamsList.get(semiOptionalParams);
			Set<String> semiExtraParams = semiOptionalParams.stream().filter(i -> requestParams.contains(i)).collect(Collectors.toSet());
			int c = semiExtraParams.size();
			if(c==0)
			{
				logger.throwing(String.class.getName(),String.class.getMethods()[0].getName(),new CountException("Atleast one of the optional params are required.....!"));
				throw new CountException("Atleast one of the optional params are required.....!");
			}
			else if(c==semiOptionalParams.size())
			{
				logger.throwing(String.class.getName(),String.class.getMethods()[0].getName(),new CountException("All the optional params should not be given .....!"));
				throw new CountException("All the optional params should not be given .....!");
			}
			else if(c!=max_count)
			{
				logger.throwing(String.class.getName(),String.class.getMethods()[0].getName(),new CountException("Count of the semi optional params "+semiOptionalParams.toString()+" is not satisfied. Wanted = "+max_count+". Given = "+c));
				throw new CountException("Count of the semi optional params "+semiOptionalParams.toString()+" is not satisfied. Wanted = "+max_count+". Given = "+c);
			}
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception
	{
		FileHandler handler = new FileHandler("ParamTest-master/logs.txt");
		logger.addHandler(handler);
		logger.setLevel(Level.FINER); 
		Scanner sc = new Scanner(System.in);
		List<String> request = new ArrayList<>();
		HashMap<List<String>,Integer> semiOptional = new HashMap<>();
		System.out.println("Enter the number of semi optional params?");
		int n = Integer.parseInt(sc.nextLine());
		if(n>0)
		{
			for(int i=0;i<n;i++)
			{
				System.out.println("What are the "+(i+1)+" semi optional params?(In single line with commas)");
				List<String> params = Arrays.asList(sc.nextLine().split(","));
				System.out.println("What is the max limit for this semi optional params?");
				int count = Integer.parseInt(sc.nextLine());
				if(params.size()==1 && params.get(0).isEmpty())
				{
					logger.throwing(String.class.getName(),String.class.getMethods()[0].getName(),new InputException("Empty SemiOptional params given!"));
					throw new InputException("Empty SemiOptional params given!");
				}
				else if(params.size()<=count || count==0)
				{
					logger.throwing(String.class.getName(),String.class.getMethods()[0].getName(),new InputException("Wrong limit given for SemiOptional params!"));
					throw new InputException("Wrong limit given for SemiOptional params!");
				} 
				else
				{
					semiOptional.put(params,count);
				}
			}
			System.out.println("What are the request params given?(in single line with commas)");
			String p = sc.nextLine();
			if(!p.isEmpty())
			{
				String[] params = p.split(",");
				for(String j:params) request.add(j);
				doSemiValidateParams(request,semiOptional);
			}
			else
			{
				logger.throwing(String.class.getName(),String.class.getMethods()[0].getName(),new InputException("Empty request is not allowed...!"));
				throw new InputException("Empty request is not allowed...!");
			}
		}
		else
		{
			logger.throwing(String.class.getName(),String.class.getMethods()[0].getName(),new InputException("Optional Params Count specified as 0...!"));
			throw new InputException("Optional Params Count specified as 0...!");
		}
		sc.close();
	}
}