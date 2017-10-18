package Leetcode54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class DegreeOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = {1, 2, 2, 3, 1};
		int[] nums = {1,2,2,3,1,4,2};
		int result = findShortestSubArray(nums);
		System.out.println(result);
	}
    public static int findShortestSubArray(int[] nums) {

        int maxOccurance = 0;
        ArrayList<Integer> maxList = new ArrayList<>();
        
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int i : nums) {
        	int temp = 1;
			if(numbers.containsKey(i)){
				temp = numbers.get(i)+1;

			}
			else{
				numbers.put(i, temp);
			}
			
			numbers.put(i, temp);
			if(temp==maxOccurance){
				if(maxList.indexOf(i)==-1)
					maxList.add(i);
			}
			else if(temp> maxOccurance){
				maxOccurance = temp;
				maxList = new ArrayList<>();
				maxList.add(i);
			}			
		}
        
        
        int start =-1, end=-1;
        boolean flag = false;
		for (int j : maxList) {
			int tempStart=-1, tempEnd=-1, len=0;
			for (int i = 0; i < nums.length; i++) {
				if(tempStart>-1 && nums[i]==j && tempEnd<i){
					tempEnd= i;
				}
				
				if(tempStart==-1 && nums[i]==j){
					tempStart = i;
				}

			}
			len = tempEnd-tempStart;
			if(!flag && len>0){
				start= tempStart;
				end = tempEnd;
				flag = true;
			}			
			else if(flag && len<(end-start)){
					start= tempStart;
					end = tempEnd;
				}
		}
		        
        return end-start+1;
    }
}
