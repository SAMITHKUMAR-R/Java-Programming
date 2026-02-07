package programs;

/*
A company maintains employee email IDs in the format "name@company.com". 
Write a program to extract the employee’s name part before "@". 
Ensure the name is displayed in uppercase. 
If the email does not contain "@", print "Invalid Email". 
Use substring() and toUpperCase(). 
Test with "karthik@tech.com". 
Expected output: "KARTHIK". 
 */

import java.util.Scanner; 
public class EmailNameExtractor { 
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)){ 
			System.out.println("Enter email ID:"); 
			String email = sc.nextLine(); 

			if (!email.contains("@")) { 
				System.out.println("Invalid Email"); 
			} 
			else { 
				int index = email.indexOf("@"); 
				String name = email.substring(0, index);
				System.out.println(name.toUpperCase()); 
			} 
		} 
	} 
}

