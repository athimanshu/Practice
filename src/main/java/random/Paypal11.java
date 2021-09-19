package random;

import java.util.*;

/**
 * 12
 * 14
 * 1
 * 7
 * 12
 * 6
 */
//map1 --> (14,1 : 1,1 : 7,1: 6,1: (12,1)
//tempFreq = 2;
//maxCount = 2;
//stack --> 12,14,1,7
//map2 --> 1,(12,14,1,7,6) : 2,(12)
//a: 12
public class Paypal11 {
    Map<Integer, Stack<Integer>> map2 = new HashMap<>();
    Map<Integer,Integer> map1 = new HashMap<>();
    int maxCount = 0;
    public void push(int a){

        int tempFreq = map1.getOrDefault(a,0)+1;
        map1.put(a,tempFreq);
        if(tempFreq > maxCount){
            maxCount = tempFreq;
        }
        Stack<Integer> input = map2.get(tempFreq) != null ? map2.get(tempFreq):new Stack<>();
        input.push(a);
        map2.put(tempFreq,input);
    }
    public int pop() {
        int a = map2.get(maxCount).pop();
        map1.put(a,map1.get(a) -1);

        if(map2.get(maxCount).size() == 0){
            maxCount --;
        }
        return a;
    }

    public static void main(String[] args) {
        Paypal11 paypal11 = new Paypal11();
        paypal11.push(12);
        paypal11.push(14);
        paypal11.push(1);
        paypal11.push(7);
        paypal11.push(12);
        paypal11.push(6);
        System.out.println(paypal11.pop());
        System.out.println(paypal11.pop());
        System.out.println(paypal11.pop());

    }
}
