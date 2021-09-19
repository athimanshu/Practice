package leetcode.medium;

public class PathWithMaximumGold {
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    int result = 0;
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] !=0){
                   result = Math.max(result,helper(grid,i,j));
                }
            }
        }
        return result;
    }
    private int helper(int[][] grid, int x, int y){
        if(x<0 || x > grid.length-1 || y<0 || y> grid[0].length-1 || grid[x][y] == 0){
            return 0;
        }
        int origin = grid[x][y];
        grid[x][y] = 0;
        int maxGold = 0;
        for(int[] dir : dirs){
            int xx = x +dir[0];
            int yy = y + dir[1];
            maxGold = Math.max(maxGold, helper(grid,xx,yy));
        }
        grid[x][y] = origin;
        return maxGold + origin;
    }

    public static void main(String[] args) {
        PathWithMaximumGold pathWithMaximumGold = new PathWithMaximumGold();
        int[][] arr = {{0,6,0},{5,8,7},{0,9,0}};
        System.out.println(pathWithMaximumGold.getMaximumGold(arr));
    }
}
