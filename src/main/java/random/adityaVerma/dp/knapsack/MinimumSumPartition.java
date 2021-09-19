package random.adityaVerma.dp.knapsack;

/**
 * GFG: https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1#
 * Given an integer array arr of size N, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum and find the minimum difference
 */
public class MinimumSumPartition {
    public int minDifference(int arr[], int n)
    {
        StringBuilder sb = new StringBuilder();
        String s = sb.reverse().toString();

        int sum = 0;
        for(int i=0;i<n;i++){
            sum +=arr[i];
        }

        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i=0;i<n+1;i++){
            dp[i][0] = true;
        }

        for(int i=1;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(arr[i-1] <=j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int diff = Integer.MAX_VALUE;
        for(int i=sum/2;i>=0;i--){
            if(dp[n][i]){
                diff = sum - (2 *i);
                break;
            }
        }
        return diff;
    }
}
