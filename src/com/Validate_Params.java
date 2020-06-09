package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Validate_Params {
	static void doValidateParams(List<String> requestParams, List<String> mandatoryParams, List<String> optionalParams, List<String> semiOptionalParams)
	{
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
			System.out.println("Atleast one of the optional params are required.....!");
		}
		else if(c==semiOptionalParams.size())
		{
			System.out.println("All the optional params should not be given .....!");
		}
		else
		{
			System.out.println("Process request.....");
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		List<String> request = new ArrayList<>();
		List<String> mandatory = new ArrayList<>();
		List<String> optional = new ArrayList<>();
		List<String> semiOptional = new ArrayList<>();
		semiOptional.add("phone");
		semiOptional.add("email");
		System.out.println("What are the optional params given in request?(in single line with spaces)");
		String[] params = sc.nextLine().split(" ");
		for(String i:params) request.add(i);
		doValidateParams(request,mandatory,optional,semiOptional);
		sc.close();
	}
}
