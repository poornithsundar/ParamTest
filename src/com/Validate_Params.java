package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Validate_Params {
	static void doSemiValidateParams(List<String> requestParams, List<List<String>> semiOptionalParamsList, List<Integer> max_count)
	{
		int count=0;
		for(int j=0;j<semiOptionalParamsList.size();j++)
		{
			List<String> semiOptionalParams = semiOptionalParamsList.get(j);
			Set<String> semiExtraParams = requestParams.stream().filter(i -> semiOptionalParams.contains(i)).collect(Collectors.toSet());
			int c = semiExtraParams.size();
			if(c==0)
			{
				System.out.println("Atleast one of the optional params are required.....!"+semiOptionalParams.toString());
			}
			else if(c==semiOptionalParams.size())
			{
				System.out.println("All the optional params should not be given .....!"+semiOptionalParams.toString());
			}
			else if(c==max_count.get(j))
			{
				count++;
			}
			else
			{
				System.out.println("Count of the semi optional params "+semiOptionalParams.toString()+" is not satisfied. Wanted = "+max_count.get(j).toString()+". Given = "+c);
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
		List<List<String>> semiOptional = new ArrayList<>();
		List<Integer> count = new ArrayList<>();
		System.out.println("Enter the number of semi optional params?");
		int n = Integer.parseInt(sc.nextLine());
		for (int i=0;i<n;i++)
		{
			List<String> request1 = new ArrayList<>();
			System.out.println("What are the semi optional params?(in single line with spaces)");
			String[] params = sc.nextLine().split(" ");
			for(String j:params) request1.add(j);
			semiOptional.add(request1);
		}
		System.out.println("What are the request params given?(in single line with spaces)");
		String[] params = sc.nextLine().split(" ");
		for(String j:params) request.add(j);
		for (int i=0;i<n;i++)
		{
			System.out.println("What is the required count for semioptional query validation?"+semiOptional.get(i));
			String param = sc.nextLine();
			count.add(Integer.parseInt(param));
		}
		doSemiValidateParams(request,semiOptional,count);
		sc.close();
	}
}
