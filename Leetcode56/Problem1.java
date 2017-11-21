package Leetcode56;

public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] bits = {1, 0, 0};
//		int[] bits = {1, 1, 1, 0};
//		int[] bits = {0, 0};
		System.out.println(isOneBitCharacter(bits)); 
		
	}
    public static boolean isOneBitCharacter(int[] bits) {
        if(bits.length==0)
        	return false;
        if(bits.length==1)
        {
        	if(bits[0]==0)
        		return true;
        	else 
        		return false;
        }
        
        int length = bits.length;
        if(bits[length-1]!=0)
        	return false;
        
        int index =0;
        for (int i = 0; i < bits.length;) {
        	if(bits[i]==1)
        	{
        		if(i+2>=length)
        			return false;
        		else
        			i+=2;
        			
        	}
        	else if(i==length-1)
        	{
        		return true;
        	}
        	else
        		i++;
		}
        return false;
    }
}
