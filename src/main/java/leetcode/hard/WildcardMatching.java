package leetcode.hard;

public class WildcardMatching {
    public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match =0, starIdx = -1;

        while(s<str.length()){

            if(p<pattern.length() && (str.charAt(s) == pattern.charAt(p) || pattern.charAt(p) == '?')){
                s++;
                p++;
            }else if(p < pattern.length() && pattern.charAt(p) == '*'){
                match = s;
                starIdx = p;
                p++;
            }else if(starIdx !=-1){
                p = starIdx + 1;
                match++;
                s= match;
            }else{
                return false;
            }
        }
        while(p<pattern.length() && pattern.charAt(p) == '*'){
            p++;
        }
        return p == pattern.length();
    }

    public static void main(String[] args) {
        WildcardMatching wildcardMatching = new WildcardMatching();
        String s = "acdcb";
        String p = "a*c?b";
        System.out.println(wildcardMatching.isMatch(s,p));
    }
}
