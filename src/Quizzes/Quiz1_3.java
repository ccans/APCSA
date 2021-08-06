package Quizzes;


//Imports
import java.util.Scanner;

/*
Neev Mangal
2/12/21 
Tika Kude
B3 AP Computer Science A

This program reads in an area code and print out what city a person is from.
*/ 


public class Quiz1_3 {
	public static void main(String[] args) {
//		This program reads in an area code and print out what city a person is from.
		
	// Declare variables and Scanner
		int areaCode;
		String city;
		Scanner reader = new Scanner(System.in);
		
		// Get the user input 
		System.out.println("Enter an area code");
		areaCode = reader.nextInt();
		reader.close();

		// Use code to figure out where they are from
		switch(areaCode) {
			case 202:
				city = "Washington DC";
				break;
			case 305:
				city = "Miami";
				break;
			case 406:
				city = "Billings";
				break;
			case 504:
				city = "New Orleans";
				break;
			case 612:
				city = "Minneapolis";
				break;
			case 720:
				city = "Denver";
				break;
			case 808:
				city = "Honolulu";
				break;
			case 907:
				city = "Anchorage";
				break;
			default:
				city = "Unknown";
		}
		
		
		// Output
		if(city == "Unknown") {
			System.out.println("Odd, your city isn't in our system -- invalid area code");
		} else {
			System.out.println("That area code is from " + city);
		}
		
		
	}

}
