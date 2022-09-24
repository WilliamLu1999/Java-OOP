

  
public class Heap {

public class Node<E> {
    public String element;
    public Node<E> left;
    public Node<E> right;
    public Node<E> parent;
    
    public Node(String e, Node<E> l, Node<E> r, Node<E>p) {
      element = e;
      left = l;
      right = r;
      parent= p;
    }
    public void setPrev(Node<E>l){
    	left = l;
    }
    public void setNext(Node<E>t) {
    	right = t;
    }
    public Node<E> getPrev(){
    	return left;
    }
    public Node<E> getNext(){
    	return right;
    }
    public String getElement() {
    	return element;
    }

    public void print() {
      System.out.println("Element stored is " + element );
    }
    
		Node root;
		int size =1;
		
		Node availableSpot(){
			
		// This function returns the parent of the next available spot
			while(root !=null) {
				if (root.left==null && root.right==null) {
					if(root.parent.right == null)
				
						return root.parent;
					else
						// assume the height of the tree is larger than 2
						root = root.parent.parent.right;
				}
				else{
					root = root.left;
				}
			}
			return root;
				
		}
		// (a) insert the last node
		Node addlastNode(Node v) {
			Node v1 =availableSpot();
			if(v1.left==null)
				v1.left = v;
			else
				v1.right =v;
			size +=1;

			return v;
			
		}
		Node deleteLastNode() {
			Node v2 = availableSpot();
		
				if(v2.left!=null && v2.right ==null) {
					
					Node v3 = v2.left;
					// delete
					v2.left = null;
					return v3;
				}
				else if(v2.left!=null && v2.right!= null) {
					Node v4 = v2.right;
					//delete
					v2.right= null;
					return v4;
				}
				else {
					return v2;
				}
			
	
		}
}}
