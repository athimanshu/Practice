package random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class HeapTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> pqHeap = new PriorityQueue<>(Collections.reverseOrder());

        pqHeap.add(20);
        pqHeap.add(1);
        pqHeap.add(9);
        pqHeap.add(7);
        pqHeap.add(39);
        pqHeap.add(4);

//        for(Integer n: pqHeap){
//            System.out.println(n);
//        }
        findKLowestNum( 3);
        findKLargestNum(3);
    }

    private static void findKLargestNum(int k) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pqHeap = new PriorityQueue<>();
        list.add(20);
        list.add(1);
        list.add(9);
        list.add(7);
        list.add(39);
        list.add(4);
        list.add(5);

        for(Integer num: list){
            pqHeap.add(num);
            if(pqHeap.size()>k){
                pqHeap.poll();
            }
        }
        System.out.println(pqHeap.peek());

    }


    static void findKLowestNum(int k){
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pqHeap = new PriorityQueue<>(Collections.reverseOrder());
        list.add(20);
        list.add(1);
        list.add(9);
        list.add(7);
        list.add(39);
        list.add(4);
        list.add(5);

        for(Integer num: list){
            pqHeap.add(num);
            if(pqHeap.size()>k){
                pqHeap.poll();
            }
        }
        System.out.println(pqHeap.peek());

    }
}
