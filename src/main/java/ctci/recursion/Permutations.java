package ctci.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * String Permutations Different Approach
 */
public class Permutations {

    public List<String> getPerms(String s){
        if(s==null){
            return null;
        }
        List<String> result = new ArrayList<>();
        if(s.length()==0){
            result.add("");
            return result;
        }
        char first = s.charAt(0);
        String remainder = s.substring(1);
        List<String> words = getPerms(remainder);
        for(String word : words){
            for(int j=0; j<=word.length();j++){
                String sub = insertChartAt(word,first,j);
                result.add(sub);
            }
        }
        return result;
    }

    private String insertChartAt(String word, char first, int j) {
        String start = word.substring(0,j);
        String end = word.substring(j);
        return start + first + end;
    }


    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        permutations.getPerms("String");
        List<String> s = permutations.getPerms2("String");
        s = permutations.getPerms3("Str");
        System.out.println(s.size());
    }
    /* Approach2*/

    public List<String> getPerms2(String s){
        int length = s.length();
        ArrayList<String> result = new ArrayList<>();
        if(length == 0){
            result.add("");
            return result;
        }
        for(int i=0; i<length;i++){
            /*Remove char i and find permutation of remaining String*/
            String before = s.substring(0,i);
            String after = s.substring(i+1,length);
            List<String> partials = getPerms2(before+after);

            for(String str: partials){
                result.add(s.charAt(i)+str);
            }
        }
        return result;
    }

    /*Approach 3*/
    public List<String> getPerms3(String s){
        List<String> result = new ArrayList<>();
        getPerms3("",s,result);
        return result;
    }

    private void getPerms3(String prefix, String remainder, List<String> result) {
        if(remainder.length()==0)  result.add(prefix);

        int len = remainder.length();
        for(int i=0;i<len;i++){
            String before = remainder.substring(0,i);
            String after = remainder.substring(i+1,len);
            char c = remainder.charAt(i);
            getPerms3(prefix+c,before+after,result);
        }
    }
}
