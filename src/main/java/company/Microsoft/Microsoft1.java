package company.Microsoft;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Microsoft1 {
    public static void main(String[] args) {
        String s = "This is a String";
        findUnique(s);
    }
    private static void findUnique2(){

    }
    //Time: O(n)
    private static void findUnique(String oldString){
        Map<Character, Integer> charMap = new HashMap<>();
        String s = oldString.toLowerCase();
        for(int i=0;i<s.length();i++){
            char letter = s.toLowerCase().charAt(i);
            charMap.put(letter,charMap.getOrDefault(letter,0)+1);
        }
        for(Map.Entry<Character,Integer> map: charMap.entrySet()){
            if(map.getValue() == 1){
                System.out.print(map.getKey());
            }
        }
    }

}
