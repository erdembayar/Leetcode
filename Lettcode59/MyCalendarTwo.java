package Lettcode59;

import java.util.ArrayList;
import java.util.List;

import Lettcode59.MyCalendar.Pair;

public class MyCalendarTwo {

	class Pair{
		int startDate;
		int endDate;
		public Pair(int start, int end) {
			super();
			this.startDate = start;
			this.endDate = end;
		}
		
	}
	List<Pair> pairs;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 * MyCalendar obj = new MyCalendar();
//		 * boolean param_1 = obj.book(start,end);
		MyCalendarTwo mc = new MyCalendarTwo();
//	System.out.println(mc.book(10, 20)); // returns true
//	System.out.println(mc.book(15, 25)); // returns false
//	System.out.println(mc.book(20, 30)); // returns true
		
		System.out.println(mc.book(10,20)); 
		System.out.println(mc.book(50, 60)); 
		System.out.println(mc.book(10,40)); 
		System.out.println(mc.book(5,15)); 
		System.out.println(mc.book(5,10)); 
		System.out.println(mc.book(25,55)); 

	}
	
    public MyCalendarTwo() {
    	pairs = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
    	boolean flag = false;
    	List<Pair> flaggedPairs= new ArrayList<>();
    	for(Pair p: pairs){
    		if(flag){
            	if(start<p.endDate && start >=p.startDate){
            		for(Pair fp: flaggedPairs)
            		{
            			if(start>=p.endDate)
            				return false;
            		}
            			
            		//flaggedPairs.add(p);
            	}
            		
            	if(end>p.startDate && end <p.endDate)
            	{
            		for(Pair fp: flaggedPairs)
            		{
            			if(end<p.endDate)
            				return false;
            		}
            			
            		//flaggedPairs.add(p);
            	}
            	if(start<p.startDate && end>=p.endDate)
            	{
            		return false;
            			
            		//flaggedPairs.add(p);
            	}			
    		}
    		else{
            	if(start<p.endDate && start >=p.startDate){
            		flag = true;
            		flaggedPairs.add(p);
            	}
            		
            	if(end>p.startDate && end <p.endDate){
            		flag = true;
            		flaggedPairs.add(p);
            	}
            	if(start<p.startDate && end>=p.endDate){
            		flag = true;
            		flaggedPairs.add(p);
            	}
    		}

    	}
    	
    	pairs.add(new Pair(start,end));

        return true;  
    }
}
