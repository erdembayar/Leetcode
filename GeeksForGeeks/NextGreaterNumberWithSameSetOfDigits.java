package GeeksForGeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextGreaterNumberWithSameSetOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "218765";
		String s2 = "1234";
		String s3 = "4321";
		String s4 = "534976";
		
		System.out.println(findNext(s1));
		System.out.println(findNext(s2));
		System.out.println(findNext(s3));
		System.out.println(findNext(s4));
	}

		public static String findNext (String s){
			
			String result = "Not Possible";
					
//			for (int i = 0; i < s3.length(); i++) {
//				System.out.println(s3.charAt(i)-'0');
//			}
			ArrayList<Integer> prevDigits = new ArrayList<>();
			int length = s.length();
			for (int i = length-1; i >=0; i--) {
				char c = s.charAt(i);
				int digit = Character.getNumericValue(c);
				
				for(int j = length-1;j>i;j--){
					char c2 = s.charAt(j);
					int digit2 = Character.getNumericValue(c2);
					
					if(digit2>digit){
						prevDigits.remove(prevDigits.indexOf(digit2));
						prevDigits.add(digit);
						result = s.substring(0, i) + String.valueOf(digit2);
						while(prevDigits.size()>0){
							int min = Collections.min(prevDigits);
							prevDigits.remove(prevDigits.indexOf(min));
							result += String.valueOf(min);
						}
						
						return result;
					}
					
					
				}
				prevDigits.add(digit);
				
			}
			
			return result;
		}
		
		
}
