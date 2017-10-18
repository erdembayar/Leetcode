package Leetcode54;

import java.util.HashMap;

public class PartitionKequalSubsetSums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4, 3, 2, 3, 5, 2, 1};
		int k=4;
		boolean result = canPartitionKSubsets(nums,k);
		System.out.println(result);
	}

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        if(k==0){
        	return false;
        }
    	int sum = 0;
    	for(int i:nums){
        	sum +=i;
        }
    	
    	if(sum%k!=0){
    		return false;
    	}
    	
    	int target = sum/k;
    	int len = nums.length;
    	
    	int[] sums= new int[k];
    	 return helper(nums,len-1,sums,target,0,0);    
     }
    
    public static boolean helper(int[]nums,int pos,int[] sums,int target,int visited,int curidx){
        if(sums[curidx]==target){
            if(curidx==sums.length-2 || curidx==sums.length-1) return true;
            return helper(nums,nums.length-1,sums,target,visited,curidx+1);
        }
              for(int i=pos;i>=0;i--){
               int mask= 1<<i;
               if((visited & mask)!=0) continue;
                   if(sums[curidx]+nums[i]<=target){
                       sums[curidx]+=nums[i];
                       visited= visited | mask;
                      
                       if(helper(nums,i-1,sums,target,visited,curidx)) return true;
                       visited= (visited & (~mask)) ;
                       sums[curidx]-=nums[i];
                   }
           }
            return false;
        }    
}

