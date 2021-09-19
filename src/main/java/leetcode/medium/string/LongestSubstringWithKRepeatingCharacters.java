package leetcode.medium.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 395. Longest Substring with At Least K Repeating Characters
 * Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.
 */

public class LongestSubstringWithKRepeatingCharacters {

    public int longestSubstring(String s, int k) {

        Map<Character,Integer> charMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            charMap.put(ch,charMap.getOrDefault(ch,0)+1);
        }
        int maxLength = 0;
        int tempCount = 0;
        Map<Character,Integer> tempMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int count = charMap.get(ch);
            tempMap.put(ch,tempMap.getOrDefault(ch,0)+1);
            if(count < k){
                maxLength = Math.max(maxLength,tempCount);
                reduceCount(tempMap,charMap);
                tempCount = 0;
            }else{
                tempCount++;
            }

        }
        return maxLength >2?maxLength:0;
    }

    private void reduceCount(Map<Character, Integer> tempMap, Map<Character, Integer> charMap) {

        for(Map.Entry<Character,Integer> entry: tempMap.entrySet()){
            charMap.put(entry.getKey(),charMap.get(entry.getKey()) - entry.getValue());
        }
    }

    public static void main(String[] args) {
        String str = "ababbcaabacdddbb";
        int k = 3;
        String s = "-1.0";
        System.out.println(Double.parseDouble(s)>-2.0?1:-2);
        LongestSubstringWithKRepeatingCharacters obj = new LongestSubstringWithKRepeatingCharacters();
        System.out.println(obj.longestSubstring(str,k));
    }
}
