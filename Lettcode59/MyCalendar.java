package Lettcode59;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {
	class Pair{
		int startDate;
		int endDate;
		public Pair(int start, int end) {
			super();
			this.startDate = start;
			this.endDate = end;
		}
		
	}
	List<Pair> pairs = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 * MyCalendar obj = new MyCalendar();
//		 * boolean param_1 = obj.book(start,end);
		MyCalendar mc = new MyCalendar();
//	System.out.println(mc.book(10, 20)); // returns true
//	System.out.println(mc.book(15, 25)); // returns false
//	System.out.println(mc.book(20, 30)); // returns true
		
		System.out.println(mc.book(47, 50)); 
		System.out.println(mc.book(33, 41)); 
		System.out.println(mc.book(39, 45)); 
		System.out.println(mc.book(33, 42)); 
		System.out.println(mc.book(25, 32)); 
		System.out.println(mc.book(26, 35)); 
		System.out.println(mc.book(19, 25)); 
		System.out.println(mc.book(3, 8)); 
		System.out.println(mc.book(8, 13)); 
		System.out.println(mc.book(18, 27)); 
	}
	
    public MyCalendar() {

    }
    
    public boolean book(int start, int end) {
    	
    	for(Pair p: pairs){
        	if(start<p.endDate && start >=p.startDate)
        		return false;
        	if(end>p.startDate && end <p.endDate)
        		return false;
        	if(start<p.startDate && end>=p.endDate)
        		return false;
    	}
    	
    	pairs.add(new Pair(start,end));

        return true;  
    }
}
