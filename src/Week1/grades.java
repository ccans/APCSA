package Week1;

import java.util.Arrays;
import java.util.Scanner;

/*

Neev Mangal
2/4/21 
Tika Kude
B3 AP Computer Science A

This program has the user enter in a score for a test and prints out the grade the user got on that test
*/

public class grades {

	public static void main(String[] args) {
		//  This program has the user enter in a score for a test and prints out the grade the user got on that test
		
		//  Declare variables and scanner. Doubles used so users can enter decimal number grades
		double grade, points;
		String letterGrade;
		Scanner reader = new Scanner(System.in);
		
		//  Get user input
		System.out.println("Enter your grade (as a number)");
		grade = reader.nextDouble();
		System.out.println("Enter how many points your assignement was worth (as a number)");
		points = reader.nextDouble();
		reader.close();
		
		// Calculate
		
		if(grade >= .9*points) {
			letterGrade = "A";
		} else if(grade >= .8*points) {
			letterGrade = "B";
		} else if(grade >= .7*points) {
			letterGrade = "C";
		} else if(grade >= .6*points) {
			letterGrade = "D";
		} else {
			letterGrade = "F";
		}
		
		// Output
		
		System.out.println("Your grade is an " + letterGrade + ", with a " + 100*grade/points + "%.");
	}

}
