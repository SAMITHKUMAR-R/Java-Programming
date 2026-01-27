package programs;

/*
In a company an employee is paid as under: If his basic salary is less than Rs. 1500, then HRA = 
10% of basic salary and DA = 90% of basic salary. If his salary is either equal to or above Rs. 
1500, then HRA = Rs. 500 and DA = 98% of basic salary. If the employee's salary is input by the 
user write a program to find his gross salary.
*/

import java.util.Scanner; 
public class GrossSalary { 
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in); 
		System.out.print("Enter Basic Salary: "); 
		double basic = sc.nextDouble(); 
		double hra=0, da, gross; 
		if (basic < 1500) { 
			hra = basic * 0.10;   // 10% 
			da = basic * 0.90;    // 90% 
		} else { 
			da = basic * 0.98;    // 98% 
		} 
		gross = basic + hra + da; 
		System.out.println("Gross Salary = " + gross); 
		sc.close(); 
	} 
} 
