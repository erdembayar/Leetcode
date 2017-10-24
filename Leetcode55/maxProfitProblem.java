package Leetcode55;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class maxProfitProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 int[] prices = {1, 3, 2, 8, 4, 9};
//		 int fee = 2; //8
//		 int[] prices = {1,3,7,5,10,3};
//		 int fee = 3;	//6

		 int[] prices = {4,5,2,4,3,3,1,2,5,4};
		 int fee = 1;	
		 

		 System.out.println(maxProfit(prices,fee));
	}
	public static int maxProfit(int[] prices, int fee) {
	    int profit = 0;
	    int lastSell = -1;
	    
	    HashMap<Integer,Integer> profitLog = new HashMap<>();
	    profitLog.put(0, 0);
	    
	    for(int i=1; i<prices.length; i++){
	    	int max = Integer.MIN_VALUE;
	    	
	    	for (int j = lastSell+1; j < i; j++) {
	    		int diff = prices[i]-prices[j] - fee;
	    		if(diff>0 && diff>max){

	    			max = diff;
	    		}
			}

	    	    Iterator it = profitLog.entrySet().iterator();
	    	    int tempMax = Integer.MIN_VALUE;
	    	    int tempMaxLocation = -1;
	    	    while (it.hasNext()) {
	    	        Map.Entry pair = (Map.Entry)it.next();
		    		
			    	for (int j = (int)pair.getValue(); j<i; j++) {
			    		int diff = prices[i]-prices[j] - fee;
			    		if(diff>0 && diff>tempMax){
			    			tempMax = diff;
			    			tempMaxLocation = j;
			    		}
			    	}
			    	
	    	        //it.remove(); // avoids a ConcurrentModificationException
	    	    }
			    	
			    	if(max<tempMax && tempMax>0){
			    		profit = profitLog.get(tempMaxLocation);
			    		profit += tempMax;
			    		lastSell =i;
			    		
			    	    Iterator iter = profitLog.entrySet().iterator();

			    	    while (it.hasNext()) {
			    	    	Map.Entry pair = (Map.Entry)it.next();
			    	    	if((int)pair.getKey()>tempMaxLocation)
			    	    		profitLog.remove((int)pair.getKey());
			    	       
			    	    }			    		
			    		
			    		profitLog.put(i, profit);
			    		
			    	}
			    	else if(max>0){
			    		profit += max;
			    		lastSell =i;	
			    		profitLog.put(i, profit);
			    	}			    	

	    	
	    }
	    return profit;
	}
}
