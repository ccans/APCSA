package Week10;

public class checking extends account {
	
	// Withdraw a certain amount and also pay a 1$ fee. Pay a 10$ fee if the user has < 0$ in their account.
	public void withdraw(int amount) {
		balance = balance - amount - 1;
		if(balance < 0) {
			System.out.println("You were charged a 10$ overdraft fee for having < 0$");
			balance = balance - 10;
		}
		printBal();
	}
}
