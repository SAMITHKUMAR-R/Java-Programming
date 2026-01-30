package programs;

/*
Create a java program to divide the following string into N number of substring using space as a 
delimiter and store all the splitted string Using String array and display the substrings.
 */

import java.util.Scanner; 
public class SplitStringDemo { 
	public static void main(String[] args) { 
		try (Scanner sc = new Scanner(System.in)){ 
			
			System.out.println("Enter a sentence:"); 
			String input = sc.nextLine(); 
		
			String[] parts = input.split(" "); 

			System.out.println("\nSubstrings:"); 
			for (String p : parts) { 
				System.out.println(p); 
			} 
		} 	
	}

}
