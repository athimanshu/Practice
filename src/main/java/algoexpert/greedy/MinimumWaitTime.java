package algoexpert.greedy;

import java.util.Arrays;

public class MinimumWaitTime {
    public int minimumWaitingTime(int[] queries) {
        int totalWaitTime = 0;
        int waitTime = 0;
        Arrays.sort(queries);
        for(int i=1;i<queries.length;i++){
            waitTime +=  queries[i-1];
            totalWaitTime +=waitTime;
        }
        return totalWaitTime;
    }
    /*
    1, 2, 2, 3, 6
    0 + (1) + (1+2) + (3 +2) +(5+3)
     */
    public static void main(String[] args) {
        int[] queries = {3,2,1,2,6};
        MinimumWaitTime obj = new MinimumWaitTime();
        System.out.println(obj.minimumWaitingTime(queries));
    }
}
