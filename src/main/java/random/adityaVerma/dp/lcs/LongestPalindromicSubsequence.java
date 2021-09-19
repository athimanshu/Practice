package random.adityaVerma.dp.lcs;

/**
 * Ref: https://leetcode.com/problems/longest-palindromic-subsequence/
 */
public class LongestPalindromicSubsequence {
    int[][] t;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        t = new int[n+1][n+1];

        return lcs(s,reverse(s));
    }

    private int lcs(String a, String b){
        int m = a.length();
        int n = b.length();

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }
    private String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
