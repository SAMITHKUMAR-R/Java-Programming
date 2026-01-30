package programs;

/*
Consider a base class Payment with a method processPayment(). Classes CreditCardPayment, 
PaypalPayment, and BankTransferPayment override this method  Implement a method that 
accepts a Payment object and calls processPayment().Show how polymorphism enables 
processing different payment types.
 */

//Base class 
class Payment { 
	void processPayment() { 
		System.out.println("Processing generic payment..."); 
         } 
	} 
	// Subclass 1 
	class CreditCardPayment extends Payment { 
		void processPayment() { 
			System.out.println("Processing Credit Card Payment..."); 
         } 
	} 
	// Subclass 2 
	class PaypalPayment extends Payment { 
		void processPayment() { 
			System.out.println("Processing PayPal Payment..."); 
		} 
	} 
	//Subclass 3 
	class BankTransferPayment extends Payment { 
		void processPayment() { 
			System.out.println("Processing Bank Transfer Payment..."); 
		} 
	} 
	public class PaymentDemo { 
		// Method demonstrating polymorphism 
		static void makePayment(Payment p) { 
			p.processPayment();  // Runtime Polymorphism 
		} 
		public static void main(String[] args) { 
			Payment p1 = new CreditCardPayment(); 
			Payment p2 = new PaypalPayment(); 
			Payment p3 = new BankTransferPayment(); 
			makePayment(p1); // Calls CreditCardPayment version 
			makePayment(p2); // Calls PaypalPayment version 
			makePayment(p3); // Calls BankTransferPayment version 
   } 

} 
