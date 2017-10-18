package Problems;

import java.util.HashMap;

//https://leetcode.com/problems/two-sum/description/
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int[] twoSum(int[] nums, int target) {
        int first = 0, second = 1;
        int length = nums.length;
        HashMap<Integer, Integer> sum = new HashMap<>();
        
        for(int i=0;i<length;i++)
        {
            if(sum.containsKey(target-nums[i])){
            	first = sum.get(target-nums[i]);
            	second = i;
            	break;
            }
            else{
            	sum.put(nums[i], i);
            }
        }
        
        return new int[]{first, second};
    }
}
