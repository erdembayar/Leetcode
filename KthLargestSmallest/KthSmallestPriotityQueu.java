package KthLargestSmallest;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestPriotityQueu {

	public static int findKthSmallest(int[] arr, int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<>(20,Collections.reverseOrder());
		for(int i: arr){
			pq.offer(i);
			
			if(pq.size()>k){
				pq.poll();
			}
		}
		return pq.peek();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k=3;
		int[] arr = { 10, 10, 7, 8, 9, 1, 5, 1 };
		int result = findKthSmallest(arr,k);
		
		System.out.println(result);
	}

}
