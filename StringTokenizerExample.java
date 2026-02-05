package programs;

/*
Parse the following string using string Tokenizer  methods: 
12/34/56/78/90/00 
www.java.io.stringtokenizer.parsestring. 
Parse the following string using string Tokenizer  methods
 */

import java.util.StringTokenizer; 

public class StringTokenizerExample { 
 
    public static void main(String[] args) { 
 
        String s1 = "12/34/56/78/90/00"; 
        StringTokenizer st1 = new StringTokenizer(s1, "/"); 
 
        System.out.println("Tokens from first string:"); 
        while (st1.hasMoreTokens()) { 
            System.out.println(st1.nextToken()); 
        } 
 
        String s2 = "www.java.io.stringtokenizer.parsestring"; 
        StringTokenizer st2 = new StringTokenizer(s2, "."); 
 
        System.out.println("\nTokens from second string:"); 
        while (st2.hasMoreTokens()) { 
            System.out.println(st2.nextToken()); 
        } 
    } 
	} 

