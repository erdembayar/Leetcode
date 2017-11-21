package Leetcode41;

public class Problem {
 public static void main(String []args){
	 
	 int[] input = {1,12,-5,-6,50,3};
	 int k=4;
	 System.out.println(findMaxAverage(input,k));
 }
 
 public static double findMaxAverage(int[] nums, int k) {
     double globalAvg = 0, localAvg=0, localSum=0;
     int length = nums.length;
     if(length<k || k<=0)
    	 return 0;
     
     for(int i=0; i<k;i++ )
     {
    	 localSum += nums[i];
    	
     }
     
     localAvg = localSum/k;
     globalAvg = localAvg;
     
     for(int i=k;i<length;i++)
     {
    	 localSum -=nums[i-k];
    	 localSum +=nums[i];
    	 localAvg = localSum/k;
    	 
    	 if(localAvg>globalAvg)
    		 globalAvg= localAvg;
     }
     
     return globalAvg;
 }
 
}
