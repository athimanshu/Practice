package company.airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static Map<Character,Integer> result = new HashMap<>();
    public static List<String> costsOfNodes(List<String> lines) {
        Map<Character,List<Character>> map = new HashMap<>();
        for(int i=1;i<lines.size();i++){
            char[] arr = lines.get(i).toCharArray();
            List<Character> list = new ArrayList<>();
            fillInMap(arr,map,list);
        }
        calculate(map);
        return null;
    }

    private static List<Character> calculate(Map<Character, List<Character>> map) {

        for(Map.Entry<Character,List<Character>> val: map.entrySet()){

            int sum =val.getValue().size() + calculateRec(val.getValue(),map);
        }
        return null;
    }

    private static int calculateRec(List<Character> value,Map<Character, List<Character>> map) {

        for (Character ch: value){
            List<Character> list = findDependency(ch,map);
            for(Character c: list){
                if(result.containsKey(c)){

                }
            }
            if(list.size() == 0){
                result.put(ch,1);
            }else{

            }
        }
        return 0;
    }

    private static List<Character> findDependency(Character ch,Map<Character, List<Character>> map) {
        return map.get(ch);
    }

    private static void fillInMap(char[] arr,Map<Character,List<Character>> map,List<Character> list) {
        if(arr.length == 1){
            return;
        }
        list.add(arr[0]);
        for(int i= 1;i<arr.length;i++){
            result.put(arr[i],0);
            map.put(arr[i],list);
        }
    }
}
