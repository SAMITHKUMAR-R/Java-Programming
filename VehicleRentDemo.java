package programs;

/*
Consider a superclass Vehicle with a method calculateRent(). Subclasses Car, Bike, and Truck 
override this method to apply different rental rates and discounts. Implement a method that takes 
an array of Vehicle objects and prints the rental cost for each. Create a java code to explain how 
polymorphism helps in calling the correct calculateRent() dynamically at runtime.
 */

class Vehicle { 
	double calculateRent() { 
	return 0; 
	} 
} 
class Car extends Vehicle { 
	double calculateRent() { 
		double rent = 1000;     // base rent 
		double discount = 0.10; // 10% discount 
		return rent - (rent * discount); 
        } 
} 

class Bike extends Vehicle { 
	double calculateRent() { 
		double rent = 300;      // base rent 
		double discount = 0.05; // 5% discount 
		return rent - (rent * discount); 
	} 
} 

class Truck extends Vehicle { 
	double calculateRent() { 
		double rent = 2000;     // base rent 
		double discount = 0.15; // 15% discount 
		return rent - (rent * discount); 
	} 
} 
public class VehicleRentDemo { 

	static void printRentalCosts(Vehicle[] vehicles) { 
		for (Vehicle v : vehicles) { 
			System.out.println("Rental Cost: " + v.calculateRent()); 
        } 
} 

public static void main(String[] args) { 
	Vehicle[] list = { 
			new Car(), 
			new Bike(), 
			new Truck() 
			};
		printRentalCosts(list); 
	} 

}
