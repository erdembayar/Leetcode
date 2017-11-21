package Trees;

import java.util.LinkedList;
// http://www.geeksforgeeks.org/level-order-tree-traversal/
// Queue is implemented using an array with maximum size of 500.
// We can implement queue as linked list also.
import java.util.Queue;

public class BreadFirstTraversalBTQueu {

	NodeBT root;

	/*
	 * Given a binary tree. Print its NodeBTs in level order using array for
	 * implementing queue
	 */
	void printLevelOrder() {
		Queue<NodeBT> queue = new LinkedList<NodeBT>();
		queue.add(root);
		while (!queue.isEmpty()) {

			/*
			 * poll() removes the present head. For more information on poll()
			 * visit http://www.tutorialspoint.com/java/util/linkedlist_poll.htm
			 */
			NodeBT tempNodeBT = queue.poll();
			System.out.print(tempNodeBT.data + " ");

			/* Enqueue left child */
			if (tempNodeBT.left != null) {
				queue.add(tempNodeBT.left);
			}

			/* Enqueue right child */
			if (tempNodeBT.right != null) {
				queue.add(tempNodeBT.right);
			}
		}
	}

	public static void main(String args[]) {
		/*
		 * creating a binary tree and entering the NodeBTs
		 */
		BreadFirstTraversalBTQueu tree_level = new BreadFirstTraversalBTQueu();
		tree_level.root = new NodeBT(1);
		tree_level.root.left = new NodeBT(2);
		tree_level.root.right = new NodeBT(3);
		tree_level.root.left.left = new NodeBT(4);
		tree_level.root.left.right = new NodeBT(5);

		System.out.println("Level order traversal of binary tree is - ");
		tree_level.printLevelOrder();
	}
}
