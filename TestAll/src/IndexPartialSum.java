	
class Node {
	
	int element;
	Node next;
	Node previous;
	
	public Node(int element,Node next,Node previous) {
		this.element=element;
		this.next=next;
		this.previous=previous;
	}
	
}





public class IndexPartialSum {
// executing indexPartialSum(Node header, target) must return the desired output
// Assume header is non-null element

	




public static int indexPartialSum(Node current, int target) {
	
	if(current.element>=target) {
		return 1;
}
	else {
	
		return 1+indexPartialSum(current.next,target-current.element);
	
	}


}

public static void main(String[]args) {

   
  
    Node head = new Node(3,second, null);
    Node second = new Node(4,third,head);
    Node third = new Node(3,fourth,second);
	Node fourth = new Node(5,null,third);
}
}