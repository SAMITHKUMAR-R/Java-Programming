package programs;

/*
A boy has two objects of shapes in circle and rectangle and he is asked to find the area of the 
shapes. He must go behind the following rules to complete his task. 
He has to use the same name for the methods used to find the area of circle and rectangle.He has 
to pass the parameters for those methods based on the shape. 
Finally he need to call both the methods with required parameters and display the area. 
*/

import java.util.Scanner; 
class ShapeArea { 
    // Area of circle (one parameter) 
    double area(double radius) { 
        return 3.14 * radius * radius; 
    } 
    // Area of rectangle (two parameters) 
    double area(double length, double breadth) { 
        return length * breadth; 
    } 
} 
public class AreaCalculation { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        ShapeArea obj = new ShapeArea(); 
 
        // Circle input 
        System.out.print("Enter radius of circle: "); 
        double r = sc.nextDouble(); 
        double circleArea = obj.area(r); 
 
        // Rectangle input 
        System.out.print("Enter length of rectangle: "); 
        double l = sc.nextDouble(); 
        System.out.print("Enter breadth of rectangle: "); 
        double b = sc.nextDouble(); 
        double rectArea = obj.area(l, b); 
 
        // Output 
        System.out.println("Area of Circle = " + circleArea); 
        System.out.println("Area of Rectangle = " + rectArea); 
 
        sc.close(); 
    } 
} 

