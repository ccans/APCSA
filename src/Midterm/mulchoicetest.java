package Midterm;

import java.util.Scanner;

public class mulchoicetest {
	public static void main(String[] args) {
		int x;

		System.out.println("Enter a number?");
		Scanner reader = new Scanner(System.in);
		x = reader.nextInt();

		do {

		if (x <= 0)

		    System.out.println("Error - re-enter this number");

		} while (x <=0);
	}

}
