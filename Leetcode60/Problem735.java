package Leetcode60;

public class Problem735 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] input = { 5, 10, -5 };  //[5, 10]
		// int[] input = {8, -8};   //[]
		 int[] input = {10, 2, -5};  //[10]

		int[] result = asteroidCollision(input);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public static int[] asteroidCollision(int[] asteroids) {
		if(asteroids==null || asteroids.length==0)
			return null;
		int[] buffer = new int[asteroids.length];
		int pointer = 0;
		for (int i = 0; i < asteroids.length - 1; i++) {
			int j = i;
			int temp = asteroids[j];
			
			while (j >= 0 && j < asteroids.length - 1) {
				
				if (temp >= 0 && asteroids[j + 1] < 0) {
					if (Math.abs(asteroids[j]) > Math.abs(asteroids[j + 1])){
							
							j++;
						}
						
					else if (Math.abs(asteroids[j]) < Math.abs(asteroids[j + 1]))
					{
						temp = asteroids[j+1];
						j--;
					}
					else if(Math.abs(asteroids[j]) == Math.abs(asteroids[j + 1])){
						temp = Integer.MIN_VALUE;
						i++;
						break;
					}
				}
				else break;
				
			}
			
			if(j!=i &&temp!=Integer.MIN_VALUE)
				buffer[pointer++]=temp;
			
		}

		int[] result = new int[pointer];
		for (int i = 0; i < pointer; i++) {
			result[i] = buffer[i];
			
		}
		return result;
	}
}
