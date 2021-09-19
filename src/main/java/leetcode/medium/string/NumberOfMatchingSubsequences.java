package leetcode.medium.string;

import java.util.*;

/**
 * 792. Number of Matching Subsequences
 * Ref: https://leetcode.com/problems/number-of-matching-subsequences/discuss/117598/Java-solution-using-HashMap-and-Queue
 */
public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, Deque<String>> map = new HashMap<>();
        for(char c = 'a';c<='z';c++){
            map.putIfAbsent(c, new LinkedList<String>());
        }
        for(String word: words){
            map.get(word.charAt(0)).addLast(word);
        }
        int count = 0;
        for(char c: s.toCharArray()){
            Deque<String> deque = map.get(c);
            int size = deque.size();
            for(int i=0; i< size; i++){
                String word = deque.removeFirst();
                if(word.length() == 1){
                    count++;
                }else{
                    map.get(word.charAt(1)).addLast(word.substring(1));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a","bb","acd","ace"};
        NumberOfMatchingSubsequences obj = new NumberOfMatchingSubsequences();
        System.out.println(obj.numMatchingSubseq(s,words));
    }
}
