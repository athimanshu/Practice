package leetcode.medium.graphs;

import java.util.HashMap;
import java.util.Map;

public class MostStonesRemoved {
    Map<Integer,Integer> f = new HashMap<>();
    int islands = 0;
    public int removeStones(int[][] stones){
        for(int i=0;i<stones.length;i++){
            union(stones[i][0],~stones[i][1]);
        }
        return stones.length-islands;
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x!=y){
            f.put(x,y);
            islands--;
        }
    }
    private int find(int x){
        if(f.putIfAbsent(x,x) == null){
            islands++;
        }
        if(x !=f.get(x)){
            f.put(x,find(f.get(x)));
        }
        return f.get(x);
    }
}
