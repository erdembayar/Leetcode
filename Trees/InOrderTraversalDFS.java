package Trees;

import java.util.Stack;
//https://www.java2blog.com/binary-tree-inorder-traversal-in-java/
//2 kind of Solutions.

public class InOrderTraversalDFS {
	
	static class TreeNode{
		int data;
		TreeNode left, right;
		TreeNode(int data){
			this.data = data;
			left = right = null;
		}
	}
	
	//Resursive solution
	void inOrderResursive(TreeNode root){
		if(root!=null){
			inOrderResursive(root.left);
			System.out.printf("%d ", root.data);
			inOrderResursive(root.right);
		}
	}
	
	//Non recursive, Using stack
	void inOrderIter(TreeNode root){
		if(root==null)
			return;
		
		Stack<TreeNode> s = new Stack<>();
		TreeNode currentNode = root;
		
		while(!s.empty() || currentNode!=null){
			if(currentNode!=null){
				s.push(currentNode);
				currentNode = currentNode.left;
			}
			else{
				TreeNode n = s.pop();
				System.out.printf("%d ", n.data);
				currentNode = n.right; //Going to right side only after printing left and middle.
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InOrderTraversalDFS ioDFS = new InOrderTraversalDFS();
		TreeNode rootNode = createBinaryTree();
		
		System.out.println("In-Order walk using Recursing");
		ioDFS.inOrderResursive(rootNode);
		System.out.println();
		System.out.println("--------------------");
		
		System.out.println("Using Iterative solution");
		ioDFS.inOrderIter(rootNode);
	}

	static  TreeNode createBinaryTree(){
		TreeNode rootNode = new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(70);
		
		rootNode.left = node20;
		rootNode.right = node60;
		
		node20.left = node10;
		node20.right = node30;
		
		node60.left = node50;
		node60.right = node70;
		
		return rootNode;
	}
}
