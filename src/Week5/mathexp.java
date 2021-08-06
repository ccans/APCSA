package Week5;

import java.util.Scanner;

/*
Neev Mangal
3/4/21 
Tika Kude
B3 AP Computer Science A

 This program uses recursive methods to evaluate an exponential expression, such as 2^3
*/ 


public class mathexp {
	
	public int exponent(int a, int b) {
		if(b == 1) {
			return a;
		} else {
			return a * exponent(a, (b-1));
		}
	}

	public static void main(String[] args) {
		
		// Initialize variables
		int exp, base;
		Scanner reader = new Scanner(System.in);
		mathexp calculator = new mathexp();
		
		// Get input
		System.out.println("Enter two numbers, a number and the exponent to which it is to be raised on seperate lines");
		base = reader.nextInt();
		exp = reader.nextInt();
		reader.close();
		
		// calculate and output
		System.out.println(calculator.exponent(base, exp)); 
		

	}

	

}
