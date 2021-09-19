package leetcode.medium;

import java.util.*;

/**
 * 49. Group Anagrams
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs ==null || strs.length == 0) return new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String keyString = String.valueOf(ch);
            if(!map.containsKey(keyString)){
                map.put(keyString,new ArrayList<>());
            }
            map.get(keyString).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] s= {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> list = ga.groupAnagrams(s);
        for (List<String> strs: list){
            for (String str: strs){
                System.out.println(str);
            }
        }

    }
}
