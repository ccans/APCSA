package Week2;

//Imports
import java.util.Scanner;

/*
Neev Mangal
2/8/21 
Tika Kude
B3 AP Computer Science A

This program takes in a month and a year and tells the user how many days are in that month
*/ 


public class daysMonth {
	public static void main(String[] args) {
	// This program takes in a month and a year and tells the user how many days are in that month
		
	// Declare variables and Scanner
		int month, year, days;
		Scanner reader = new Scanner(System.in);
		
		// Get the user input 
		System.out.println("Enter the year");
		year = reader.nextInt();
		System.out.println("Enter the month as a number");
		month = reader.nextInt();
		reader.close();
		
		// Calculate and print
		if(month == 2 && year%4 == 0 && year %100 != 0) {
			days = 29;
		} else {
			switch(month) {
				case 1:
					days = 31;
					break;
				case 2:
					days = 28;
					break;
				case 3:
					days = 31;
					break;
				case 4:
					days = 30;
					break;
				case 5:
					days = 31;
					break;
				case 6:
					days = 30;
					break;
				case 7:
					days = 31;
					break;
				case 8:
					days = 31;
					break;
				case 9:
					days = 30;
					break;
				case 10:
					days = 31;
					break;
				case 11:
					days = 30;
					break;
				case 12:
					days = 31;
					break;
				default:
					days = 0;
				
			}
		}
		
		// Print results
		System.out.println(days + " days");
		
	}
}