package interviewBit.dp;

/**
 * Leetcode: 516. Longest Palindromic Subsequence
 * Ref: https://www.youtube.com/watch?v=RiNzHfoA2Lo&t=1539s
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromicSubsequence(String str){
        int[][] dp = new int[str.length()][str.length()];

        for(int gap =0;gap<str.length();gap++){
            for(int i=0,j=gap;j<str.length();i++,j++){
                if(gap == 0)
                    dp[i][j]= 1;
                else if(gap == 1)
                    dp[i][j] = str.charAt(i) == str.charAt(j)?2:1;
                else{
                    if(str.charAt(i) == str.charAt(j))
                        dp[i][j] = 2 + dp[i+1][j-1];
                    else
                        dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][str.length()-1];
    }
    public static void main(String[] args) {
        LongestPalindromicSubsequence lcs = new LongestPalindromicSubsequence();
        System.out.println(lcs.longestPalindromicSubsequence("bebeeed"));
    }
}
