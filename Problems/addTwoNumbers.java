package Problems;

//https://leetcode.com/problems/add-two-numbers/description/

public class addTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a[] = new int[] {0};
//		int b[] = new int[] {7,3};
//		
		int a[] = new int[] {1};
		int b[] = new int[] { 9,9 };
		
		ListNode aList = new ListNode(a[0]);
		ListNode bList = new ListNode(b[0]);
		ListNode temp;
		
		ListNode aHead = aList;
		ListNode bHead = bList;
		
		for (int i = 1; i < a.length; i++) {
			temp = new ListNode(a[i]);
			aList.next = temp;
			aList = temp;
		}
		
		for (int i = 1; i < b.length; i++) {
			temp = new ListNode(b[i]);
			bList.next = temp;
			bList = temp;
		}
		
		ListNode result = new addTwoNumbers().addTwoNumbers(aHead, bHead);
		System.out.println(result);
	}

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean overflow = false;
        int sum;
        ListNode sumHead =null;
        ListNode temp;
        ListNode sumHeadBackup =null;
        while(l1!=null && l2!=null){
        	sum = overflow? l1.val+l2.val+1:l1.val+l2.val;
        	overflow=false;
        	if(sum>=10){
        		sum -=10;
        		overflow=true;
        	}
        	
        	temp = new ListNode(sum);
        	if(sumHead == null){
        		sumHead = temp;
        		sumHeadBackup = temp;
        	}
        	else{
        		sumHead.next = temp;
        		sumHead = temp;
        	}
        	l1 = l1.next;
        	l2 = l2.next;
        }
        
        if(l1==null && l2 ==null && overflow){
        	temp = new ListNode(1);
    		sumHead.next = temp;
    		sumHead = temp;
    		overflow = false;
        }
        
        while(l1!=null){
        	sum = overflow? l1.val+1:l1.val;
        	overflow = false;
        	if(sum>=10){
        		sum -=10;
        		overflow=true;
        	}
        	temp = new ListNode(sum);
    		sumHead.next = temp;
    		sumHead = temp;
    		l1 = l1.next;
        }

        while(l2!=null){
        	sum = overflow? l2.val+1:l2.val;
        	overflow = false;
        	if(sum>=10){
        		sum -=10;
        		overflow=true;
        	}
        	temp = new ListNode(sum);
    		sumHead.next = temp;
    		sumHead = temp;
    		l2 = l2.next;
        }        
        
        if(overflow){
        	temp = new ListNode(1);
    		sumHead.next = temp;
    		sumHead = temp;

        }
        
        return sumHeadBackup;
    }

}
