package com.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.practice.vo.Person;

public class Excersize1UsingJDK8
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
	
		Collections.sort(people,(Person p1,Person p2)->p1.getLname().compareTo(p2.getLname())); 

		
	
	// Step 2: Create a method which prints all the elements in the list ( Same as printall)
		printLastNameConditionally(people,(p)-> true); 

	// Step 3: create a method that prints all the people that have last name beginning with B
		
		
		printLastNameConditionally(people,(p)-> p.getLname().startsWith("U"));

		
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
	
	
	interface Conditions 
	{
		boolean test(Person p);
	}
}


