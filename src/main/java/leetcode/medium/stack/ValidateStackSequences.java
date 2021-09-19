package leetcode.medium.stack;

import java.util.Stack;

/**
 * Medium: 946. Validate Stack Sequences
 * Given two sequences pushed and popped with distinct values, return true if and only if this
 * could have been the result of a sequence of push and pop operations on an initially empty stack.
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n= pushed.length;
        int m = popped.length;
        if(m>n) return false;
        Stack<Integer> stack = new Stack<>();
        int i=0,j=0;
        for( i=0,j=0;i<n&&j<m;){
            if(pushed[i] == popped[j]){
                i++;
                j++;
            }
            else if(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
            else{
                stack.push(pushed[i]);
                i++;
            }
        }
        while(!stack.empty()){
            if(stack.peek() == popped[j]){
                stack.pop();
                j++;
            }else{
                break;
            }

        }
        if(stack.isEmpty() && j == m)
            return true;
        return false;
    }

    public static void main(String[] args) {
       int[] pushed = {1,2,3,4,5};
       int[] popped = {4,5,3,2,1};
        System.out.println(new ValidateStackSequences().validateStackSequences(pushed,popped));
    }
}
