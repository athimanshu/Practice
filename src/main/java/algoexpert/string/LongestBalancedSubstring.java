package algoexpert.string;

import java.util.Stack;

public class LongestBalancedSubstring {
    public int longestBalancedSubstring(String string) {
        int maxLength = 0;
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        for(int i=0;i<string.length();i++){
            if(string.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.size() == 0){
                    stack.push(i);
                }else{
                    int balSubstringStaridx = stack.peek();
                    int tempLength = i - balSubstringStaridx;
                    maxLength = Math.max(maxLength, tempLength);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestBalancedSubstring obj = new LongestBalancedSubstring();
        obj.longestBalancedSubstring(")))()()");
    }

}

