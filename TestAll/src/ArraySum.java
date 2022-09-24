
public class ArraySum {
// returns the sum of input array elements with index >= lowIndex and <highIndex
// arraySum(input, 0, input.length) should return the total sum
	
public static int arraySum(int[] input, int lowIndex, int highIndex) {

	if(highIndex==0||lowIndex==highIndex) {
		return 0;
		// Because index bigger or equal to lowIndex but at the same time not including highIndex, we can not 
		// include the highIndex number into sum (as arr.length as highIndex, 0 as low return the sum. 
		// so here there are two base cases both equal to 0.
	}

// part a
// this is base case -- fill if statement as well
	// assume index will not be out of bounds when user enter in the main.
	return input[lowIndex]+arraySum(input,lowIndex+1,highIndex);

	
	

	
}

static double median(int[] input, int i , int j)
{
if( j <= i ) return 0;
else {
	return ( median(input, i, j-1) + input[j-1] )/ 2;
}
}
public static void main(String[]args) {
	int []arr = {1,2,4,5,6,6};
	//System.out.println(arr.length);
	System.out.println(arraySum(arr,1,arr.length));
	System.out.println(median(arr,0,arr.length));
}

}