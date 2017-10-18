package KthLargestSmallest;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/
public class KthLargestPriotityQueu {

	public static int findKthLargest(int[] nums, int k) {

	    final PriorityQueue<Integer> pq = new PriorityQueue<>();
	    for(int val : nums) {
	        pq.offer(val);

	        if(pq.size() > k) {
	            pq.poll();
	        }
	    }
	    return pq.peek();
	}
	
	public static void main(String[] args){
		int k=2;
		int[] arr = { 10, 10, 7, 8, 9, 1, 5, 1 };
		int result = findKthLargest(arr,k);
		
		System.out.println(result);
	}
}
