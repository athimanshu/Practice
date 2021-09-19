package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Medium:  56 Merge Intervals
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        List<int[]> result = new ArrayList<>();

        int[] newInterval = intervals[0];
        result.add(newInterval);
        for(int i=1;i<intervals.length;i++){
            if(newInterval[1]>=intervals[i][0]){
                newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            }else{
                newInterval = intervals[i];
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][0]);
    }
    public static void main(String[] args) {
        int[][] input = {{1,3},{2,6},{8,10},{15,18}};
        MergeInterval mergeInterval = new MergeInterval();
        System.out.println(mergeInterval.merge(input));
    }
}
