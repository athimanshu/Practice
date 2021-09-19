package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. Permutation in String
 * Given two strings s1 and s2, return true if s2 contains the permutation of s1.
 *
 * In other words, one of s1's permutations is the substring of s2.
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n>m){
            return false;
        }
        int[] count = new int[26];
        for(int i=0;i<n;i++){
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if(allZero(count))
            return true;
        for(int i=n;i<m;i++){
            count[s2.charAt(i) -'a'] --;
            count[s2.charAt(i-n) - 'a'] ++;
            if(allZero(count)) return true;
        }
        return false;
    }
    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(permutationInString.checkInclusion(s1,s2));
    }
}
