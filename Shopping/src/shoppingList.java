public class shoppingList {

  public static class Node<E> {
    public String element;
    public Node<E> prev;
    public Node<E> next;
    
    public Node(String e, Node<E> p, Node<E> n) {
      element = e;
      prev = p;
      next = n;
    }
    public void setPrev(Node<E>p){
    	prev = p;
    }
    public void setNext(Node<E>n) {
    	next = n;
    }
    public Node<E> getPrev(){
    	return prev;
    }
    public Node<E> getNext(){
    	return next;
    }
    public String getElement() {
    	return element;
    }

    public void print() {
      System.out.println("Element stored is " + element );
    }
    
  }

  public Node header;
  public Node tail;
  public int size = 0;

  // constructors follow per JAVA convention

  public shoppingList() {
	  this.header = new Node<>(null,null,null);
	  this.tail = new Node<>(null,header,null);
      header.setNext(tail);
      
  }

  public void add(String newItem) {
	  
	 //if the linked list is empty
	  if(header == null) {
		  header= new Node(newItem,null,null);
		  System.out.println("Not");
		  return;
	  }
	  // if there is something already in the linked list
	  else {
		  Node current = header;
		while(current.next!=null) {
			current = current.next;
		}
		  Node newNode = new Node(newItem,current,null);
		  current.next=newNode;
	  }
	  size++;
  }
  // assume each node's content is different
  // assume the user enters the correct contents that she or he wants.
  public void remove(String oldItem) {
	
	  Node current = header;
	  // looping through each item to check if the content is the same as the oldItem
	  while(current.element!= oldItem) {
		  current = current.next;
	  }
	  // if the content is the same as the oldItem
	  if (current.element==oldItem) {
		 
		  Node p = current.prev;
		  Node n = current.next;
		  p.next = n;
		  n.prev =p;
		  
		  // garbage collection
		  current.prev=null;
		  current.next = null;
		  current.element = null;
	  }
	  size--;
  }

  public void print() {
	  Node current = header;
	 
	  while (current != null) {
		  if (current.getElement()!=null)
			  current.print();
			  current = current.next;
	  }
  }

  public int numItem() {
	
	  return size;
  }
  public static void main(String[]args) {
	  shoppingList a  =new shoppingList();
	  a.add("apple");
      a.add("banana");
      a.remove("apple");
      a.add("watermellon");
     
      a.add("car");
 
      a.remove("banana");
      a.add("apple");
	  int b = a.numItem();
	  a.print();
	  System.out.println(b);
  }
}
