package Quizzes;

import java.util.Scanner;

public class horse extends cow {
	
	// extra variables for horses specifically
	private String[] colors = new String[2];
	
	
	public void SetColor() {
		// Read in 2 colors and store them
		Scanner reader = new Scanner(System.in);
		
		System.out.println("What is the color of the first one?");
		colors[0] = reader.next();
		
		System.out.println("What is the color of the second one?");
		colors[1] = reader.next();
		
		reader.close();
	}
	
	public void FindBrown() {
		// Pinr the names of all the brown horses
		System.out.println("The brown horse[s] are ");
		if(colors[0].toLowerCase() == "brown" && colors[1].toLowerCase() == "brown") {
			System.out.print(name[0] + " and " + name[1]);
		} else if(colors[0].toLowerCase() == "brown") {
			System.out.print(name[0]);
		} else if(colors[1].toLowerCase() == "brown") {
			System.out.print(name[1]);
		} else {
			System.out.print("none of them");
		}
	}
	
	public void speak() {
		// Say neigh
		System.out.println("neigh");
	}
	
}
