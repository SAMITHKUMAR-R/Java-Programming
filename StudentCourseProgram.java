package programs;

/*
STUDENT (StudentID, Name, Department, Marks, Gender, City) 
COURSE (CourseID, CourseName, Credits) 
ENROLLMENT (StudentID, CourseID, Semester) 
        Find the number of students enrolled in each course. 
        List all students who have not enrolled in any course. 
        Display the highest and lowest marks in the ‘CSE’ department. 
        Count male and female students in each department.
*/

import java.util.*; 

class Student { 
	int id, marks; 
	String name, department, gender, city; 
	Student(int id, String name, String department, int marks, String gender, String city) { 
		this.id = id; 
		this.name = name; 
		this.department = department; 
		this.marks = marks; 
		this.gender = gender; 
		this.city = city; 
	} 
} 

class Course { 
	int courseID, credits; 
	String courseName; 
	Course(int courseID, String courseName, int credits) { 
		this.courseID = courseID; 
		this.courseName = courseName; 
		this.credits = credits; 
	} 
} 

class Enrollment { 
	int studentID, courseID; 
	String semester; 
	Enrollment(int studentID, int courseID, String semester) { 
		this.studentID = studentID; 
		this.courseID = courseID; 
		this.semester = semester; 
	} 
} 

public class StudentCourseProgram { 
	public static void main(String[] args) { 
		
		// 1. Stud Data 
		ArrayList<Student> students = new ArrayList<>(); 
		students.add(new Student(1, "Arun", "CSE", 85, "Male", "Chennai")); 
		students.add(new Student(2, "Priya", "ECE", 78, "Female", "Salem")); 
		students.add(new Student(3, "Kumar", "CSE", 92, "Male", "Erode")); 
		students.add(new Student(4, "Divya", "IT", 67, "Female", "Coimbatore")); 
		students.add(new Student(5, "Vijay", "CSE", 55, "Male", "Madurai"));
		
		// 2. Course Data 
		ArrayList<Course> courses = new ArrayList<>(); 
		courses.add(new Course(101, "Java", 4)); 
		courses.add(new Course(102, "Python", 3)); 
		courses.add(new Course(103, "DBMS", 4)); 
		// 3. Enrollment Data 
		ArrayList<Enrollment> enrollments = new ArrayList<>(); 
		enrollments.add(new Enrollment(1, 101, "Sem1")); 
		enrollments.add(new Enrollment(2, 101, "Sem1")); 
		enrollments.add(new Enrollment(3, 102, "Sem2")); 
		enrollments.add(new Enrollment(4, 103, "Sem2")); 
		// Student 5 not enrolled 
		System.out.println("1) Students enrolled in each course:"); 
		for (Course c : courses) { 
			int count = 0; 
			for (Enrollment e : enrollments) { 
				if (e.courseID == c.courseID) { 
					count++; 
				} 
			} 
			System.out.println(c.courseName + " = " + count + " students"); 
		} 
		System.out.println("\n2) Students NOT enrolled in any course:"); 
		for (Student s : students) { 
			boolean enrolled = false; 
			for (Enrollment e : enrollments) { 
				if (e.studentID == s.id) { 
					enrolled = true; 
					break; 
				} 
			} 
			if (!enrolled) { 
				System.out.println(s.name + " (" + s.id + ")"); 
			} 
		} 
		System.out.println("\n3) Highest & Lowest marks in CSE:"); 
		int highest = Integer.MIN_VALUE; 
		int lowest = Integer.MAX_VALUE; 
		for (Student s : students) { 
			if (s.department.equals("CSE")) { 
				if (s.marks > highest) highest = s.marks; 
				if (s.marks < lowest) lowest = s.marks; 
			} 
		} 
		System.out.println("Highest Marks: " + highest); 
		System.out.println("Lowest Marks: " + lowest);
		
		// QUERY 4: Count male & female in each department 
		System.out.println("\n4) Male & Female count in each department:"); 
		HashMap<String, Integer> maleCount = new HashMap<>(); 
		HashMap<String, Integer> femaleCount = new HashMap<>(); 
		for (Student s : students) { 
			if (s.gender.equalsIgnoreCase("Male")) { 
				maleCount.put(s.department, maleCount.getOrDefault(s.department, 0) + 1); 
			} else { 
				femaleCount.put(s.department, femaleCount.getOrDefault(s.department, 0) + 1); 
			} 
		} 
		// Display department-wise 
		for (String dept : maleCount.keySet()) { 
			System.out.println(dept + " -> Male: " + maleCount.getOrDefault(dept, 0) + ", Female: " + femaleCount.getOrDefault(dept, 0)); 
		} 
	} 
} 


