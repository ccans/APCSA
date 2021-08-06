package Week3;

import java.util.Scanner;

/*
Neev Mangal
2/16/21 
Tika Kude
B3 AP Computer Science A

 This program uses nested loops to produce a multiplication table
*/ 


public class multiplicationTables {
	public static void main(String[] args) {	
		
		// Declare variables
		int m1, m2;
		String printRAM;
		Scanner reader = new Scanner(System.in);
		
		// Get the user input 
		System.out.println("Enter the first multiplier");
		m1 = reader.
				nextInt();
		System.out.println("Enter the second multiplier");
		m2 = reader.nextInt();
		reader.close();

		
		// First print out the cosmetic top border
		printRAM = "----+";
		for(int i = 0; i < m1; i++) printRAM += "----";
		System.out.println(printRAM);
		
		//Print out the top of the table with the numbers
		printRAM = "    | ";
		for(int q = 0; q < m1; q++) printRAM += (q+1) + "   ";
		System.out.println(printRAM);
		
		printRAM = "----+";
		for(int k = 0; k < m1
				; k++) printRAM += "----";
		System.out.println(printRAM);
		
		//Nested loops for the table itself
		 for(int j = 0; j < m2; j++) {
			 //the if statements are just for making sure the spacing lines up
			 //if the assignment required more then a 12x12 table I would make
			 //a function that calculated the amount of spaces needed using 
			 //logarithims rather then using if statements 
			 if((j+1)< 10) printRAM = (j+1) + "   | ";
			 if((j+1)>= 10) printRAM = (j+1) + "  | ";
			 if((j+1)>= 100) printRAM = (j+1) + " | ";
			 
			 
			 for(int u = 0; u < m1; u++)  {
				 if((j+1)*(u+1)< 10) printRAM += (j+1)*(u+1) + "   ";
				 if((j+1)*(u+1)>= 10 && (j+1)*(u+1)< 100) printRAM += (j+1)*(u+1) + "  ";
				 if((j+1)*(u+1)>= 100) printRAM += (j+1)*(u+1) + " ";
			 }
			 System.out.println(printRAM);
		 }

		
}
}


