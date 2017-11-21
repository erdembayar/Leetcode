package Trees;

import java.nio.channels.NetworkChannel;
import java.util.Stack;

import Trees.InOrderTraversalDFS.TreeNode;

public class PreOrderTraversalDFS {
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
			System.out.printf("%d ", root.data);
			inOrderResursive(root.left);
			inOrderResursive(root.right);
		}
	}

	// Non recursive, Using stack
	void inOrderIter(TreeNode root) {

		if (root == null)
			return;

		Stack<TreeNode> s = new Stack<>();
		s.push(root);

		while (!s.empty()) {
			TreeNode n = s.pop();
			System.out.printf("%d ", n.data);

			if (n.right != null) { // We put right side into stack first so we
									// print later than left side.
				s.push(n.right);
			}
			if (n.left != null) { // We put left side last but when we print it
									// will print before right side.
				s.push(n.left);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreOrderTraversalDFS ioDFS = new PreOrderTraversalDFS();
		TreeNode rootNode = createBinaryTree();

		System.out.println("Pre-Order walk using Recursing");
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
