package programs;

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class LargeSum {
		public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        if (!sc.hasNextInt()) return;
	        int n = sc.nextInt();
	        BigInteger sum = BigInteger.ZERO;
	        for (int i = 0; i < n; i++) {
	            String bigNumStr = sc.next();
	            sum = sum.add(new BigInteger(bigNumStr));
	        }
	        String result = sum.toString();
	        System.out.println(result.substring(0, 10));
	    }

	}



