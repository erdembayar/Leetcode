package Leetcode54;

public class CountBinarySubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "00110011";
//		String s = "10101";
		int result = countBinarySubstrings(s);
		System.out.println(result);
	}
	
	public static int countBinarySubstrings(String s) {
	    int prevRunLength = 0, curRunLength = 1, res = 0;
	    for (int i=1;i<s.length();i++) {
	        if (s.charAt(i) == s.charAt(i-1)) curRunLength++;
	        else {
	            prevRunLength = curRunLength;
	            curRunLength = 1;
	        }
	        if (prevRunLength >= curRunLength) 
	        	res++;
	    }
	    return res;
	}
  }