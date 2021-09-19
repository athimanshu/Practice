package leetcode.medium;

public class WhereWillBallFall {
    public int[] findBall(int[][] grid) {
       if(grid.length == 0) return new int[0];
       int[] result = new int[grid[0].length];
       for(int i=0;i< grid[0].length;i++){
           int currRow = 0;
           int currCol = i;
           while(currRow<grid.length){
               // We go to the right if the current value and the value to the right are both equal to 1.
               if(grid[currRow][currCol] == 1 && currCol+1<grid[0].length && grid[currRow][currCol+1] == 1){
                   currCol++;currRow++;
               }
               // We go to the left if the current value and the value to the left are both equal to -1.
               else if(grid[currRow][currCol] == -1 && currCol -1 >=0 && grid[currRow][currCol-1] == -1){
                   currCol--;currRow++;
               }else{
                   // If we can't move to the left, and we can't move to the right, then the ball is stuck because there is no other way to move.
                   break;
               }
           }
           result[i] = currRow == grid.length?currCol:-1;
       }
       return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
        WhereWillBallFall obj = new WhereWillBallFall();
        System.out.println(obj.findBall(grid));
    }
}
