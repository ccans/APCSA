package Week6;

import java.util.Scanner;

/*

Neev Mangal
3/11/21 
Tika Kude
B3 AP Computer Science A

This program has uses arrays to get speeding data and calculates a variety of statistics which it outputs in a report
*/


public class speeding {
	
	public static void main(String args[]) {
		
		// Declare variables. Range 1 stores the amount of people <10mph over speed limit and range 2 stores 10-20mph over
		int highSpeed = 0, total = 0, range1 = 0, range2 = 0, speedLimit = 55;
		
		Scanner reader = new Scanner(System.in);
		int speeds[] = new int[10];
		
		//Get user input and close the reader
		
		for(int i = 0; i < speeds.length; i++) {
			System.out.println("Enter the next speed");
			speeds[i] = reader.nextInt();
		}
		reader.close();
		
		// Iterate through the array and get all the data that we need
		
		for(int j = 0; j < speeds.length; j++) {
			total += speeds[j];
			if(speeds[j] > highSpeed) highSpeed = speeds[j];
			if(speeds[j] - speedLimit <= 10) range1++;
			if(speeds[j] - speedLimit > 10 && speeds[j] - speedLimit <= 20) range2++;
		}
		
		// Output
		
		System.out.println("DATA REPORT:");
		System.out.println("Average speed: " + (total/speeds.length));
		System.out.println("Fastest speed: " + highSpeed);
		System.out.println("There were " + range1 + " people 10mph or less over the speed limit");
		System.out.println("There were " + range2 + " people between 10 and 20mph over the speed limit");
		System.out.println("There were " + (speeds.length - range1 - range2) + " people 20mph+ over the speed limit");
		
		
		
	}
}
