package algoexpert.recursion;

import java.util.HashMap;
import java.util.Map;

public class SingleCycleCheck {
    public static boolean hasSingleCycle(int[] array) {
        int j =0;
        int pointer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(j,array[j]);
        for(int i=0;i<array.length;i++){
            pointer = array[j];
            if(j+pointer>array.length-1){
                j = j+array[j] - array.length;
            }else if (j+pointer<0) {
                j = array.length + (j+array[j]);
            }else{
                j = j+array[j];
            }
            if(map.containsKey(j)){
                return true;
            }
            map.put(j,array[j]);
        }
        return false;

    }
    public static void main(String[] args) {
        int[] arr = {10, 11, -6, -23, -2, 3, 88, 908, -26};
        System.out.println(hasSingleCycle(arr));
    }
}
