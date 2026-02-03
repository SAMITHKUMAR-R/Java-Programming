package programs;

/*
Insert Employee Details Using Statement:Write a Java program to insert a new employee record 
into an Employee table using a Statement object. 
The table has columns: (emp_id, emp_name, dept, salary). 
Tasks: 
Accept employee details from the user using Scanner. 
Construct an SQL query string dynamically. 
Execute using executeUpdate(). 
Concepts: 
Basic JDBC connectivity, use of Statement, and dynamic SQL construction.
 */

import java.sql.*; 
import java.util.Scanner; 

public class InsertEmployee { 
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in); 
		try { 
			// 1. Accept employee details 
			System.out.print("Enter Employee ID: "); 
			int emp_id = sc.nextInt(); 
			sc.nextLine(); // consume newline 
			System.out.print("Enter Employee Name: "); 
			String emp_name = sc.nextLine(); 
			System.out.print("Enter Department: "); 
			String dept = sc.nextLine(); 
			System.out.print("Enter Salary: "); 
			double salary = sc.nextDouble(); 
			
			// 2. Load Driver (Optional for newer versions) 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			
			// 3. Establish Connection 
			Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/yourdbname","root", "password" ); 
			
			// 4. Create Statement 
			Statement stmt = con.createStatement(); 
			
			// 5. Construct SQL Query (Dynamic SQL) 
			String query = "INSERT INTO Employee(emp_id, emp_name, dept, salary) VALUES(" + emp_id + ", '" + emp_name + "', '" + dept + "', " + salary + ")"; 
			
			// 6. Execute Query 
			int rows = stmt.executeUpdate(query); 
			
			// 7. Display result 
			if (rows > 0) { 
				System.out.println("Employee record inserted successfully!"); 
			} 
			
			// 8. Close connection 
			stmt.close(); 
			con.close(); 
		} 
		catch (Exception e) { 
			System.out.println("Error: " + e); 
		} 
		sc.close(); 
	} 

} 
