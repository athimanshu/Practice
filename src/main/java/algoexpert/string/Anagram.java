package algoexpert.string;

import java.util.*;
import java.util.stream.Stream;

public class Anagram {
    public List<List<String>> groupAnagrams(List<String> words) {

        List<List<String>> result = new ArrayList<>();
        int j =0;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.size();i++){
            String sortedString = sort(words.get(i));
            if(map.containsKey(sortedString)){
                result.get(map.get(sortedString)).add(words.get(i));
            }else{
                List<String> anagramList = new ArrayList<>();
                anagramList.add(words.get(i));
                map.put(sortedString,j);
                result.add(anagramList);
                j++;
            }
        }
        return result;
    }
    private static String sort(String s){
        char tempArray[] = s.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        List<String> list = new ArrayList<>();
        list.add("yo");
        list.add("act");
        list.add("flop");
        list.add("tac");
        list.add("cat");
        list.add("oy");
        list.add("olfp");

        anagram.groupAnagrams(list);
    }
}
