package AddTwoNumbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
     
     @Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}
     
 }
public class Solution {
	
	public static void main(String[] args) {
//		Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//		Output: 7 -> 0 -> 8
		ListNode n1 = new ListNode(2);
		n1.next =  new ListNode(4);
		n1.next.next =  new ListNode(3);

		//System.out.println(n1);
		ListNode n2 = new ListNode(5);
		n2.next =  new ListNode(6);
		n2.next.next =  new ListNode(4);

		System.out.println(addTwoNumbers(n1,n2));
		
		ListNode n3 =  new ListNode(9);
		
		ListNode n4 =  new ListNode(1);
		n4.next =  new ListNode(9);
		n4.next.next =  new ListNode(9);
		//n4.next.next.next =  new ListNode(9);
		
		System.out.println(addTwoNumbers(n3,n4));
		//;
	}
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	long sum = toNumber(l1)+toNumber(l2);
    	System.out.println(sum);
    	//char[] digits = String.valueOf(sum).toCharArray();
    	char[] digits = String.valueOf(sum).toCharArray();
    	
//    	int digit1 = Character.digit(digits.charAt(0), 10);
//    	
//    	ListNode ret = new ListNode((int)sum%10);
//    	ListNode current = ret;
//    	sum=sum/10;
//    	
//    	while(sum>0){
//    		current.next = new ListNode((int)sum%10);
//    		current =  current.next;
//    		sum=sum/10;
//    	}
//    	
    	ListNode ret;
    	if(sum>0)
    		 ret = new ListNode(digits[digits.length-1]-'0');
    	else
    	{
    		ret = new ListNode(0);
    		return ret;
    	}
    	ListNode current = ret;
    	
    	for(int i=1;i < digits.length;i++){
    		current.next =  new ListNode(digits[digits.length-i-1]-'0');
    		current = current.next;
    	}
    	
    	return ret;
    	
   }    
    
    public static long toNumber(ListNode l){
    	ListNode current = l;
    	long num=0;
    	int i=0;
    	while(current!=null){
 
    		num = (int) (current.val*Math.pow(10,i)+num);
    		current = current.next;
    		i++;
    	}
    	return num;
    }
    
 
    
}