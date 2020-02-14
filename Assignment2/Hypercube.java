import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Yu Zhong Yao
 * 215472616
 * Assignment 2
 * @author yao21
 *
 */
public class Hypercube {
	
	/**
	 * 
	 * @author yao21
	 *nested Corner class with fields dimensions and its coordinates;
	 */
	
	int counter = 0;
	public class Corner{
		int dimensions;
		private String s = "";
		
		
		public Corner (int n, String a) {
			this.dimensions = n;
			this.s = a;
		}
		
		
		
		
		
	}
	
	
	int dimensions;
	int numberOfCorners;
	private Corner c;
	
	
	public Hypercube(int n) {
		if(n <= 0) {
			System.out.print("Enter a positive n");
		}
		else {
			
			this.numberOfCorners = (int) Math.pow(2, n);
			this.dimensions = n;
			c = new Corner(n,"");
		}
	}
	
	
	/**
	 * recursively concatenate a string with 0 and 1 representing the coordinates 
	 * the corner
	 * @param n dimension
	 * @param s coordinate of the corner
	 */
	public void recursiveWalk( int n, String s) {
		//base case when the string has length of the dimensions
		//create new corner object
		//initialize it with the dimension and the concatenated string
		if( n == 0) {
			
			c.s = s;
			counter++;
			printOut(s);
		}
		
		//recursive case
		//passing 0 or 1 to be concatenated 
		//decrement n to know when to stop
		else {
	
			
			recursiveWalk(n - 1, s + "0");
		
			walkHelper( n - 1, s + "1");
			
		}
		
	}
	
	public void walkHelper(int n, String s) {
		if( n == 0) {
			
			c.s = s;
			counter++;
			printOut(s);
		}
		
		//recursive case
		//passing 0 or 1 to be concatenated 
		//decrement n to know when to stop
		else {
	
			
			recursiveWalk(n - 1, s + "1");
		
			walkHelper( n - 1, s + "0");
			
		}
	}
	
	/**
	 * Insert two versions of a string into the queue
	 * one with a concatenated "0" and the other with concatenated "1"
	 * pop the queue and repeat 
	 * @param n dimension of hypercube
	 */
	public void iterativeWalk (int n) {
		
		Queue<String> a = new ArrayDeque<String>();
		String s = "";
		a.add(s);
		boolean switchIt = true;
		for(int i = 0; i < Math.pow(2, n) - 1; i++) {
			if(switchIt) {
				s = a.remove();
				a.add(s + "0");
				a.add(s + "1");
				switchIt = !switchIt;
			}
			else {
				s = a.remove();
				a.add(s + "1");
				a.add(s + "0");
				switchIt = !switchIt;
			}
		}
		
		
		
		
		
		while(!a.isEmpty()) {
			String out = "";
			out += a.remove()  + "\n";
			System.out.print(out);
		}
		
		
	}
	
	
	
	
	
	public void printOut(String s) {
		if (s.matches("^[0]+$")) {
		    System.out.println("A walk:");
		}
		System.out.println(s);
	
		
	}
	
	
	
	
	
	
	
	public static void main(String args[]) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the dimension of the hypercube:");
		int n = s.nextInt();
		//int startTime = (int) System.currentTimeMillis();
		Hypercube h = new Hypercube(n);
		h.recursiveWalk( n, "");
		//h.iterativeWalk(n);
		//int result =  (int) System.currentTimeMillis() - startTime;
		//System.out.println("Time: " + (result / 1000) + " Counter: " + h.counter);
		
		s.close();
		
		
	}
	
	
	
	
	
	
}
