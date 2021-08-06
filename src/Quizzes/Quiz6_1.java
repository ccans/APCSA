package Quizzes;

import java.util.Scanner;

public class Quiz6_1 {

	
	public static void main(String args[]) {
		
		// Declare variables and scanner
		int[][] scores = new int[16][2];
		int wins = 0, games, largestDiff = 0;
		Scanner reader = new Scanner(System.in);
		
		// Get how many games were played in the season
		System.out.println("How many games were played in the season? (up to 16)");
		games = reader.nextInt();
		
		// Get input for each game
		for(int i = 0; i < games; i ++) {
			System.out.println("For game " + (i + 1) + " what was your team's score?");
			scores[i][0] = reader.nextInt();
			System.out.println("...and the opponent's score?");
			scores[i][1] = reader.nextInt();
			// Ascertain who won and the largest difference
			if(Math.abs(scores[i][1] - scores[i][0]) > largestDiff) largestDiff = Math.abs(scores[i][1] - scores[i][0]);
			if(scores[i][0]  > scores[i][1]) wins++;
		}
		
		// Close reader
		reader.close();
		
		// Output
		System.out.println("The team won " + wins + " games and lost " +  (games - wins) + ".");
		System.out.println("The largest difference in the score was " + largestDiff + " points");
	}
}
