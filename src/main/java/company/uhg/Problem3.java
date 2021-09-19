package company.uhg;
import  java.util.*;
import java.util.stream.Stream;

public class Problem3 {
    public String solution(String s){

        List<Character> list =  new ArrayList<>();
        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i));
        }
        int i=0;
        while(i<list.size()-1){
            if(i!=list.size() && (list.get(i) == 'B' && list.get(i+1) == 'A' || list.get(i) == 'A' && list.get(i+1) == 'B')
            ||(list.get(i) == 'C' && list.get(i+1) == 'D' || list.get(i) == 'D' && list.get(i+1) == 'C') ){
                list.remove(i);
                list.remove(i);
            }else{
                i++;
            }
        }
        if(list.size() == 2 && (list.get(1) == list.get(0)-1 || list.get(1) == list.get(0) +1)){
            list.remove(0);
            list.remove(0);
        }
        StringBuilder result = new StringBuilder();
        list.stream().forEach(c -> result.append(c));
        return result.toString();
    }
    public static void main(String[] args) {
        Problem3 obj = new Problem3();
        System.out.println(obj.solution("CBACD"));
    }
}
