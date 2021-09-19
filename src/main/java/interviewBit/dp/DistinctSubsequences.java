package interviewBit.dp;

/**
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 * Input: s = "rabbbit", t = "rabbit"
 * Output: 3
 * Explanation:
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * rabbbit
 * rabbbit
 * rabbbit
 * Ref: https://www.youtube.com/watch?v=NR9lLQnFjWc + https://leetcode.com/problems/distinct-subsequences/
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {

        int s1 = s.length();
        int t1 = t.length();
        int[][] dp = new int[t1+1][s1+1];
        for(int i=0;i<=s1;++i){
            dp[0][i] = 1;
        }

        for(int i=1;i<=t1;++i){
            for(int j=1;j<=s1;++j){
                if(s.charAt(j-1) == t.charAt(i-1))
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                else
                    dp[i][j] = dp[i][j-1];
            }
        }
        return dp[t1][s1];
    }
}
