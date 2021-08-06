package Quizzes;

import java.util.Scanner;

public class cow {
	// Set up variables
	protected String[] name = new String[2];
	protected int[] age = new int[2];
	
	public void setInfo() {
		// Read in 2 names and ages and store them
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Name the first one");
		name[0] = reader.next();
		System.out.println("What is it's age?");
		age[0] = reader.nextInt();
		System.out.println("Name the second one");
		name[1] = reader.next();
		System.out.println("What is it's age?");
		age[1] = reader.nextInt();
		reader.close();
	}
	
	public void findInfo() {
		// Figure out which of the animals are over 5 and print their names
		System.out.println("The ones over 5 are ");
		if(age[0] > 5 && age[1] > 5) {
			System.out.print(name[0] + " and " + name[1]);
		} else if(age[0] > 5) {
			System.out.print(name[0]);
		} else if(age[1] > 5) {
			System.out.print(name[1]);
		} else {
			System.out.print("none of them");
		}
	}
	
	public void speak() {
		// Print moo
		System.out.println("moo");
	}
	
}
