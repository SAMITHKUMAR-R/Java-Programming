package programs;

/*
Design a java program for the following scenario: 
   Create an object to NumberFormatException explicitly in the try block. 
   Throw NumberFormatException object explicitly (manually) using throw keyword 
   Catch the manually thrown exception.
 */

public class NumberFormatDemo { 
	public static void main(String[] args) { 
		try { 
			// Explicitly creating NumberFormatException 
            NumberFormatException nf = new NumberFormatException("Manually exception"); 

            // Throwing it explicitly 
            throw nf; 
		} 
		catch (NumberFormatException e) { 
			System.out.println("Exception Caught: " + e.getMessage()); 
		} 
	} 
} 