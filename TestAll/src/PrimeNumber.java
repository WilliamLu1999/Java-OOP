
public class PrimeNumber {
	public static void primeNumbers( int n ) {
		
		String  primes = "";
		for (int i = 1; i <= n; i++)  	   
	      { 		 		  
	         int count=0; 		  
	         for(int num =i; num>=1; num--)
	         {
	        	 if(i%num==0){
	        		
	        		 count += 1;
		    }
		 }
	     // since prime only has two divisors 1 and itself
		 if (count ==2){
		    primes += i + " ";
		  }	
	      }	
	     
	      System.out.println(primes);
	   }
		
	
	
		
		public static void primeNumbersRecursion( int n ) {
		// fill here (b)
		int count =0;
		
		if(n>1){
			for(int i=1;i<=n;i++) {
				if(n%i==0) {
					count+=1;
				}
			}
		if(count==2) {
			System.out.println(n);
			
			
		}
		primeNumbersRecursion(n-1);
		
		}
		}
		
		
		public static void main(String[] args) {
		
			primeNumbersRecursion(1999);
		
		}

}
