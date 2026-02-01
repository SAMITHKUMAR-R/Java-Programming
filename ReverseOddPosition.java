package programs;

/*
Get the string from user like ‘Java is Object Oriented Language’. Find the reverse of this string 
and print it using string methods and display the elements present in the odd position. 
 */

import java.util.Scanner; 
public class ReverseOddPosition { 
	public static void main(String[] args) { 
		try (Scanner sc = new Scanner(System.in)){ 
			// Input 
			System.out.println("Enter a string:"); 
			String str = sc.nextLine(); 
			// Reverse using StringBuilder 
			String reversed = new StringBuilder(str).reverse().toString(); 
			System.out.println("Reversed String: " + reversed); 
			// Display characters at odd positions (index starts from 0) 
			System.out.print("Characters at odd positions: "); 
			for (int i = 0; i < str.length(); i++) { 
				if (i % 2 != 0) { 
					System.out.print(str.charAt(i) + " "); 
				} 
			} 
		}
	}
}

