
public class FastMatrixPower {
	
	public static int[][]multiply(int[][]first,int[][]second){
		// assume the matrix is n by n
		int [][]product =new int[first.length][first.length];
		for(int i =0;i<first.length;i++) {
			for(int j=0;j<first[0].length;j++) {
				for(int l =0;l<first[0].length;l++) {
					product[i][j]+=first[i][l]*second[l][j];
				}
			}
		}
		return product;
	}
	static int [][] o = {{1,1,4},{2,1,1},{1,2,3}};
	static int[][] p = {{1,2,3},{2,1,3},{1,1,1}};
	static int[][]q = {{5,5,5},{2,3,4},{2,2,2}};
	
	
	public static int[][] powers(int [][]matrix, int k) {
		if (k==0) {
			for(int i =0;i<matrix.length;i++) {
				for(int j=0;j<matrix[0].length;j++) {
					if(i==j)
						matrix[i][j]=1;
					else
						matrix[i][j]=0;
				}
				

		}
			return matrix;
		}
		
		int [][]square = powers(matrix,k/2);
		

				
		if(k%2==0) {
			int[][]h=multiply(square,square);
			
			return h;
		}
			
			
		else{

			
			int[][]temp = multiply(square,square);
		
			
			return multiply(temp,matrix);
				
			}
			
	
	
	
			}	 
		
		
	
		
	

}
