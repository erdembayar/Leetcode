package Misc;
//Get digit numbers from string format

public class CharacterTests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s2 = "1234";
		String s3 = "4321";
		String s4 = "534976";
		
		int[] t = new int[] {20,3,1,4,5};
		int j = t.length;
		
		for (int i = 0; i < s3.length(); i++) {
			System.out.println(s3.charAt(i)-'0');
		}
	}

}
