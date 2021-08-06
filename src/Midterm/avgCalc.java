package Midterm;

import java.util.Scanner;

/*

Neev Mangal
3/6/21 
Tika Kude
B3 AP Computer Science A

This program reads 3 numbers and outputs their average, using methods
*/

public class avgCalc {
	public static void main(String[] args) {
		
		System.out.println(
				(.22 * 10*(3)/ 2)
				);
		System.out.println(
				(.22 * 10)*(3 / 2)
				);
	
		// Initialize Variables
		int num1, num2, num3;
		Scanner reader = new Scanner(System.in);
		avgCalc calculator = new avgCalc();
		
		// Get user input
		System.out.println("Enter the first number");
		num1 = reader.nextInt();
		System.out.println("Enter the second number");
		num2 = reader.nextInt();
		System.out.println("Enter the third number");
		num3 = reader.nextInt();
		reader.close();
		
		//Output
		calculator.printAvg(calculator.calculateAvg(num1, num2, num3));
	}
	
	public int calculateAvg(int a, int b, int c) {
		return (a+b+c)/3;
	}
	
	public void printAvg(int answer) {
		System.out.println("The average is " + answer);
	}

}
