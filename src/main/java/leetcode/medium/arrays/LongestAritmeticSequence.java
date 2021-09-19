package leetcode.medium.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestAritmeticSequence {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int result = 0;
        Map<Integer,Integer>[] dp = new HashMap[n];
        for(int j=0;j<n;j++){
            dp[j] = new HashMap<>();
            for(int i=0;i<j;i++){
                int d= nums[j]-nums[i];
                dp[j].put(d,dp[i].getOrDefault(d,1)+1);
                result = Math.max(result,dp[j].get(d));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {9,4,7,2,10};
        LongestAritmeticSequence longestAritmeticSequence = new LongestAritmeticSequence();
        System.out.println(longestAritmeticSequence.longestArithSeqLength(nums));
    }
}
