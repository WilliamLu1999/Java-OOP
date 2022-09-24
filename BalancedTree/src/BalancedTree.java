import java.util.ArrayList;

class Node{
	// Question 1 Constructor for Node
		private Node left;
		private Node right;
		private int value;
		Node(int v){
			setValue(v);
			setLeft(setRight(null));
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public Node setRight(Node right) {
			this.right = right;
			return right;
		}
	
		
	}
public class BalancedTree {
	// Question 2
	private Node root;
	public BalancedTree(){
		root =null;
	}
	// recitation
	 void insert(int k){
			root = doInsert(root, k);
	 }
	 Node doInsert(Node n, int k){
			// what is the binary search tree property? ALL elements to right are larger and left are smaller
			//          5
			//       1     10
			//            2  12

			// quite complex - on average randomized input - height = O(log n)
			if(n == null){
			    Node newnode = new Node(k);
			    return newnode;
			}
			else{
			    if(n.getValue() < k){
				// insert in right
				n.setRight(doInsert(n.getRight(), k));
			    }
			    else if(n.getValue() > k) {
				n.setLeft(doInsert(n.getLeft(), k));
			    }
	
			    return n;
			}
		    }
	
	
	// Question 3 
	public BalancedTree(int[] input) {
		root  = null;
		
		for(int i= 0; i< input.length;i++) {
			insert(input[i]);
		}
	}
	// Question 4
	
	public int[] inorderTraverse() {
		// store the results
		// Because we don't know the length of the test code, we use arraylist and then convert it to array
		ArrayList<Integer> results  = new ArrayList<>();
		inorderHelper(this.root,results);
		
		// convert List<Integer> to int []
		
		// source: https://stackoverflow.com/questions/960431/how-to-convert-listinteger-to-int-in-java
		return results.stream().mapToInt(i -> i).toArray();
		
	}
	// helper method
	public void inorderHelper(Node node, ArrayList<Integer> results) {
		if(node != null) {
			inorderHelper(node.getLeft(),results);
			results.add(node.getValue());
			inorderHelper(node.getRight(),results);
		}
			
	}

}
