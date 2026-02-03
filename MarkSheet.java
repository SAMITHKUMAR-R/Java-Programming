package programs;

/*
'John' studying in the government engineering college plans to create software to prepare the 
mark sheet that contains the mark and grade details. He is instructed to prepare the software 
using java language and use the method of Scanner class of UTIL package to receive the input 
from the user. Display the details.
*/

import java.util.Scanner; 
public class MarkSheet { 
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in); 
		
        System.out.print("Enter Mark: "); 
        double mark = sc.nextDouble(); 
        System.out.print("Enter Grade: "); 
        String grade = sc.next(); 

        System.out.println("Mark : " + mark); 
        System.out.println("Grade : " + grade); 
        sc.close(); 
	}

} 
