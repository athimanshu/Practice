package leetcode.medium.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            minHeap.add(entry);
            if (minHeap.size() > k) minHeap.poll();
        }


        int[] res = new int[k];
        int  i =0;
        while(i<k){
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            res[i] =entry.getKey();
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        TopKFrequent obj = new TopKFrequent();
        int[] arr = {1,1,1,2,2,3,3,3,6,42,3,};
        int[] result = obj.topKFrequent(arr,3);
        Stream.of(result).forEach(a-> System.out.println(a));

    }
}
