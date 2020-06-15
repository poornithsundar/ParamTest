package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.logging.*; 

public class Validate_Params{
	static Logger logger = Logger.getLogger(Validate_Params.class.getName());
	static void doSemiValidateParams(List<String> requestParams, HashMap<List<String>,Integer> semiOptionalParamsList)throws Exception
	{
		for(Map.Entry<List<String>,Integer> entry :  semiOptionalParamsList.entrySet())
		{
			List<String> semiOptionalParams = entry.getKey();
			int semiOptionalParams_limit = entry.getValue();
			Set<String> semiExtraParams = semiOptionalParams.stream().filter(i -> requestParams.contains(i)).collect(Collectors.toSet());
			int semiOptionalParams_length = semiExtraParams.size();
			if(semiOptionalParams_length==0 || semiOptionalParams_length==semiOptionalParams.size())
			{
				String str = (semiOptionalParams_length==0)?"Atleast one of the optional params are required.....!":"All the optional params should not be given .....!";
				logger.log(Level.SEVERE, str);
				throw new Exception(str);
			}
			else if(semiOptionalParams_length!=semiOptionalParams_limit)
			{
				logger.log(Level.SEVERE,"Count of the semi optional params "+semiOptionalParams.toString()+" is not satisfied. Wanted = "+semiOptionalParams_limit+". Given = "+semiOptionalParams_length);
				throw new Exception("Count of the semi optional params "+semiOptionalParams.toString()+" is not satisfied. Wanted = "+semiOptionalParams_limit+". Given = "+semiOptionalParams_length);
			}
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception
	{
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
					logger.log(Level.SEVERE, "Empty SemiOptional params given!");
					throw new Exception("Empty SemiOptional params given!");
				}
				else if(params.size()<=count || count==0)
				{
					logger.log(Level.SEVERE, "Wrong limit given for SemiOptional params!");
					throw new Exception("Wrong limit given for SemiOptional params!");
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
				logger.log(Level.SEVERE, "Empty request is not allowed...!");				
				throw new Exception("Empty request is not allowed...!");
			}
		}
		else
		{
			logger.log(Level.SEVERE, "Optional Params Count specified as 0...!");
			throw new Exception("Optional Params Count specified as 0...!");
		}
		sc.close();
	}
}