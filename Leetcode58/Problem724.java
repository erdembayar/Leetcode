package Leetcode58;

public class Problem724 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println();
//		int[] nums = {1,2,3};
//		int[] nums = {-1,-1,-1,0,1,1};
		int[] nums = {1, 7, 3, 6, 5, 6};
		System.out.println(pivotIndex(nums));
	}
	
    public static int pivotIndex(int[] nums) {
    	
    	if(nums.length<=1)
    		return -1;
    	
        int sum =0, front_sum=0;
        int ind = -1;
        for (int i = 0; i < nums.length; i++) {
			sum +=nums [i];
		}
        
        for (int i = 0; i < nums.length; i++) {
			
			if(front_sum==(sum-front_sum-nums[i]))
				return i;
			front_sum += nums[i];
		}
        
        return ind;
    }
}
