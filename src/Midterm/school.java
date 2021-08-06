package Midterm;

import java.util.Scanner;

/*

Neev Mangal
3/6/21 
Tika Kude
B3 AP Computer Science A

This program reads in someone's grade and outputs what level of schooling they're in
*/

public class school {

	public static void main(String[] args) {
		
		// Initialize variables
		int grade;
		String typeSchool;
		Scanner reader = new Scanner(System.in);
		
		// Get user input
		System.out.println("What grade are you in");
		grade = reader.nextInt();
		reader.close();
		
		// Figure out what kind of school they are in
		if(grade >= 1 && grade <= 5) {
			typeSchool = "Elementary";
		} else if(grade >= 6 && grade <= 8) {
			typeSchool = "Middle";
		} else if(grade >= 9 && grade <= 12) {
			typeSchool = "High";
		} else {
			typeSchool = "None";
		}
		
		// Output
		
		if(typeSchool != "None")System.out.println("You go to " + typeSchool + " School");
		else System.out.println("You don't go to school yet");
		
	}

}
