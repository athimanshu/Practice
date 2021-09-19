package random.adityaVerma.dp.lcs;

/**
 * Ref: https://practice.geeksforgeeks.org/problems/minimum-deletitions1648/1
 */
public class MinimumDeletionToMakePalindrome {
    static int[][] t;
    static int minimumNumberOfDeletions(String s) {
        int m = s.length();
        t = new int[m+1][m+1];

        return m - lps(s);
    }
    private static int lps(String s){
        return lcs(s,reverse(s));
    }
    private static int lcs(String a, String b){

        for(int i=1;i<a.length()+1;i++){
            for(int j=1;j<b.length()+1;j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[a.length()][b.length()];
    }
    private static String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
