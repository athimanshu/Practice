package random.adityaVerma.dp.knapsack;

import java.util.ArrayList;

/**
 * Knapsack Variation3: Count number of subset for a given sum
 */
public class NoOfSubsequenceWithGivenSum {
    public int numSubseq(int[] nums, int target) {

        int n = nums.length;
        int[][] dp = new int[n+1][target+1];

        for(int i= 0; i<n; i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<target+1;j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
}
