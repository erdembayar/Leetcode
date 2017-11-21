package Leetcode58;

import java.util.Iterator;

public class Problem725 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		root = [1, 2, 3], k = 5
		
//		int k=5;
//		ListNode root = new ListNode(1);
//		root.next = new ListNode(2);
//		root.next.next = new ListNode(3);
		int k=3;
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);
		root.next.next.next.next.next = new ListNode(6);
		root.next.next.next.next.next.next = new ListNode(7);
		root.next.next.next.next.next.next.next = new ListNode(8);
		root.next.next.next.next.next.next.next.next = new ListNode(9);
		root.next.next.next.next.next.next.next.next.next = new ListNode(10);
		
		ListNode[] results = splitListToParts(root, k);
		
		for (int i = 0; i < results.length; i++) {
			System.out.println(results[i]);
		}
		
	}
    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode temp = root, currentNode =root;
        int length=0;
    	while(temp!=null){
    		length++;
    		temp = temp.next;
    	}
    	
    	int fit = length/k;
    	int remainder = length%k;
    	
    	ListNode[] result = new ListNode[k];
    	
    	int currenListNode=0;
    	
    	temp = root;

    	int innerCount =0;
    	
		while(remainder>0){
			currentNode= temp;
			result[currenListNode] = currentNode;
			temp = temp.next;
			for(int i=1;i<fit+1;i++){
				currentNode.next = temp;
				currentNode = currentNode.next;
				temp = temp.next;
			}
			currentNode.next = null;
			remainder--;
			currenListNode++;
		}
		
		while(currenListNode<k && currenListNode<length){
			currentNode= temp;
			result[currenListNode] = currentNode;
			temp = temp.next;
			for(int i=1;i<fit;i++){
				currentNode.next = temp;
				currentNode = currentNode.next;
				temp = temp.next;
			}
			currentNode.next = null;
			currenListNode++;
		}
		
    	if(k>length){
			for(int j=0;j<k-length;j++){
				currentNode= null;
				result[currenListNode] = currentNode;				
			}

			
    	}

    	return result;
    }
}
