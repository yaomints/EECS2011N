
 /**********************************************************
 * EECS2011ON: Fundamentals of Data Structures,  Winter 2020
 * Assignment 1, Problem 1: ArraySqueeze.java
 * Student Name:   Yu Zhong Yao
 * Student EECS account:  yao21	
 * Student ID number:  215472616 
 **********************************************************/
 
package A1;



/**
 * 
 * @author yao21
 *
 */
public class Window {
	
	private class InvalidWindowException extends Exception {

		/**
		 *  Throw exception if invariant is not satisfied
		 */
		private static final long serialVersionUID = 1L;
		public InvalidWindowException(String ex) {
			super(ex);
		}
		
	}
	protected double left, right, bottom, top;
	/** given fields of window, check if fields pass the invariant of left < right and 
	 * bottom < top
	 * 
	 * @param left
	 * @param right
	 * @param bottom
	 * @param top
	 * @return boolean
	 */
	public boolean invariant(double left, double right, double bottom, double top) {
		
		if((left < right) && (bottom < top)) { 
			return true;
		}
		return false;
	}
	/** Initializes window with given parameters
	 * 
	 * @param left
	 * @param right
	 * @param bottom
	 * @param top
	 * @throws InvalidWindowException
	 */
	public Window(double left, double right, double bottom, double top) throws InvalidWindowException {
		if((invariant(left,right,bottom,top))) {
			this.left = left;
			this.right = right;
			this.bottom = bottom;
			this.top = top;
		}
		else {
			
			throw new InvalidWindowException("Invariant not satisfied");
		
		}
	}
	/**
	 * 
	 * @return bottom
	 */
	public double getBottom() {
		return this.bottom;
	}
	/**
	 * 
	 * @return top 
	 */
	public double getTop() {
		return this.top;
	}
	/**
	 * 
	 * @return left
	 */
	public double getLeft() {
		return this.left;
	}
	/**
	 * 
	 * @return right
	 */
	public double getRight() {
		return this.right;
	}
	/**
	 * set bottom field to a
	 * @param a  
	 * @throws InvalidWindowException
	 */
	public void setBottom(double a) throws InvalidWindowException {
		if(!(invariant(this.getLeft(),this.getRight(),a,this.getTop()))) {
			throw new InvalidWindowException("Invariant not satisfied");
		}
		else {
			this.bottom = a;
		}
		
	}
	/**
	 * set top field to b
	 * @param b
	 * @throws InvalidWindowException
	 */
	 public void setTop(double b) throws InvalidWindowException{
		if(!(invariant(this.getLeft(),this.getRight(),this.getBottom(),b))) {
			throw new InvalidWindowException("Invariant not satisfied");
		}
		else {
			this.top = b;
		}
	}
	/**
	 * set left field to c
	 * @param c
	 * @throws InvalidWindowException
	 */
	public void setLeft(double c) throws InvalidWindowException{
		if(!(invariant(c,this.getRight(),this.getBottom(),this.getTop()))) {
			throw new InvalidWindowException("Invariant not satisfied");
		}
		else {
			this.left = c;
		}
		
	}
	/**
	 * set right to d
	 * @param d
	 * @throws InvalidWindowException
	 */
	public void setRight(double d) throws InvalidWindowException{
		if(!(invariant(this.getLeft(),d,this.getBottom(),this.getTop()))) {
			throw new InvalidWindowException("Invariant not satisfied");
		}
		else {
			this.right = d;
		}
		
	}
	/**
	 * checks if window w is not outside this window
	 * @param w, window
	 * @return result
	 */
	public boolean encloses(Window w) {
		
		if(this.left < w.left  && this.right > w.right && this.top > w.top && this.bottom < w.bottom) {
			return true;
		}
		return false;
	}
	/**
	 * checks if window w has any part inside this window
	 * @param w
	 * @return
	 */
	public boolean overlaps(Window w) {
		boolean result = true;
		if(this.left >= w.right || w.left >= this.right) {
			result = false;
		}
		if( this.top <= w.bottom || this.bottom>= w.top) {
			result = false;
		}
		return result;
	}
	/**
	 * counts how many windows are overlapping
	 * @param windows
	 * @return
	 */
	static int overlapCount(Window[] windows) {
		int count = 0;
		for(int j = 0; j < windows.length - 1; j++) {
			for (int i = j + 1; i < windows.length; i++) {
				if((windows[j].overlaps(windows[i]))) {
					count++;
				}
			}
		}
		return count;
	}
	
/**
 * counts how many windows are enclosed in each other
 * @param windows
 * @return
 */
	static int enclosureCount(Window[] windows) {
		int count = 0;
		for(int j = 0; j < windows.length - 1; j++) {
			for (int i = j + 1; i < windows.length ; i++) {
				if((windows[j].encloses(windows[i]))) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws InvalidWindowException  {
		
		
		
		
		Window[] testWindow = new Window[5];
		testWindow[0] = new Window(-1,5,0,5);
		testWindow[1] = new Window(0.1,1.1,3,4);
		testWindow[2] = new Window(10,12,14,20);
		testWindow[3] = new Window(-4,-1,-1,1);
		testWindow[4] = new Window(-1.6,5,10,200);
		System.out.print(enclosureCount(testWindow)+"\n");
		System.out.print(testWindow[1].getRight()+"\n");
		System.out.print(testWindow[2].getTop()+"\n");
		System.out.print(testWindow[3].getLeft()+"\n");
		System.out.print(testWindow[4].getBottom()+"\n");
		System.out.print(testWindow[0].encloses(testWindow[1]) + "\n");
		System.out.print(testWindow[1].encloses(testWindow[0]) + "\n");
		System.out.print(testWindow[0].overlaps(testWindow[1]) + "\n");
		System.out.print(testWindow[4].overlaps(testWindow[1])+"\n");
		System.out.print(enclosureCount(testWindow)+"\n");
		System.out.print(overlapCount(testWindow)+"\n");
		
		
		
		//randomized tests cases that pass invariant
		Window[] randWindows = new Window[30];
		for(int i = 0; i < randWindows.length ; i++) {
			double l = Math.random() ;
			double r = Math.random() * 1000;
			double b = Math.random() * -50;
			double t = Math.random() * 1000;
			randWindows[i] = new Window(l,r,b,t);
		}
		for(int j = 0; j < randWindows.length - 1; j++) {
			System.out.println(randWindows[j].getRight());
			System.out.println(randWindows[j].getLeft());
			System.out.println(randWindows[j].getBottom());
			System.out.println(randWindows[j].getTop());
			System.out.println(randWindows[j].encloses(randWindows[j + 1]));
			System.out.println(randWindows[j].overlaps(randWindows[j + 1]));
			System.out.println(enclosureCount(randWindows));
			System.out.println(overlapCount(randWindows));
		}
		
		
		//invariant tests
		Window a = new Window(0,0,0,0);
		testWindow[0].setBottom(5);
		testWindow[0].setRight(-1);
		testWindow[0].setLeft(3);
		testWindow[0].setTop(0);
		
	}
	
	
	
}