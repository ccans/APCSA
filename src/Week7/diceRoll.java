package Week7;

import java.util.Scanner;

/*

Neev Mangal
3/15/21 
Tika Kude
B3 AP Computer Science A

This program rolls two dice and counts up t
*/

public class diceRoll {

	public static void main(String args[]) {
		
		// The two arrays that will be used in parallel. Each array will store the rolls of one of the two dice.
		// Create variables
		int[] dice1;
		int[] dice2;
		int diceRolls;
		Scanner reader = new Scanner(System.in);
		
		// Create an array to store how many of each diceroll occurs
		int[] occurences = new int[12];
		
		// Get user input
		System.out.println("How many times would you like to roll the dice?");
		diceRolls = reader.nextInt();
		reader.close();
		
		// Now we can initialize our variables since we know the length 
		dice1 = new int[diceRolls];
		dice2 = new int[diceRolls];
		
		// Generate the random numbers
		for(int i = 0; i < diceRolls; i++) {
			dice1[i] = (int) Math.floor(Math.random()*6) + 1;
			dice2[i] = (int) Math.floor(Math.random()*6) + 1;
		}
		
		// Count up the occurrences
		for(int j = 0; j < diceRolls; j++) {
			occurences[dice1[j] + dice2[j] - 1]++;
		}
		
		//Output
		// NOTE: k STARTS at 2 because dicerolls cannot be 
		for(int k = 2; k < 13; k++) {
			System.out.println("The number " + k + " was rolled " + occurences[k - 1] + " times");
		}
		
		
	}
}
