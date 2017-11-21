package Trees;

import java.util.Stack;

public class PrintLeafNodes {
	
	//Recursive
	public static void printLeafNodes(Node t)
	{
		//Pre-Order walk
	      if(t == null)       
	        return;
	       if(t.left == null && t.right==null)      
	          {
	    	   System.out.println(t.data); 
	    	   return; //It's better to return after printing and save two calls, since it is known that t.left and t.right are null
	          }
	       
	       printLeafNodes(t.left); 
	       printLeafNodes(t.right);      
	}
	
	
	//Stack
//	 http://javarevisited.blogspot.com/2016/09/how-to-print-all-leaf-nodes-of-binary-tree-in-java.html#ixzz4wk0osaOQ
	public static void printLeafNodesIteratively(Node root) {

	    if (root == null) {
	      return;
	    }
	    Stack<Node> stack = new Stack<>();
	    stack.push(root);

	    while (!stack.isEmpty()) {
	      Node node = stack.pop();

	      if (node.right != null) {
	        stack.add(node.right);
	      }

	      if (node.left != null) {
	        stack.add(node.left);
	      }

	      if (node.left == null && node.right == null) {
	        System.out.printf("%d ", node.data);
	      }

	    }

	  }


}
