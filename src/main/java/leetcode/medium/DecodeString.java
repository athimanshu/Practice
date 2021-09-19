package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 394: DecodeString
 */

public class DecodeString {
    public String decodeString(String s) {
        // Stack is deprecated so using double-ended Q
        Deque<Integer> multipliers = new ArrayDeque<>();
        Deque<StringBuilder> result = new ArrayDeque<>();
        result.push(new StringBuilder());
        int multiplier = 0;

        // Would be nice to use an 'enhanced' for loop, but don't want
        // the expense of converting the String to an array (ie toCharArray)
        // for (char ch : s.toCharArray()) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                multiplier = multiplier * 10 + Character.getNumericValue(ch);
            } else if (ch == '[') {
                multipliers.push(multiplier);
                multiplier = 0; //reset
                result.push(new StringBuilder());
            } else if (ch == ']') {
                StringBuilder str2Multiply = result.pop();
                int times = multipliers.pop();
                StringBuilder multipliedStr = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    multipliedStr.append(str2Multiply);
                }
                result.push(result.pop().append(multipliedStr));
            } else {
                result.push(result.pop().append(ch));
            }
        }

        return result.pop().toString();
    }

    public static void main(String[] args) {
        DecodeString obj = new DecodeString();
        obj.decodeString("3[a2[c]]");
    }
}
