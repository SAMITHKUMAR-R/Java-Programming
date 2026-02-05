package programs;

/*
Write a Java program to create three threads and set priority to these threads in the following 
ways: 
• T1 – MIN_PRIORITY 
• T2 – NORM_PRIORITY 
• T3 – MAX_PRIORITY
 */

class MyThread extends Thread { 
	public MyThread(String name) { 
		super(name); 
	} 
	public void run() { 
		System.out.println("Running: " + this.getName() + " | Priority: " + this.getPriority()); 
	} 	
}

public class ThreadPriorityDemo { 
	public static void main(String[] args) { 
		MyThread T1 = new MyThread("Thread T1"); 
		MyThread T2 = new MyThread("Thread T2"); 
		MyThread T3 = new MyThread("Thread T3"); 
		
		T1.setPriority(Thread.MIN_PRIORITY);   // Priority 1 
		T2.setPriority(Thread.NORM_PRIORITY);  // Priority 5 
		T3.setPriority(Thread.MAX_PRIORITY);   // Priority 10 
		
		T1.start(); 
		T2.start(); 
		T3.start(); 
	} 

} 
