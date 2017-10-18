package RussianDoll;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
	
	public static void main(String[] args) {
		int[][] envelopes =  {{5,4},{6,4},{6,7},{2,3}};
		int[][] envelopes2 = new int[][] {{5,4},{6,4},{6,7},{2,3}};
		System.out.println(maxEnvelopes(envelopes));
	}
	
	//([2,3] => [5,4] => [6,7]). 
    public static int maxEnvelopes(int[][] envelopes) {
    	ArrayList<Integer> space = new ArrayList<>();
        int count =1;
    	for(int[] i: envelopes){
    		space.add(i[0]*i[1]);
    		//pair.put(i[0]*i[1], i);
        }
    	Collections.sort(space);
    	if(envelopes.length==0)
    		return 0;
    	int[] buffer =  envelopes[0];
    	for (Integer key : space) { 
    		for(int[] i: envelopes)
    		{
    			
    			if(i[0]*i[1]==key)
    			{
		    		if( i[0]> buffer[0] && i[1]> buffer[1])
		    			{ 
		    				count++;
		    				buffer =  i;
		    			}
    			}
    		}
    		}
    	return count;
    
    }   
    
//    public static int[][] reOrder(int[][] envelopes){
//    	
//    	
//    }
}
