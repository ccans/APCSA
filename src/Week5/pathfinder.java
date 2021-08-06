package Week5;

import java.util.Scanner;

/*
Neev Mangal
3/4/21 
Tika Kude
B3 AP Computer Science A

 This program solves the path problem, #3 on the assignment
*/

public class pathfinder {
	
	public int solve(int x, int y) {
		if(x == 1 || y == 1) {
			return 0;
		} else {
			return 1 + solve(x-1, y) + solve(x, y-1);
		}
	}

	public static void main(String[] args) {
		
		// Declare Variables
		int street, avenue;
		pathfinder solver = new pathfinder();
		Scanner reader = new Scanner(System.in);
		
		// Get input
		System.out.println("Where is Karel (x)?");
		street = reader.nextInt();
		System.out.println("Where is Karel (y)?");
		avenue = reader.nextInt();
		reader.close();

		System.out.println((solver.solve(street, avenue) + 1) + " ways");
		
		
		
	}

}
