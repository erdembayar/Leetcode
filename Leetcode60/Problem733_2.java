package Leetcode60;

public class Problem733_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
//		int[][] image = {{1,0,0},{1,0,0}};
		int[][] image = {{0,0,0},{0,1,1}};
		int sr =0;
		int sc =0;
		int newColor =2;
		int[][] result = floodFill(image, sr,sc,newColor);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(" "+result[i][j]+" ");
				
			}
			System.out.println();
		}
	}
//	public static int currentColor = -1;
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

    	if(image.length==0 || sr>=image.length || sr<0)
    		return null;
    	if(image[0].length ==0 || sc>=image[0].length || sc<0)
    		return null;
    	
    	int currentColor = image[sr][sc];
    	dfs(image,sr,sc,newColor,currentColor);
    			
    	return image;
    }
    
    static void dfs(int[][] grid, int i, int j,int newColor, int currentColor) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ) {
            return;
        }
        if(grid[i][j] ==currentColor){
        	grid[i][j] = newColor;
            dfs(grid, i + 1, j, newColor, currentColor);
            dfs(grid, i, j + 1,newColor, currentColor);
            dfs(grid, i - 1, j, newColor, currentColor);
            dfs(grid, i, j - 1, newColor, currentColor);
        }
        
    }    
    
}
