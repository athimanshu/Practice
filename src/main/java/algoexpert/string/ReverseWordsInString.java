package algoexpert.string;

import java.util.*;

public class ReverseWordsInString {
    public String reverseWordsInString(String string) {
        Map<Character,Integer> map = new HashMap<>();
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            for(int i=0;i<entry.getValue();i++){

            }
        }
        List<String> result = new ArrayList<>();
        int startOfWord = 0;

        for(int i=0;i<string.length();i++){
            char ch = string.charAt(i);
            if(ch == ' '){
                result.add(string.substring(startOfWord,i));
                startOfWord = i;
            }else if(string.charAt(startOfWord) == ' '){
                result.add(" ");
                startOfWord = i;
            }
        }
        result.add(string.substring(startOfWord));
        Collections.reverse(result);
        return String.join("",result);
    }
    public static void main(String[] args) {
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        //System.out.println(reverseWordsInString.reverseWordsInString("whitespace   of lot     a has     string      this"));
        System.out.println(reverseWordsInString.reverseWordsInString("help me man "));

    }
}
