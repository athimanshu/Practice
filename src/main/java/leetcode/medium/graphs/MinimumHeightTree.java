package leetcode.medium.graphs;

import java.util.*;

/**
 * 310. Minimum Height Trees
 */

public class MinimumHeightTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if(n==0){
            return result;
        }
        if(n==1){
            result.add(0);
            return result;
        }
        int[] degree = new int[n];
        List<List<Integer>> adjcanceyList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjcanceyList.add(new ArrayList<>());
        }
        for(int[] e:edges){
            degree[e[0]]++;
            degree[e[1]]++;
            adjcanceyList.get(e[0]).add(e[1]);
            adjcanceyList.get(e[1]).add(e[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i] == 1)
                queue.offer(i);
        }
        while (n>2){
            int size = queue.size();
            n-=size;

            while(size-- > 0){
                int v = queue.poll();
                for(int i:adjcanceyList.get(v)){
                    degree[i]--;
                    if(degree[i] == 1){
                        queue.add(i);
                    }
                }
            }
        }
        result.addAll(queue);
        return result;
    }
}
