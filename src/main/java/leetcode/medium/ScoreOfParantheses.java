package leetcode.medium;

import java.util.Stack;

/**
 * Medium: 856 Score of Parentheses
 */
public class ScoreOfParantheses {
    public static void main(String[] args) {
        String s = "(()(()))";
        System.out.println(scoreOfParentheses(s));
    }
    public static int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        int count =0;
        for(int i =0;i<S.length();i++){
            if(S.charAt(i) == '('){
                stack.push(count);
                count = 0;
            }
            else {
                count = stack.pop() + Math.max(count*2,1);
            }
        }
        return count;

    }
}
