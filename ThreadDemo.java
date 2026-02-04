package programs;

/*
Create the classes named thread A and B by extending the thread class . the run method of each 
thread class should contains the code to display the number from 1-10 line after every 5 seconds.
 */

class ThreadA extends Thread { 
	public void run() { 
		try { 
			for (int i = 1; i <= 10; i++) { 
				System.out.println("Thread A: " + i); 
				Thread.sleep(5000); // 5s delay 
			} 
		}
		catch (InterruptedException e) { 
			System.out.println(e); 
		}
	}
}
class ThreadB extends Thread { 
	public void run() { 
		try { 
			for (int i = 1; i <= 10; i++) { 
				System.out.println("Thread B: " + i); 
				Thread.sleep(5000); // 5s delay 
			} 
		} 
		catch (InterruptedException e) { 
			System.out.println(e); 
		} 
	}
}
public class ThreadDemo { 
	public static void main(String[] args) { 
		ThreadA t1 = new ThreadA(); 
		ThreadB t2 = new ThreadB();
		t1.start(); 
		t2.start(); 
	} 

}
