package programs;

/*
Write a program to serialize a list of employees into a file and later deserialize it to display the 
data. 
Concepts: ObjectInputStream, ObjectOutputStream, Serializable interface.  
Write a program demonstrating all thread states (NEW, RUNNABLE, BLOCKED, WAITING, 
TIMED_WAITING, TERMINATED) with proper logging at each stage. 
Concepts: Thread control methods (sleep(), join(), wait()).
 */

import java.io.*; 
import java.util.*; 
class Employee implements Serializable { 
	int id; 
	String name; 
	double salary; 
	Employee(int id, String name, double salary) { 
		this.id = id; 
		this.name = name; 
		this.salary = salary; 
	} 
	public String toString() { 
		return "ID: " + id + ", Name: " + name + ", Salary: " + salary; 
	} 
} 
public class EmployeeSerializationDemo { 
	public static void main(String[] args) { 
		String filename = "employees.dat"; 
		
		List<Employee> empList = new ArrayList<>(); 
		empList.add(new Employee(101, "Alice", 50000)); 
		empList.add(new Employee(102, "Bob", 55000)); 
		empList.add(new Employee(103, "Charlie", 60000)); 
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) { 
			oos.writeObject(empList); 
			System.out.println("Employees serialized successfully..."); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} 
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) { 
			List<Employee> list = (List<Employee>) ois.readObject(); 
			System.out.println("\nDeserialized Employee Data:"); 
			for (Employee e : list) { 
				System.out.println(e); 
			} 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 

}
