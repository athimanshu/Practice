package leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 57. Insert Interval
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> ans = new LinkedList<>();
        int i=0;
        for(i =0; i<intervals.length;i++){
            if(intervals[i][1]<newInterval[0]){
                ans.add(intervals[i]);
            }else{
                break;
            }
        }
        if(ans.isEmpty() || ans.getLast()[1]<newInterval[0])
            ans.add(newInterval);
        else
            ans.getLast()[1] = Math.max(ans.getLast()[1],newInterval[1]);

        while(i<intervals.length){
            if(ans.getLast()[1] <intervals[i][0]){
                ans.add(intervals[i]);
            }else{
                ans.getLast()[1] = Math.max(ans.getLast()[1],intervals[i][1]);
            }
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        InsertInterval insertInterval = new InsertInterval();
        System.out.println(insertInterval.insert(intervals,newInterval));
    }
}
