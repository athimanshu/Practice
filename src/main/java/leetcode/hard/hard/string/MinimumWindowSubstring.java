package leetcode.hard.hard.string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int begin = 0, end = 0, head = 0, counter = map.size(), minLen = Integer.MAX_VALUE;

        while(end<s.length()){

            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;
            while(counter == 0){
                char c2 = s.charAt(begin);
                if(map.containsKey(c2)){
                    map.put(c2,map.get(c2)+1);
                    if(map.get(c2) >0){
                        counter++;
                    }
                }
                if(minLen>end-begin){
                    minLen = end - begin;
                    head = begin;
                }
                begin++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(head,head+minLen);

    }
























    /**
     * Ref: https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
     * @param s
     * @param t
     * @return
     */
    public String minWindow1(String s, String t) {
        int[] map = new int[128];
        for(char c: t.toCharArray()){
            map[c]++;
        }
        int start = 0, end = 0, minLength = Integer.MAX_VALUE, minStart=0,counter = t.length();
        while(end<s.length()){
            char ch1 = s.charAt(end);
            if(map[ch1] > 0) counter --;
            map[ch1] --;
            end++;

            while(counter == 0){
                if(minLength>end-start){
                    minLength = end-start;
                    minStart = start;
                }
                char ch2 = s.charAt(start);
                map[ch2]++;
                if(map[ch2] > 0) counter++;
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLength);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minWindow(s,t));


    }
}
