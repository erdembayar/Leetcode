package Trees;

import java.util.Stack;

import Trees.PreOrderTraversalDFS.TreeNode;
//https://www.java2blog.com/binary-tree-postorder-traversal-in-java/

public class PostOrdertravesalDFS {
	static class TreeNode {
		int data;
		TreeNode left, right;

		TreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	// Resursive solution
	void inOrderResursive(TreeNode root) {
		if (root != null) {
			inOrderResursive(root.left);
			inOrderResursive(root.right);
			System.out.printf("%d ", root.data);
		}
	}

	// Non recursive, Using stack
	void inOrderIter(TreeNode root) {

		if (root == null)
			return;

		Stack<TreeNode> s = new Stack<>();
		TreeNode currentNode = root;

		while (true) {
			if (currentNode != null) {
				if(currentNode.right!=null)
					s.push(currentNode.right);
				s.push(currentNode);
				currentNode = currentNode.left;
				continue;
			} 
			
			
			if(s.isEmpty())
				return;
			
			currentNode = s.pop();
			
			if(currentNode.right!=null && ! s.isEmpty() && currentNode.right == s.peek()){
				s.pop();
				s.push(currentNode);
				currentNode = currentNode.right;
			}
			else{
				System.out.printf(currentNode.data+" ");
				currentNode =null;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PostOrdertravesalDFS ioDFS = new PostOrdertravesalDFS();
		TreeNode rootNode = createBinaryTree();

		System.out.println("Post-Order walk using Recursing");
		ioDFS.inOrderResursive(rootNode);
		System.out.println();
		System.out.println("--------------------");

		System.out.println("Using Iterative solution");
		ioDFS.inOrderIter(rootNode);
	}

	static TreeNode createBinaryTree() {
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
