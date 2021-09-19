package company.zalando;

import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        System.out.println(solutionSuraj("45096879574847383738"));
        System.out.println(solution("45096879574847383738"));
    }
    public static int solution(String s){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length()-1; i++) {
            if(s.substring(i+2)!= null) {
                if(Integer.parseInt(s.substring(i, i + 2)) >max){
                    max = Integer.parseInt(s.substring(i, i + 2));
                }
            }
        }
       return max;
    }

    public static int solutionSuraj(String s){
        List<Integer> a = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < s.length()-1; i++) {
            if(s.substring(i+2)!= null) {
                count++;
                a.add(Integer.parseInt(s.substring(i, i + 2)));
            }

        }
        Collections.sort(a);
        return Integer.parseInt(a.get(count-1).toString());
    }

}
