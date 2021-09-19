package algoexpert.stack;

import java.util.Stack;

public class BalanceBrackets {
    public static boolean balancedBrackets(String str) {
        if(str.length() == 0)
            return true;

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(!isBracket(str.charAt(i)))
                continue;
            if(isOpeningBracket(str.charAt(i))){
                stack.push(str.charAt(i));
            }
            else{
                if(stack.empty() || !isMatch(stack.peek(),str.charAt(i)))
                    return false;
                stack.pop();
            }
        }

        return stack.empty();
    }
    private static boolean isOpeningBracket(char c){
        if (c == '(' || c == '[' || c == '{')
            return true;
        return false;
    }
    private static boolean isMatch(char a, char b){
        if(b == ')' && a != '(' )
            return false;
        if(b == '}' && a != '{')
            return false;
        if(b == ']' && a != '[')
            return false;

        return true;
    }
    private static boolean isBracket(char c){
        if (c == '(' ||c == '[' ||c == '{' || c == ')' ||c == ']' ||c == '}' )
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "(a)";
        balancedBrackets(s);
    }
}
