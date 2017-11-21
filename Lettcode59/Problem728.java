package Lettcode59;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Problem728 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> result = selfDividingNumbers(1,22);
		
		for (Iterator iterator = result.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
		}
	}
    public static List<Integer> selfDividingNumbers(int left, int right) {
        String temp;
        boolean flag;
        List<Integer> result = new ArrayList<Integer>();
    	for (int i = left; i <= right; i++) {
    		temp = Integer.toString(i);
    		int length = temp.length();
    		flag = true;
			for(int j = 0;j<length ;j++){
				int num = Integer.parseInt(temp.charAt(j)+"");
				
				if(num==0 || i%num!=0)
				{
					flag = false;
					break;
				}
			}
			if(flag){
				result.add(i);
			}
			
		}
    	
    	return result;
    }
}
