package Contest41.MaximumAverageSubarrayII.Java;

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = avgCalc(nums,0,k);
        for(int i=k;i<(nums.length);i++){
            for(int j=0;j<(nums.length-i+1);j++){
                double avg=avgCalc(nums,j, i);
                if(maxAvg<avg)
                    maxAvg = avg;
            }
        }
        return maxAvg;
    }

    protected double avgCalc(int[] nums,int i, int j){
        int sum=0;
        for(int temp=0;temp<j;temp=temp+1){
            sum+= nums[temp+i];
        }
        double result= sum/(double) j;
        return result;
    }

    public static void main(String[] args) {
        Solution solution= new Solution();
//        double maxAvg = solution.findMaxAverage(new int[]{3,3,4,3,0},3);
        double maxAvg = solution.findMaxAverage(new int[]{0,1,1,3,3},4);
        System.out.println(maxAvg);
    }
}
