package company.paypal;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Amit2 {
    public static int solve(int n, int t, int[][] task){
        int result = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0] + a[1]));
        for(int[] node : task){
            pq.add(node);
        }
        int lastPos = 0;
        int[] baseCond = pq.peek();
        if(t < baseCond[0] + baseCond[1])
            return 0;

        while(pq.size()>0 && t>lastPos){
            int[] curr = pq.poll();
            int currSum = Math.abs(lastPos-curr[0]) + curr[1];
            t -= currSum;
            lastPos = curr[0];
            if(t<lastPos)
                break;
            result++;

        }
        return result;
    }

    public static void main(String[] args) {
        int[][] task = {{3,8},{4,5},{5,1},{8,10},{20,21},{2,8}};
        System.out.println(solve(5,16,task));
    }
}
