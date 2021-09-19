package leetcode.hard.array;

/**
 * Hard 410:Split Array Largest Sum
 * Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
 * Write an algorithm to minimize the largest sum among these m subarrays.
 *
 * Ref:
 * 1. https://www.youtube.com/watch?v=2JSQIhPcHQg&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=21
 * 2. https://leetcode.com/problems/split-array-largest-sum/discuss/89817/Clear-Explanation%3A-8ms-Binary-Search-Java
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0L;
        for(int num: nums){
            max = Math.max(num,max);
            sum +=num;
        }
        if (m==1) return (int) sum;

        //binary Search
        long l = max;
        long r = sum;
        while(l<=r){
            long mid = (l+r)/2;
            if(isValid(mid,nums,m)){
                r = mid-1;
            }else{
                l = mid +1;
            }
        }
        return (int)l;
    }

    private boolean isValid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for(int num: nums){
            total += num;
            if(total>target){
                total = num;
                count++;
                if(count>m){
                    return false;
                }
            }
        }
        return true;
    }
}
