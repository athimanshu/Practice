package algoexpert.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumCharacterForString {
    public String[] minimumCharactersForWords(String[] words) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            Map<Character,Integer> tempMap = new HashMap<>();
            for(int j=0;j<words[i].length();j++){
                tempMap.put(words[i].charAt(j),tempMap.getOrDefault(words[i].charAt(j),0)+1);
            }
            for(Map.Entry<Character,Integer> entry: tempMap.entrySet()){
                if(map.containsKey(entry.getKey())) {
                    if (map.get(entry.getKey()) < entry.getValue()) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }else {
                    map.put(entry.getKey(),entry.getValue());
                }
            }
        }
        List<String> list = new ArrayList<>();
        int j = 0;
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            for(int i=0;i<entry.getValue();i++){
                list.add(Character.toString(entry.getKey()));
            }
            j+=entry.getValue();
        }
        String[] result = new String[list.size()];
        result = list.toArray(result);
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"this", "that", "did", "deed", "them!", "a"};
        MinimumCharacterForString obj = new MinimumCharacterForString();
        System.out.println(obj.minimumCharactersForWords(words));
    }
}
