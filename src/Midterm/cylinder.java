package Midterm;

import java.util.Scanner;

/*

Neev Mangal
3/6/21 
Tika Kude
B3 AP Computer Science A

This program calculated the volume of a cylinder given values that a user enters
*/


public class cylinder {
	public static void main(String args[]) {
		
		// Initialize varibales
		int height, radius;
		Scanner reader = new Scanner(System.in);
		
		//Get input
		System.out.println("What is the radius of the sphere?");
		radius = reader.nextInt();
		System.out.println("What is the height of the sphere?");
		height = reader.nextInt();
		reader.close();
		
		//Output
		System.out.println(3.14 * Math.pow(radius, 2) * height);


		
	}
}
