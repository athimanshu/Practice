package random;

import java.util.Stack;

public class PreviousGreaterElement {
    public static void main(String[] args) {
        int arr[] = {10, 4, 2, 20, 40, 12, 30};
        int[] result = prevGreaterElement(arr);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }

    public static int[] prevGreaterElement(int[] arr){
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        int[] result = new int[arr.length];
        result[0] = -1;
        for(int i=1;i<arr.length;i++){
            while (!stack.empty() && stack.peek()<arr[i]){
                stack.pop();
            }
            if(stack.empty()){
                result[i] = -1;
            }else{
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;

    }
}
