package programs;

/*
Consider a scenario, Bank is a class that provides method to get the rate of interest. But, rate of 
interest may differ according to banks. For example, SBI, ICICI and AXIS banks could provide 
8%, 7% and 9% rate of interest. Create a java code for the mentioned scenario and show that it 
achieves run time polymorphism . 
*/

class Bank { 
    double getRateOfInterest() { 
     return 0; 
           } 
     } 
     class SBI extends Bank { 
     double getRateOfInterest() { 
     return 8.0; 
  } 
} 

class ICICI extends Bank { 
  double getRateOfInterest() { 
      return 7.0; 
  } 
} 

class AXIS extends Bank { 
  double getRateOfInterest() { 
      return 9.0; 
  } 
} 

public class BankInterest { 
  public static void main(String[] args) { 
      Bank b; 
      b = new SBI();  
      System.out.println("SBI Rate of Interest: " + b.getRateOfInterest() + "%"); 
      b = new ICICI();
      System.out.println("ICICI Rate of Interest: " + b.getRateOfInterest() + "%"); 
      b = new AXIS(); 
      System.out.println("AXIS Rate of Interest: " + b.getRateOfInterest() + "%"); 
  } 

}
