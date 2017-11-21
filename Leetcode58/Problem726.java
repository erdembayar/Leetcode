package Leetcode58;

import java.util.HashMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class Problem726 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String formula = "K4(ON(SO3)2)2";
		String result = countOfAtoms(formula);
	}
    public static String countOfAtoms(String formula) {
    	
    	String result ="";
	    Stack<Character> stack = new Stack<Character>();
	    HashMap<String, Integer> chars = new HashMap<>();
	    char c;
	    String currentStr="";
	    int currentCount=0;
	    int stackCount = 0;
	    boolean flag = false;
	    for(int i=0; i < formula.length(); i++) {
	        c = formula.charAt(i);
	        
	        if(c == '('){
            stack.push(c);
            stackCount++;
            
            continue;
	        }
	        
	        if(c == ')'){
	            stack.pop();
	            stackCount--;
	            flag=true;
	            
		        }
	        
	        if(Character.isLetter(c)){
		        if(Character.isUpperCase(c)){
		        	currentStr = c+"";
		        	currentCount =0;
		        }
		        else
		        {
		        	currentStr = currentStr+c+"";
		        }
		        continue;
	        }
	        else if(Character.isDigit(c)) {

		        if(chars.containsKey(currentStr)){
		        	int count = chars.get(currentStr);
		        	chars.put(currentStr, count*10+Character.getNumericValue(c)); 
		        }
		        else
		        {
		        	chars.put(currentStr, Character.getNumericValue(c));
		        }	        	
	        }
	        

//	        if(c == '(')
//	            stack.push(c);
	    }
	    
	    while(!stack.empty()){
	    	
	    }
	    
	    SortedSet<String> keys = new TreeSet<String>(chars.keySet());
	    for (String key : keys) { 
	       int count = chars.get(key);
	       result +=key;
	       result += Integer.toString(count);
	    }
	    
	    return result;
    }
}
