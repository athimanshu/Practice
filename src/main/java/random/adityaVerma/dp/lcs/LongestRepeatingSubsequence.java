package random.adityaVerma.dp.lcs;

/**
 * Ref: https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1
 */
public class LongestRepeatingSubsequence {
    public int LongestRepeatingSubsequence(String str)
    {
        return lrs(str,str);
    }
    private int lrs(String a, String b){
        int m = a.length();
        int n = m;
        int[][] t = new int [m+1][n+1];
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(a.charAt(i-1) == b.charAt(j-1) && i != j){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }
}
