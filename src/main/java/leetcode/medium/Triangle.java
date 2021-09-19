package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(-1);
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        list3.add(1);
        list3.add(-1);
        list3.add(-3);
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        list.add(list1);
        list.add(list2);
        list.add(list3);
//        list.add(list4);
        Triangle obj = new Triangle();
        System.out.println(obj.minimumTotal(list));
    }
}
