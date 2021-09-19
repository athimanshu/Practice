package leetcode.medium.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 */
public class LongestNonRepeatingSubstring {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "pkeeilo";
        LongestNonRepeatingSubstring longestNonRepeatingSubsequence = new LongestNonRepeatingSubstring();
        System.out.println(longestNonRepeatingSubsequence.lengthOfLongestSubstring(s));
    }
}
