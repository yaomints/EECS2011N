/**********************************************************
 * EECS2011ON: Fundamentals of Data Structures,  Winter 2020
 * Assignment 1, Problem 2: ArrayLongestPlateau.java
 * Student Name:     Yu Zhong Yao
 * Student EECS account:  yao21	
 * Student ID number:  215472616 
 **********************************************************/

package A1;

/**
 * The purpose of this class is to find the longest plateau of an array of ints. 
 * 
 * The main method runs some tests.
 * 
 * @author Yu Zhong Yao
 * 
 */

public class ArrayLongestPlateau {

  	/**
	 * longestPlateau() returns the longest plateau of an array of ints.
	 * 
	 * @return an array int[3] of the form {value, start, len} representing the longest plateau of
	 *         ints[] as a length len contiguous subarray starting at index start with common
	 *         element values value.
	 * 
	 *         For example, on the input array [2, 3, 3, 3, 3, 6, 6, 1, 1, 1], it returns [6, 5, 2],
	 *         indicating the longest plateau of this array is the subarray [6, 6]; it starts at
	 *         index 5 and has length 2.
	 * 
	 * @param ints
	 *            the input array.
	 */

	public static int[] longestPlateau(int[] ints) {

		// TODO: Replace the following one line stub with your solution. Ours takes linear time and is
		// 24 lines long, not counting blank/comment lines or lines already present in this file.
		int[] result = new int[3];   //variables to hold the longest plateau value, start index, 
		boolean prevIsLower = true;  //and length
		int value = ints[0], startIndex = 0, length = 1;
		int clength = 1;			//current value, index, len to compare to longest plateau
		int cValue = ints[0];
		int cStartIndex = 0;
		
		
		for(int i = 0; i < ints.length-1; i++) { 
			if(ints[i] == ints[i + 1]) {			//loop through array comparing next element
				clength++;
				if((i == ints.length -2) && (clength > length) && prevIsLower){
					length = clength;	//if plateau is at end of array
					value = cValue;		//and is longest, set value, length, index
					startIndex = cStartIndex;// for this plateau
				}
			}
			else if(ints[i] < ints[i + 1])  {
				prevIsLower = true;		//if next element is greater, change
				cValue = ints[i + 1];	//current variables for the element
				cStartIndex = i + 1;
				clength = 1;
			}
			else if((ints[i] > ints[i + 1])) {
			//if next element is lower and it's a plateau
			//compare if current plateau is longer that
			//longest plateau so far
				if(prevIsLower && (clength > length)) {
					length = clength;
					value = cValue;
					startIndex = cStartIndex;
					clength = 1;
					cValue = ints[i + 1];
					cStartIndex = i + 1;
				}
				prevIsLower = false;
			}
		}
		
		result[0] = value;      //return array giving value, start index, and length of longest plateau
		result[1] = startIndex;
		result[2] = length;
		return result;
	}


  	/**
	 * main() runs test cases on your longestPlateau() method. Prints summary
	 * information on basic operations and halts with an error (and a stack
	 * trace) if any of the tests fail.
	 */

	public static void main(String[] args) {
		String result;

		System.out.println("Let's find longest plateaus of arrays!\n");

		int[] test1 = { 4, 1, 1, 6, 6, 6, 6, 1, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test1) + ":");
		result = TestHelper.stringInts(longestPlateau(test1));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 6 , 3 , 4 ]"),
				"Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test2 = { 3, 3, 1, 2, 4, 2, 1, 1, 1, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test2) + ":");
		result = TestHelper.stringInts(longestPlateau(test2));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals(
		  "[ 3 , 0 , 2 ]"),
				"Wrong: that's not the longest plateau!!!  No chocolate.");
		
		int[] test3 = { 3, 3, 1, 2, 4, 0, 1, 1, 1, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test3) + ":");
		result = TestHelper.stringInts(longestPlateau(test3));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 1 , 6 , 4 ]"),
				"Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test4 = { 3, 3, 3, 4, 1, 2, 4, 4, 0, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test4) + ":");
		result = TestHelper.stringInts(longestPlateau(test4));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 4 , 6 , 2 ]"),
				"Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test5 = { 7, 7, 7, 7, 9, 8, 2, 5, 5, 5, 0, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test5)
				+ ":");
		result = TestHelper.stringInts(longestPlateau(test5));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 5 , 7 , 3 ]"),
				"Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test6 = { 4 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test6) + ":");
		result = TestHelper.stringInts(longestPlateau(test6));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 4 , 0 , 1 ]"),
				"Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test7 = { 4, 4, 4, 5, 5, 5, 6, 6 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test7) + ":");
		result = TestHelper.stringInts(longestPlateau(test7));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 6 , 6 , 2 ]"),
				"Wrong: that's not the longest plateau!!!  No chocolate.");

		System.out.println("\nAdditional tests done by the student or TA:\n");

		// Insert your additional test cases here.
		
		
		int[] test8 = { 4, 4, 4, 2, 5, 5, 5, 6, 6 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test8) + ":");
		result = TestHelper.stringInts(longestPlateau(test8));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 4 , 0 , 3 ]"),
				"Wrong: that's not the longest plateau!!!  No chocolate.");
		
		int[] test9 = { 0, 0, 0, 0, 0, 0 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test9) + ":");
		result = TestHelper.stringInts(longestPlateau(test9));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 0 , 0 , 6 ]"),
				"Wrong: that's not the longest plateau!!!  No chocolate.");
		
		
		int[] test10 = { -1, -1, -2, -2, -2, -1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test10) + ":");
		result = TestHelper.stringInts(longestPlateau(test10));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ -1 , 0 , 2 ]"),
				"Wrong: that's not the longest plateau!!!  No chocolate.");
		
		int[] test11 = { -2, -2, -2, -2, -2, -1, -1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test11) + ":");
		result = TestHelper.stringInts(longestPlateau(test11));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ -1 , 5 , 2 ]"),
				"Wrong: that's not the longest plateau!!!  No chocolate.");
		
		
		int[] test12 = { 1, -1, 1, -1, -1, 1, 1, 2, 2, 2, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test12) + ":");
		result = TestHelper.stringInts(longestPlateau(test12));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 2 , 7 , 3 ]"),
				"Wrong: that's not the longest plateau!!!  No chocolate.");
		
		int[] test13 = { -1, -1, -1, -1, -1, 1, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test13) + ":");
		result = TestHelper.stringInts(longestPlateau(test13));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 1 , 5 , 2 ]"),
				"Wrong: that's not the longest plateau!!!  No chocolate.");
		
		
		
		
		
	}
}