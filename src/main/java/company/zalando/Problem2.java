package company.zalando;

import java.util.*;

/**
 * Distinct occurence of each character
 */
public class Problem2 {

    public static int solution(String s) {
        // write your code in Java SE 8
        Map<Character, Integer> map = new HashMap<>();
        int result=0;


        for(Character c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Integer> mapList = new ArrayList<>(map.values());
        Set<Integer> valSet = new HashSet<>();

        //Iterating over the list
        for(Integer count: mapList){
            while(count!=0){
                if(valSet.contains(count)){
                    count--;
                    result++;
                }else{
                    valSet.add(count);
                    break;
                }
            }
        }
        return result;
    }
    public static int minDeletions(String s) {
        int freq[] = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        Arrays.sort(freq);
        int keep = freq[25], prev = keep;
        for (int i = 24; i >= 0 && freq[i] != 0 && prev != 0; i--) {
            prev = Math.min(freq[i], prev - 1);
            keep += prev;
        }
        return s.length() - keep;
    }
    public static void main(String[] args) {
        System.out.println(solution("aaaabbbcccceff"));
        System.out.println(minDeletions("aaaabbbcccceff"));
    }
}
