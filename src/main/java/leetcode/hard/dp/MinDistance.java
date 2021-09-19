package leetcode.hard.dp;

/**
 * Hard: 72
 *Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 */

public class MinDistance {
    public int minDistance(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1+1][len2+1];

        for (int i = 0; i <= len1; i++)
            dp[i][0] = i;
        for (int i=1; i<=len2; i++)
            dp[0][i] = i;

        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                if(str1.charAt(i) == str2.charAt(j))
                    dp[i+1][j+1] = dp[i][j];
                else
                    dp[i+1][j+1] = Math.min(dp[i][j],Math.min(dp[i+1][j],dp[i][j+1])) +1;
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        MinDistance minDistance = new MinDistance();
        String str1 = "horseeeeeeep";
        String str2 = "ros";
        System.out.println(minDistance.minDistance(str1,str2));
    }
}
