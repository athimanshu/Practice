package random.adityaVerma.dp.knapsack;

/**
 * Leetcode 494: Target Sum
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i =0;i<nums.length;i++){
            sum +=nums[i];
        }
        int subsetSum = (sum+target)/2;

        if((target+sum)%2 !=0) return 0;

        return countSubset(nums,subsetSum);
    }
    private int countSubset(int[] nums, int subsetSum){
        int n = nums.length;

        int[][] dp = new int[n+1][subsetSum+1];

        for(int j=0;j<=subsetSum;j++){
            dp[0][j] = 0;
        }
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<n+1;i++){
            for(int j=0;j<subsetSum+1;j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][subsetSum];
    }
}
