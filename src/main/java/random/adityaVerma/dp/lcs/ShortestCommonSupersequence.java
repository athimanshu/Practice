package random.adityaVerma.dp.lcs;

/**
 * Ref: https://leetcode.com/problems/shortest-common-supersequence/
 */
public class ShortestCommonSupersequence {
    int[][] t;
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        t = new int[m+1][n+1];
        fillLcsArray(str1,str2,m,n);
        return getSCS(str1,str2,m,n);
    }

    private void fillLcsArray(String a, String b, int m, int n){

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
    }

    private String getSCS(String a, String b, int i, int j){
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                sb.append(a.charAt(i-1));
                i--;
                j--;
            }else{
                if(t[i-1][j] > t[i][j-1]){
                    sb.append(a.charAt(i-1));
                    i--;
                }else{
                    sb.append(b.charAt(j-1));
                    j--;
                }
            }
        }
        while(i>0){
            sb.append(a.charAt(i-1));
            i--;
        }
        while(j>0){
            sb.append(b.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }
}
