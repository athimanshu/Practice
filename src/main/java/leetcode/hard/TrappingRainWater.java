package leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Hard: 407. Trapping Rain Water II
 * Ref: https://leetcode.com/problems/trapping-rain-water-ii/discuss/89461/Java-solution-using-PriorityQueue
 */
public class TrappingRainWater {
    class Cell{
        int length;
        int width;
        int height;
        Cell(int length, int width, int height){
            this.length = length;
            this.width = width;
            this.height = height;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length == 0 || heightMap[0].length ==0)
            return 0;
        int result = 0;
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height-b.height);

        int m = heightMap.length;
        int n = heightMap[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            visited[i][0] = true;
            visited[i][n-1] = true;
            pq.offer(new Cell(i,0,heightMap[i][0]));
            pq.offer(new Cell(i,n-1,heightMap[i][n-1]));
        }
        for(int i=0;i<n;i++){
            visited[0][i] = true;
            visited[m-1][i] = true;
            pq.offer(new Cell(0,i,heightMap[0][i]));
            pq.offer(new Cell(m-1,i,heightMap[m-1][i]));
        }
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!pq.isEmpty()){
            Cell cell = pq.poll();
            for(int[] dir: dirs ){
                int row = cell.length + dir[0];
                int column = cell.width + dir[1];
                if(row >=0 && row <m && column >=0 && column <n && !visited[row][column]){
                    visited[row][column] = true;
                    result += Math.max(0,cell.height - heightMap[row][column]);
                    pq.offer(new Cell(row,column,Math.max(heightMap[row][column], cell.height)));

                }
            }
        }
        return result;
    }
}
