package Leetcode56;

public class Problem2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char[] chars = {'a','a','b','b','c','c','c'};
//		char[] chars = {'a'};
		char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
//		char[] chars = {'a','a','b','b','c','c','c'};
		System.out.println(compress(chars)); 
		
	}
	
    public static int compress(char[] chars) {
    	

    	int index=-1;
    	char temp;
    	if(chars==null)
    		return 0;
    	if(chars.length==1)
    		return 1;
    	
    	temp=chars[0];
    	int count =1;
    	int length = chars.length;
    	char[] buffer = new char[length]; 
    	
        for (int i = 1; i < length; i++) {
			if(chars[i]==temp)
			{
				count++;

			}
			else
			{
				buffer[++index] = temp;
				
				if(count>1){
					
					String temp1 = Integer.toString(count);
					int[] newGuess = new int[temp1.length()];
					for (int j = 0; j < temp1.length(); j++)
					{
						buffer[++index] = temp1.charAt(j);
					}
				}
				temp = chars[i];
				count=1;
				
			}
		}
        
    	buffer[++index] = temp;
		if(count>1){
			if(count>1){
				
				String temp1 = Integer.toString(count);
				int[] newGuess = new int[temp1.length()];
				for (int j = 0; j < temp1.length(); j++)
				{
					buffer[++index] = temp1.charAt(j);
				}
			}
		}
		

		
		for (int i = 0; i < index+1; i++) {
			chars[i]= buffer[i];
		}

//		for (int i=0; i<length;i++) {
//		System.out.print(chars[i]+ " ");
//	}
			
        return index+1;
    }	
}
