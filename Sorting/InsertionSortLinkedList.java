package Sorting;


public class InsertionSortLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        ListNode temp;
//        ListNode ln = new ListNode(5);
//        ListNode headerPoint = ln;
//
//        temp = new ListNode(7);
//        ln.next = temp;
//        ln = temp;
//        
//        temp = new ListNode(1);
//        ln.next = temp;
//        ln = temp;        
//        
//        temp = new ListNode(10);
//        ln.next = temp;
//        ln = temp;    
//        
//        temp = new ListNode(16);
//        ln.next = temp;
//        ln = temp;   
//        
//        temp = new ListNode(20);
//        ln.next = temp;
//        ln = temp;
//        
//        temp = new ListNode(3);
//        ln.next = temp;
//        ln = temp;   
        int a[]=new int[] {4,19,14,5,-3,1,8,5,11,15};
        ListNode ln = new ListNode(a[0]);
        ListNode headerPoint = ln;
        
        for (int i = 1; i < a.length; i++) {
			temp = new ListNode(a[i]);
			ln.next = temp;
			ln = temp;
		}
        
        ln = headerPoint;
        ListNode sorted = new InsertionSortLinkedList().insertionSortList(ln);
        
        while(sorted!=null){
        	System.out.print(sorted.val+" ");
        	sorted = sorted.next;
        }
        
	}

    public ListNode insertionSortList(ListNode head) {
    	if(head == null || head.next == null)
    		return head;
    	ListNode headpoint = head;
    	ListNode currentHead = new ListNode(head.val);
        ListNode next = head.next;
        ListNode endPointer = currentHead; 
        ListNode temp;
        
    	while(next!=null){
    		ListNode indexPointer = currentHead;
    		ListNode nextPointer = next.next;
    		ListNode prevPointer = currentHead;
//    		System.out.println(next.val);
    		if(next.val<=currentHead.val){
    			 temp = currentHead;
    			currentHead = next;
    			currentHead.next =temp;
    		}
    		else{
    			if(next.val>=endPointer.val){
    				endPointer.next = next;
    				endPointer = next;
    				next.next = null; //Othewise other next -->next-->next etc will be here. Which is not good.
    			}
    			else{
    				while(indexPointer.next!=null && indexPointer.val<next.val){
    					prevPointer = indexPointer;
    					indexPointer = indexPointer.next;
    				}
    				
    				temp = new ListNode(next.val);
    				prevPointer.next =temp;
    				temp.next = indexPointer;

    				
    			}
    			
    		}
    		
    		next = nextPointer;
    	}
        
        return currentHead;
    }
}
