package programs;

/*
Handle the exception that may occur when the referenced element does not exist in 
the array. For e.g. If array is having only 5 elements and we are trying to display 7th 
element then it would throw this exception. 
 */

public class MultipleCatchDemo {
	public static void main(String[] args) { 
		try { 
			// Array of size 6 
			int[] arr = new int[6]; 
			// Storing value 30 in 8th position → index 7 
            arr[7] = 30;   
               } 
        // 1st catch – Specific exception 
        catch (ArrayIndexOutOfBoundsException e) { 
        	System.out.println("Exception Caught: ArrayIndexOutOfBoundsException"); 
        } 
		
        // 2nd catch – Another specific exception 
        catch (NullPointerException e) { 
        	System.out.println("Exception Caught: NullPointerException"); 
        }
		
		// 3rd catch – General exception (catch-all) 
		catch (Exception e) { 
			System.out.println("Exception Caught: General Exception"); 
		} 
	} 
} 


