package random.adityaVerma.dp.knapsack;

/**
 * Knapsack Category
 * Leetcode: 416
 */
public class EqualSumPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
        }
        if(sum%2 != 0){
            return false;
        }
        int val = sum/2;
        return findSubsetSum(nums,val);
    }

    public boolean findSubsetSum(int[] nums, int sum){
        int n = nums.length;
        boolean[][] t = new boolean[n+1][sum+1];
        for(int i=0;i<n;i++){
            t[i][0] = true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(nums[i-1] <= j){
                    t[i][j] = (t[i-1][j-nums[i-1]]) || (t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
