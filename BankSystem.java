package programs;

/*
A bank is designing an online transaction system in Java. 
• Each customer has a daily withdrawal limit of ₹50,000. 
• If a customer tries to withdraw more than this amount in a single day, the system should 
throw a user-defined exception called DailyLimitExceededException. 
Similarly, if the customer tries to withdraw more money than their current account balance, 
another user-defined exception InsufficientBalanceException should be thrown. 
The program should: 
• Create an account with an initial balance. 
• Allow multiple withdrawal attempts. 
• Catch and handle the exceptions with proper error messages. 
• Always display the remaining balance after every transaction (if successful).
 */

import java.util.Scanner;


class DailyLimitExceededException extends Exception { 
	public DailyLimitExceededException(String msg) { 
		super(msg); 
	} 
} 

class InsufficientBalanceException extends Exception { 
	public InsufficientBalanceException(String msg) { 
		super(msg); 
	} 
} 

class Accounts { 
	private double balance; 
	private final double DAILY_LIMIT = 50000; 

	public Accounts(double balance) { 
		this.balance = balance; 
	} 

	public void withdraw(double amount) throws DailyLimitExceededException,InsufficientBalanceException { 

		if (amount > DAILY_LIMIT) 
			throw new DailyLimitExceededException("Error: Daily withdrawal limit ₹50,000 exceeded!"); 

		if (amount > balance) 
			throw new InsufficientBalanceException("Error: Insufficient balance!"); 

		balance -= amount; 
		System.out.println("Withdrawal Successful! Remaining Balance: ₹" + balance); 
	} 
} 

public class BankSystem { 
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		
		Account acc = new Account(100000);   // Initial balance ₹1,00,000 
		
		for (int i = 1; i <= 3; i++) {   // Allow multiple attempts 
			System.out.print("\nEnter amount to withdraw: "); 
			double amount = sc.nextDouble(); 

			try { 
				acc.withdraw(amount); 
			} 
			catch (DailyLimitExceededException e) { 
				System.out.println(e.getMessage()); 
			} 
			catch (InsufficientBalanceException e) { 
				System.out.println(e.getMessage()); 
			} 
			catch (Exception e) { 
				System.out.println("Unknown Error!"); 
			} 
		} 	
		sc.close() ;
	} 

} 
