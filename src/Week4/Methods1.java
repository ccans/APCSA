package Week4;

import java.util.Scanner;

/*
Neev Mangal
2/23/21 
Tika Kude
B3 AP Computer Science A

 This program  allows a user to pick a unit conversion from a menu.  The program then reads in a value and display the converted value.
*/ 


public class Methods1 {
	
	public static void main(String[] args) {	
		// Declare varibales 
		double input, output;
		int conversionChosen;
		boolean isDone = false;
		Scanner reader = new Scanner(System.in);
		
		// loop so that if a user chooses an invalid conversion (typo) they can enter it again
		while(!isDone) {
		System.out.println("Pick a conversion! \nEnter one of these codes:\n1: feet to inches\n2: centimeters to inches \n3: miles to meters \n4: miles to feet\n5: pounds (lbs) to ounces \n6: kilowatt to horsepower");
		conversionChosen = reader.nextInt();
		
		// Weed out any invalid codes
		if(0 < conversionChosen && conversionChosen <7) { 
			isDone = true;
			System.out.println("Enter your input value");
			input = reader.nextDouble();
			reader.close();
			
			Methods1 tempConv = new Methods1();
			
			// Figure out which conversion to do
			switch(conversionChosen) {
				case 1:
					output = tempConv.feetInches(input);
					break;
				case 2:
					output = tempConv.cmInches(input);
					break;
				case 3:
					output = tempConv.milesMeters(input);
					break;
				case 4:
					output = tempConv.milesFeet(input);
					break;
				case 5:
					output = tempConv.lbsOz(input);
					break;
				case 6:
					output = tempConv.kwHp(input);
					break;
				default:
					output = 0;
			}
			System.out.println("Your converted value is " + 
			output);
		}
		
		}
		
	}	
	
	// All of the methods for each kind of conversion
	public double feetInches(double feet) {
		return feet*12;
	}
	public double cmInches(double cm) {
		return cm/2.54;
	}
	public double milesMeters(double miles) {
		return miles*1609.34;
	}
	public double milesFeet(double miles) {
		return miles*5280;
	}
	public double lbsOz(double lbs) {
		return lbs*16;
	}
	public double kwHp(double kw) {
		return kw*1.341003;
	}


}
