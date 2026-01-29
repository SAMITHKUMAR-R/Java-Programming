package programs;

/*
Handle the exception that may occur when the referenced element does not exist in 
the array. For e.g. If array is having only 5 elements and we are trying to display 7th 
element then it would throw this exception. 
 */

public class MultipleCatchDemo {
	public static void main(String[] args) { 
		try { 
		
			int[] arr = new int[6]; 
            arr[7] = 30;   
               } 
        catch (ArrayIndexOutOfBoundsException e) { 
        	System.out.println("Exception Caught: ArrayIndexOutOfBoundsException"); 
        } 
		
        catch (NullPointerException e) { 
        	System.out.println("Exception Caught: NullPointerException"); 
        }
		
		catch (Exception e) { 
			System.out.println("Exception Caught: General Exception"); 
		} 
	} 
} 



