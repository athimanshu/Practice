package algoexpert.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplication {
    public static String longestSubstringWithoutDuplication(String str) {
        String result = new String();
        if(str.equals("")){
            return str;
        }
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),i);
                sb.append(str.charAt(i));
            }else{

                if(sb.length()>result.length()){
                    result = sb.toString();
                }
                sb.setLength(0);
                sb.append(str.substring(map.get(str.charAt(i))+1,i+1));

                fillMap(map,str,map.get(str.charAt(i)),i);
            }
        }
        if(sb.length()>result.length()){
            result = sb.toString();
        }
        return result;
    }

    private static void fillMap(Map<Character, Integer> map, String str, int start, int end) {
        map.clear();
        for(int i= start;i<=end;i++){
            map.put(str.charAt(i),i);
        }

    }

    public static void main(String[] args) {
        System.out.println(LongestSubstringWithoutDuplication.longestSubstringWithoutDuplication("abcbde"));
    }
}
