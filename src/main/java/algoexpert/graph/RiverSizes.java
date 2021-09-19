package algoexpert.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RiverSizes {
    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(visited[i][j])
                    continue;
                traverseMatrix(i,j,matrix,result,visited);
            }
        }
        return result;
    }

    private static void traverseMatrix(int i, int j, int[][] matrix, List<Integer> result, boolean[][] visited) {
        int currentRiverSize = 0;
        Stack<Integer[]> nodesToTraverse = new Stack<>();
        nodesToTraverse.push(new Integer[] {i,j});
        while(!nodesToTraverse.empty()){
            Integer[] node = nodesToTraverse.pop();
            i = node[0];
            j = node [1];

            if(visited[i][j])
                continue;
            visited[i][j] = true;

            if(matrix[i][j] == 0)
                continue;
            currentRiverSize++;

            List<Integer[]> unvisitedNeighbours = getUnvistedNeighbour(i,j,matrix,visited);
            for(Integer[] neighbour : unvisitedNeighbours){
                nodesToTraverse.add(neighbour);
            }

        }
        if(currentRiverSize > 0){
            result.add(currentRiverSize);
        }
    }

    private static List<Integer[]> getUnvistedNeighbour(int i, int j, int[][] matrix, boolean[][] visited) {
        List<Integer[]> unvisitedNeighbours = new ArrayList<>();

        if(i>0 && !visited[i-1][j])
            unvisitedNeighbours.add(new Integer[]{i-1,j});

        if(i<matrix.length-1 && !visited[i+1][j])
            unvisitedNeighbours.add(new Integer[] {i+1,j});

        if(j>0 && !visited[i][j-1])
            unvisitedNeighbours.add(new Integer[]{i,j-1});

        if(j<matrix[0].length-1 && !visited[i][j+1])
            unvisitedNeighbours.add(new Integer[] {i,j+1});

        return unvisitedNeighbours;
    }
}
