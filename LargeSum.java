package programs;

import java.io.*;
import java.util.*;
import java.math.BigInteger; // Essential for large numbers


public class LargeSum {

		public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        if (!sc.hasNextInt()) return;
	        
	        int n = sc.nextInt();
	        BigInteger sum = BigInteger.ZERO;

	        for (int i = 0; i < n; i++) {
	            // Read each 50-digit number as a string
	            String bigNumStr = sc.next();
	            // Add it to the total sum
	            sum = sum.add(new BigInteger(bigNumStr));
	        }

	        // Convert sum to string and take the first 10 characters
	        String result = sum.toString();
	        System.out.println(result.substring(0, 10));
	    }

	}

