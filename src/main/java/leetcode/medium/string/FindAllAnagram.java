package leetcode.medium.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagram {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length()) return result;

        Map<Character,Integer> map = new HashMap<>();
        for(char c: p.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int start = 0, end = 0, counter = map.size(), head = 0;
        while(end<s.length()){
            char c1 = s.charAt(end);
            if(map.containsKey(c1)){
                map.put(c1,map.get(c1)-1);
                if(map.get(c1) == 0) counter --;
            }
            end++;
            while(counter == 0){
                char c2 = s.charAt(start);
                if(map.containsKey(c2)){
                    map.put(c2,map.get(c2)+1);
                    if(map.get(c2) >0){
                        counter++;
                    }
                }
                if(end-start == p.length()){
                    result.add(start);
                }
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindAllAnagram().findAnagrams("cbaebabacd","abc"));
    }
}
