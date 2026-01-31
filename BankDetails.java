package programs;

/*
Design a java program for displaying the bank account and balance details using the following 
steps; 
Create the class with the name of 'Account' and declare the variables 'accno' and 'balance' as int 
and double respectively .  
Create three constructors with the same of the class name Account(),Account(int  
an),Account(int  an, double  amt) Create another three methods namely read(int an), read(int an, 
double amt) and print() 
From the main class 'BankDetails' create  objects for each constructors like a1, a2, a3, a4 and  
Call the method read using one argument read(2) 
Call the method read using two arguments read(3,600) 
Call the methods a1.print(),a2.print(),a3.print(),a4.print() and a5.print() . 
 */

class Account { 
    int accno; 
    double balance; 
 
    // Default constructor 
    Account() { 
        accno = 0; 
        balance = 0.0; 
    } 
    // Constructor with accno only 
    Account(int an) { 
        accno = an; 
        balance = 0.0; 
    } 
    // Constructor with accno and balance 
    Account(int an, double amt) { 
        accno = an; 
        balance = amt; 
    } 
  
    void read(int an) { 
        accno = an;
    }
    
    void read(int an, double amt) { 
        accno = an; 
        balance = amt; 
    } 
 
    // print() method 
    void print() { 
        System.out.println("Account No: " + accno + "  Balance: " + balance); 
    } 
} 
 
public class BankDetails { 
    public static void main(String[] args) { 
 
        Account a1 = new Account();              // default constructor 
        Account a2 = new Account(101);           // one-arg constructor 
        Account a3 = new Account(102, 5000);     // two-arg constructor 
        Account a4 = new Account();              // will use read(1arg) 
        Account a5 = new Account();              // will use read(2arg) 
 
        a4.read(2);        
        a5.read(3, 600);     
 
        // Print details 
        a1.print(); 
        a2.print(); 
        a3.print(); 
        a4.print(); 
        a5.print(); 
    } 
} 

