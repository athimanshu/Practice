package leetcode.medium.arrays;

/**
 * 1035. Uncrossed Lines
 */
public class UncrossedLines {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public int maxUncrossedLines2(int[] nums1, int[] nums2){
        int m = nums1.length; int n = nums2.length;
        if(m<n) return maxUncrossedLines2(nums2,nums1);

        int[] dp = new int[n+1];
        for(int i=0;i<m;i++){
            for(int j=0,prev=0,curr;j<n;j++){
                curr = dp[j+1];
                if(nums1[i] == nums2[j])
                    dp[j+1] = 1 + prev;
                else dp[j+1] =Math.max(dp[j+1],dp[j]);
                prev = curr;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] nums1 = {2,5,1,2,5};
        int[] nums2 = {10,5,2,1,5,2};

        UncrossedLines obj = new UncrossedLines();
        obj.maxUncrossedLines(nums1,nums2);
        obj.maxUncrossedLines2(nums1,nums2);
    }
}
