package programs;

/*
  A group of students attending  the evening class in the school for learning programming 
concepts. Get the total number of students and check whether  the total is odd or even. Guide 
them  to find the type of given number  without using  % operator.
*/

import java.util.Scanner;

public class OddEvenCheck { 
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in); 
        System.out.print("Enter total number of students: "); 
        int num = sc.nextInt(); 
       
        int quotient = num / 2; 
        int test = quotient * 2; 
        if (test == num) { 
        	System.out.println("The number is EVEN."); 
        } else { 
        	System.out.println("The number is ODD."); 
        } 
        sc.close(); 
   }

}
