package leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return result;
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0 , right = m-1;
        int top = 0, bottom = n-1;

        while(result.size()<n*m){

            for(int j=left;j<=right && result.size()<n*m; j++)
                result.add(matrix[top][j]);

            for(int i=top+1;i<=bottom-1 && result.size()<n*m;i++)
                result.add(matrix[i][right]);

            for(int j=right;j>=left && result.size()<n*m;j--)
                result.add(matrix[bottom][j]);

            for(int i=bottom-1; i>=top+1 && result.size() <n*m ; i--)
                result.add(matrix[i][left]);

            left++;right--;top++;bottom--;
        }
        return result;
    }
}
