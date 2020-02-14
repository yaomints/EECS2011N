import java.util.Scanner;

/**
 * Yu Zhong Yao
 * 215472616
 * Assignment 2
 * @author yao21
 *
 */
public class Coins {
	
	
	final int QUARTER = 25;
	final int DIME = 10;
	final int NICKEL = 5;
	final int PENNY = 1;
	final int[] COINS = {PENNY, NICKEL, DIME, QUARTER};
	final String[] PLURAL = {"penny" , "pennies" , "nickel", "nickels", "dime", "dimes", "quarter" , "quarters"};
	final int[] NOC = {0, 0, 0,0};
	int count = 0;
	public Coins() {
		
	}
	
	public void ways(int money) {
		int index = COINS.length - 1;
		System.out.println("This amount can be changed in the following ways:");
		waysHelper(money, 0,0,0,0,index);
	}
	//recursive helper method which stores one of possibility the number of coins 
	//the given amount of money can be changed in
	public void waysHelper(int money, int q, int d, int n, int p, int index) {
		//base case 1 where all coins have summed together to initial money
		if(money == 0) {
			count++;
			printOut(q, d, n, p);
		}
		//base case 2 where the last possible amount that the money can be changed in
		//is penny/ies
		else if(index == 0 && money > 0) {
			p = money;
			count++;
			printOut(q,d,n,p);
			
		}
		
		//recursive case
		//check if a coin can be used to make change 
		//subtract from money and recursive call itself
		//then get original money value and call itself with 
		//a different coin
		//if can't change coin to check e.g. from quarter to dime
		//
		else {
			if(money >= COINS[index]) {
				money -= COINS[index];
				NOC[index] += 1;
				waysHelper(money, NOC[3], NOC[2], NOC[1], NOC[0], index);
				money+= COINS[index];
				NOC[index] -= 1;
				index--;
				waysHelper(money,NOC[3], NOC[2], NOC[1], NOC[0],index);
				
			}
			else {
				index--;
				waysHelper(money, NOC[3], NOC[2], NOC[1], NOC[0], index);
			}
		}
		
		
		
	}
	
	
	
	public String printOut(int q, int d, int n, int p) {
		String s = "";
		String pen = p + " ";
		pen += p > 1 ? PLURAL[1] + " ": PLURAL[0] + " ";
		String nic = n + " ";
		nic += n > 1 ? PLURAL[3] + " ": PLURAL[2] + " ";
		String dim = d + " ";
		dim += d > 1 ? PLURAL[5] + " ": PLURAL[4] + " ";
		String qua = q + " ";
		qua += q > 1 ? PLURAL[7] + " ": PLURAL[6] + " ";
		if( q == 0) {
			qua = "";
		}
		if(d == 0) {
			dim = "";
		}
		if(n == 0) {
			nic = "";
		}
		if(p == 0) {
			pen ="";
		}
		
		
		s +=  qua  + dim  + nic   + pen;
		
		System.out.println(s);
		System.out.println(count);
		
		return s;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter an amount in cents: \n");
		Scanner s = new Scanner(System.in);
		Coins c = new Coins();
		c.ways(s.nextInt());
		
	}

  		}
