package leetcode.medium.arrays;

/**
 * 300. Longest Increasing Subsequence
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int m = nums.length;
        int n = nums.length;
        int[][] dp = new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(nums[i-1]<nums[j-1]){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println(lis.lengthOfLIS(nums));
    }
}
