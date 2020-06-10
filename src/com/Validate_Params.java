package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Validate_Params {
	static void doSemiValidateParams(List<String> requestParams, List<List<String>> semiOptionalParamsList)
	{
		int count=0;
		for(int j=0;j<semiOptionalParamsList.size();j++)
		{
			List<String> semiOptionalParams = semiOptionalParamsList.get(j);
			int c = 0;
			for(String i:requestParams)
			{
				if(semiOptionalParams.contains(i))
				{
					c+=1;
				}
			}
			if(c==0)
			{
				System.out.println("Atleast one of the optional params are required.....!"+semiOptionalParams.toString());
			}
			else if(c==semiOptionalParams.size())
			{
				System.out.println("All the optional params should not be given .....!"+semiOptionalParams.toString());
			}
			else
			{
				count++;
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
		doSemiValidateParams(request,semiOptional);
		sc.close();
	}
}
