package leetcode.hard;

/**
 * 10. Regular Expression Matching
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 */
public class RegularExpressionMatching {


    public boolean isMatch(String s, String p) {
        if(p.length() == 0){
            return s.length() ==0;
        }
        if(p.length()>=2 && p.charAt(1) == '*'){
            if(isMatch(s,p.substring(2))){
                return true;
            }
            if(s.length() >0 && (p.charAt(0) == '.' || (p.charAt(0) == s.charAt(0)))){
                return isMatch(s.substring(1),p);
            }
            return false;
        }else{
            if(s.length() > 0 && (p.charAt(0) == '.' || (p.charAt(0) == s.charAt(0)))){
                return isMatch(s.substring(1),p.substring(1));
            }
        }
        return false;
    }

    //My Implemetation
    public boolean actualRegex(String p, String s ) {

        int pSize = p.length();
        int sSize = s.length();
        int index = 0;
        int j = 0;
        boolean dotFlag = false;
        while (index < pSize && j < sSize) {
            switch (p.charAt(index)) {

                case '*':
                    index++;
                    dotFlag = false;
                    break;
                case '.':
                    index++;
                    j++;
                    dotFlag = false;
                    break;
                default:
                    if (p.charAt(index) == s.charAt(j)) {
                        index++;
                        j++;
                    } else if (index > 0 && p.charAt(index - 1) == '*') {
                        j++;
                    } else if (index > 0 && p.charAt(index - 1) == '.' && !dotFlag) {
                        j++;
                        dotFlag = true;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        if (index == pSize && j == sSize) {
            return true;
        } else if (index < pSize && j == sSize) {
            return false;
        } else if (index == pSize && j < sSize) {
            if (p.charAt(index - 1) == '*') {
                return true;
            } else if (p.charAt(index - 1) == '.' && j == sSize - 2) {
                return true;
            } else {
                return false;
            }
        }
        return true;

    }

    /*
    c*a*b
    aab

    a*
    aa
     */
    public static void main(String[] args) {
        RegularExpressionMatching regex = new RegularExpressionMatching();
        String s = "acdcb";
        String p = "a*c?b";
        System.out.println(regex.isMatch(s,p));

    }
}
