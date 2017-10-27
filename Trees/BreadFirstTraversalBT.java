package Trees;
//http://www.geeksforgeeks.org/level-order-tree-traversal/http://www.geeksforgeeks.org/level-order-tree-traversal/
//Recursive Java program for level order traversal of Binary Tree

// It's just Binary Tree, BST Binary search Tree. 

/* Class containing left and right child of current 
NodeBT and key value*/
class NodeBT
{
 int data;
 NodeBT left, right;
 public NodeBT(int item)
 {
     data = item;
     left = right = null;
 }
}

public class BreadFirstTraversalBT {

	   // Root of the Binary Tree
    NodeBT root;
 
    public BreadFirstTraversalBT()
    {
        root = null;
    }
 
    /* function to print level order traversal of tree*/
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i=0; i<=h; i++)
            printGivenLevel(root, i);
    }
 
    /* Compute the "height" of a tree -- the number of
    NodeBTs along the longest path from the root NodeBT
    down to the farthest leaf NodeBT.*/
    int height(NodeBT root)
    {
        if (root == null)
           return -1;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
             
            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1); 
        }
    }
 
    /* Print NodeBTs at the given level */
    void printGivenLevel (NodeBT root ,int level)
    {
        if (root == null)
            return;
        if (level == 0)
            System.out.print(root.data + " ");
        else if (level > 0)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }
     
    /* Driver program to test above functions */
    public static void main(String args[])
    {
    	BreadFirstTraversalBT tree = new BreadFirstTraversalBT();
       tree.root= new NodeBT(1);
       tree.root.left= new NodeBT(2);
       tree.root.right= new NodeBT(3);
       tree.root.left.left= new NodeBT(4);
       tree.root.left.right= new NodeBT(5);
        
       System.out.println("Level order traversal of binary tree is ");
       tree.printLevelOrder();
    }
}
