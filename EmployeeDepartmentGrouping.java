package programs;

/*
A company maintains a record of employees and their departments . Employee name is stored as 
the key, and department is the value in a HashMap. You must group all employees who belong to 
the same department . Display the department name along with the list of employees working in 
it. Ensure duplicate employee names are not inserted. Write the program using Map collection. 
 */

import java.util.*; 

public class EmployeeDepartmentGrouping { 
	public static void main(String[] args) { 
 
		// Store employees and departments 
		Map<String, String> employeeMap = new HashMap<>(); 
 
        // Adding employees (duplicate names will not be added) 
        employeeMap.put("Arun", "HR"); 
        employeeMap.put("Kumar", "IT"); 
        employeeMap.put("Priya", "HR"); 
        employeeMap.put("Vinoth", "Finance"); 
        employeeMap.put("Kavya", "IT"); 
        employeeMap.put("Arun", "IT");  // Duplicate key - ignored by HashMap 
 
        // Grouping employees by department 
        Map<String, ArrayList<String>> departmentMap = new HashMap<>(); 
 
        for (Map.Entry<String, String> entry : employeeMap.entrySet()) { 
            String employee = entry.getKey(); 
            String department = entry.getValue(); 
 
            // If department not found, create list 
            departmentMap.putIfAbsent(department, new ArrayList<>()); 
 
            // Add employee to respective department list 
            departmentMap.get(department).add(employee); 
        } 
 
        // Display department-wise employees 
        System.out.println("Department-wise Employees:"); 
        for (String dept : departmentMap.keySet()) { 
            System.out.println(dept + " : " + departmentMap.get(dept)); 
        }
	} 
}