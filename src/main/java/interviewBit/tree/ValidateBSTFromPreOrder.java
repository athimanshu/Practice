package interviewBit.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidateBSTFromPreOrder {
    public int solve(List<Integer> list) {
        Stack<Integer> stack = new Stack<Integer>();
        int root = Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            while(!stack.isEmpty() && list.get(i) > stack.peek()){
                root= stack.pop();
            }
            if(list.get(i)<root){
                return 0;
            }
            stack.push(list.get(i));
        }
        return 1;
    }

    public static void main(String[] args) {
        Integer[] arr = {4,1,3};
        ValidateBSTFromPreOrder validateBSTFromPreOrder = new ValidateBSTFromPreOrder();
        validateBSTFromPreOrder.solve(Arrays.asList(arr));
    }
}
