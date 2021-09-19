package algoexpert.string;

import java.util.HashMap;
import java.util.Map;

public class PatternMatcher {
    public static String[] patternMatcher(String pattern, String str) {

        char[] newPattern = getNewPattern(pattern);
        boolean hasSwitched = newPattern[0] !=pattern.charAt(0);
        Map<Character,Integer> count = new HashMap<>();
        count.put('x',0);
        count.put('y',0);
        int firstYPos = fillPatternCountAndYFirstPos(newPattern,count);
        if (count.get('y')!= 0){
            for(int lenX = 1;lenX < str.length(); lenX++){

                double lenY = ((double)str.length() - (double)lenX* (double)count.get('x'))/ (double)count.get('y');

                if(lenY<=0 || lenY%1 !=0)
                    continue;
                int yIdx = lenX * firstYPos;
                String x = str.substring(0,lenX);
                String y = str.substring(yIdx, yIdx + (int) lenY);
                String potentialMatch = buildPotentialMatch(x,y,newPattern);

                if(str.equals(potentialMatch)){
                    return hasSwitched?new String[] {y,x}: new String[] {x,y};
                }
            }
        }else{
            double lenX = str.length() / count.get('x');
            if(lenX%1 ==0 ){
                String x = str.substring(0, (int) lenX);
                String potentialMatch = buildPotentialMatch(x,"",newPattern);

                if(str.equals(potentialMatch)){
                    return hasSwitched?new String[] {"",x}: new String[] {x, "y"};
                }
            }
        }
        return new String[] {};
    }

    private static String buildPotentialMatch(String x, String y, char[] newPattern) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<newPattern.length;i++){
            sb.append(newPattern[i] == 'x'? x:y);
        }
        return sb.toString();
    }

    private static int fillPatternCountAndYFirstPos(char[] newPattern, Map<Character, Integer> count) {
        int firstYPos = -1;
        for(int i=0;i<newPattern.length;i++){
            char ch = newPattern[i];
            count.put(ch,count.get(ch)+1);
            if(ch == 'y' && firstYPos ==-1){
                firstYPos = i;
            }
        }
        return firstYPos;
    }

    private static char[] getNewPattern(String pattern) {
        char[] newPattern = pattern.toCharArray();
        if(newPattern[0] == 'x') return newPattern;

        for(int i =0;i<pattern.length();i++){
            if(newPattern[i] == 'x'){
                newPattern[i] = 'y';
            }else{
                newPattern[i] = 'x';
            }
        }
        return newPattern;
    }
    public static void main(String[] args) {

    }
}
