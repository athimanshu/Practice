package company.uhg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Problem2 {
    public String solution(String s){
        StringBuilder sb = new StringBuilder();
        s.replace("\\n","\n");
        List<String> data;
        data = split(s);

        for(int i=0;i<data.size();i++){
            String temp = data.get(i);
            if(temp.contains(",NULL") ||temp.contains("NULL,") ){
                continue;
            }else{
                sb.append(temp).append("\\n");
            }

        }
        return sb.toString().substring(0,sb.length()-2);
    }

    private List<String> split(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '\n' || (i!=s.length()-1 && s.charAt(i) == '\\' && s.charAt(i+1) == 'n')){
                list.add(sb.toString());
                sb.setLength(0);
            }else{
                sb.append(s.charAt(i));
            }
        }
        list.add(sb.toString());
        return list;
    }

    public static void main(String[] args) {
        Problem2 obj = new Problem2();
        System.out.println(obj.solution("header,header\nANNUL,ANNULLED\nnull,NILL\nNULL,NULL"));
    }
}
