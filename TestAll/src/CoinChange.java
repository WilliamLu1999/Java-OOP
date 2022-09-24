
public class CoinChange {
	public static int coinChange(int[] denominations, int change) {
		if(change == 0) {
			return 0;
		}
		else {
		int min = Integer.MAX_VALUE;
		// minimum is initialized as infinity
		// if the coin cannot be paid using the given denomination
		// ex. denomination [5] and change 1, this should return infinity
		// part b
		// You are allowed to use one for/while loop for part b
		for (int i=0;i<denominations.length;i++) {
			if(denominations[i]<=change) {
				int min_1 =coinChange(denominations,change-denominations[i]);
				
				if(min_1!=Integer.MAX_VALUE && min_1+1<min) {
					min = min_1+1;
				}
			}
			
		}
		
		
		
		
		
		return min;
		// min should return the answer
		}
		
		}
	public static void main(String[]args) {
		 int coins[] =  {9, 6, 5};
	       int m = coins.length;
	       int V = 88;
	       System.out.println("Minimum coins required is "+ coinChange(coins, V) );
	    }
	}

