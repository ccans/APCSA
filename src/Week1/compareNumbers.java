package Week1;

import java.util.Arrays;
import java.util.Scanner;

/*

NOTE: Using if statements is kind of a long way to do this. I used if statements to prove my proficiency and complete the assignment,
BUT at the bottom of my code I have a  much more succinct way to do the same thing using Arrays and loops

Neev Mangal
2/3/21 
Tika Kude
B3 AP Computer Science A

This program get's three numbers from the user, prints out what number is the largest, the smallest, and the average of all three numbers. 
*/

public class compareNumbers {

	public static void main(String[] args) {
		//  This program get's three numbers from the user, prints out what number is the largest, the smallest, and the average of all three numbers. 

		//  Give the user information about what the program does
		
		System.out.println("Input 3 numbers, and we'll tell you the highest, lowest, and average");
		
		//  Declare variables and scanner. Doubles used so users can enter decimal numbers
		double num1, num2, num3, largest, smallest, average;
		Scanner reader = new Scanner(System.in);
		
		//  Get the 3 user input numbers
		System.out.println("Enter the first number");
		num1 = reader.nextDouble();
		System.out.println("Enter the second number");
		num2 = reader.nextDouble();
		System.out.println("Enter the third number");
		num3 = reader.nextDouble();
		reader.close();
		
		// CHECK for special cases
		
		if(num1 == num2 && num2 == num3) {
			System.out.println("All three numbers are the same, and the average is " + num1);
		} else if (num1 == num2) {
			if(num1 > num3)
				System.out.println("2 of the numbers. " + num1 + " and " + num2 + " are the same and bigger then " + num3 + ", which is the smallest. The average is " + (num1+num2+num3)/3 );
			else 
				System.out.println("2 of the numbers. " + num1 + " and " + num2 + " are the same and smaller then " + num3 + ", which is the biggest. The average is " + (num1+num2+num3)/3 );
		} else if (num2 == num3) {
			if(num2 > num1)
				System.out.println("2 of the numbers. " + num2 + " and " + num3 + " are the same and bigger then " + num1 + ", which is the smallest. The average is " + (num1+num2+num3)/3 );
			else 
				System.out.println("2 of the numbers. " + num2 + " and " + num3 + " are the same and smaller then " + num1 + ", which is the biggest. The average is " + (num1+num2+num3)/3 );
		} else if (num1 == num3) {
			if(num1 > num2)
				System.out.println("2 of the numbers. " + num1 + " and " + num3 + " are the same and bigger then " + num2 + ", which is the smallest. The average is " + (num1+num2+num3)/3 );
			else 
				System.out.println("2 of the numbers. " + num1 + " and " + num3 + " are the same and smaller then " + num2 + ", which is the biggest. The average is " + (num1+num2+num3)/3 );
		}
		
		
		
		// Calculate
		
		if(num1 > num2 && num1 > num3) {
			largest = num1;
		} else if(num2 > num3) {
			largest = num2;
		} else {
			largest = num3;
		}
		
		if(num1 < num2 && num1 < num3) {
			smallest = num1;
		} else if(num2 < num3) {
			smallest = num2;
		} else {
			smallest = num3;
		}
		
		average = (num1+num2+num3)/3;
		
		// Output
		
		System.out.println("The largest number is " + largest + ", the smallest number is " + smallest + ", and the average number is " + average);
		
		
		
		
//		ALTERNATIVE METHOD:
			
//		System.out.println("Input 3 numbers, and we'll tell you the highest, lowest, and average");
//		
//		//  Declare variables and scanner. Doubles used so users can enter decimal numbers
//		double[] numbers = new double[3];
//		double average;
//		Scanner reader = new Scanner(System.in);
//		
//		// Get the user input 
//		for(int i = 0; i < 3; i++) {
//			System.out.println("Enter a number");
//			numbers[i] = reader.nextDouble();
//		}
//		reader.close();
//		
//		// Calculate
//		Arrays.sort(numbers);
//		average = (numbers[0] + numbers[1] + numbers[2])/3;
//        
//		// Output
//		System.out.println("The largest number is " + numbers[0] + ", the smallest number is " + numbers[2] + ", and the average number is " + average);
//		

	}

}
