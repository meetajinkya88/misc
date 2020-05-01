package com.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.practice.vo.Person;

public class Excersize1UsingJDK7
{

	public static void main(String[] args) 
	{
		List<Person> people = Arrays.asList(
				new Person("Ajinkya","Bambal",31),
				new Person("Varsha","Bambal",32),
				new Person("Anushree","Ugle",26),
				new Person("Anita","Bambal",57),
				new Person("Rutika","Bhuyar",32)
								
				);
		
		
	
	
	// Step1: Sort List by Last Name
	
   
		Collections.sort(people,new Comparator<Person>() 
		{

			public int compare(Person o1, Person o2)
			{
				// TODO Auto-generated method stub
				return o1.getLname().compareTo(o2.getLname());
			}
		} );
		
	
	// Step 2: Create a method which prints all the elements in the list
		printAll(people);

	// Step 3: create a method that prints all the people that have last name beginning with B
		
		printLastNameBeginningWithB(people);
		
		// or we can do it in below ways
		
		printLastNameConditionally(people,new Conditions()
				{
					
					@Override
					public boolean test(Person p)
					{
						return p.getLname().startsWith("U");
					}
				});
	}

	private static void printLastNameConditionally(List<Person> people,Conditions c)
	{
		System.out.println("\n\tPrinting Last Name conditioanlly Starts With 'U'");
		for(Person p : people)
		{
			if(c.test(p))
			System.out.println(p);
		}
		
	}
	private static void printLastNameBeginningWithB(List<Person> people)
	{
		System.out.println("\n\tPrinting Last Name Starts With 'B'");
		for(Person p : people)
		{
			if(p.getLname().startsWith("B"))
			System.out.println(p);
		}
		
	}

	private static void printAll(List<Person> people) 
	{
		for(Person p : people)
		{
			System.out.println(p);
		}
	}
	interface Conditions 
	{
		boolean test(Person p);
	}
}


