package leetcode.hard.hard.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. Substring with Concatenation of All Words
 *Example 1:
 *
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 *
 * Ref: https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/13658/Easy-Two-Map-Solution-(C%2B%2BJava)
 *
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> countMap = new HashMap<>();
        for(String word: words){
            countMap.put(word,countMap.getOrDefault(word,0)+1);
        }
        List<Integer> indexes = new ArrayList<>();
        int n = s.length() , num = words.length, wordLen = words[0].length();
        for(int i=0;i<n-num*wordLen+1;i++){
            Map<String,Integer> seen = new HashMap<>();
            int j = 0;
            while(j<num){
                String word = s.substring(i+j*wordLen,i + (j+1) *wordLen);
                if(countMap.containsKey(word)){
                    seen.put(word,seen.getOrDefault(word,0)+1);
                    if(seen.get(word)>countMap.getOrDefault(word,0)){
                        break;
                    }
                }else{
                    break;
                }
                j++;
            }
            if(j==num){
                indexes.add(i);
            }

        }
        return indexes;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(s,words));
    }
}
