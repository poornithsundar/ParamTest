package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Validate_Params {
	static void doSemiValidateParams(List<String> requestParams, HashMap<List<String>,Integer> semiOptionalParamsList)
	{
		int count=0;
		Set<List<String>> d = semiOptionalParamsList.keySet();
		for(List<String> j : d)
		{
			List<String> semiOptionalParams = j;
			int max_count = semiOptionalParamsList.get(j);
			Set<String> semiExtraParams = semiOptionalParams.stream().filter(i -> requestParams.contains(i)).collect(Collectors.toSet());
			int c = semiExtraParams.size();
			if(c==0)
			{
				System.out.println("Atleast one of the optional params are required.....!"+semiOptionalParams.toString());
			}
			else if(c==semiOptionalParams.size())
			{
				System.out.println("All the optional params should not be given .....!"+semiOptionalParams.toString());
			}
			else if(c==max_count)
			{
				count++;
			}
			else
			{
				System.out.println("Count of the semi optional params "+semiOptionalParams.toString()+" is not satisfied. Wanted = "+max_count+". Given = "+c);
			}
		}
		if(count==semiOptionalParamsList.size())
		{
			System.out.println("Process the Request");
		}
	}

	public static void main(String[] args)
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
					System.out.println("Empty SemiOptional params given!");
					System.exit(0);
				}
				else if(params.size()<=count || count==0)
				{
					System.out.println("Wrong limit given for SemiOptional params!");
					System.exit(0);
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
				System.out.println("Empty request is not allowed...!");
			}
		}
		else
		{
			System.out.println("Optional Params Count specified as 0...!");
		}
		sc.close();
	}
}