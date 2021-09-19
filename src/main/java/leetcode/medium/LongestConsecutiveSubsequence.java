package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSubsequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length <1){
            return 0;
        }
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])) continue;
            int num = nums[i];
            int count = 1;
            int left = map.getOrDefault(num-1,0);
            int right = map.getOrDefault(num+1,0);
            count +=left+right;
            if(count > result){
                result = count;
            }
            //Below two line wont do anything if there are no neighbour.
            // As it would be just updating the current number in map as left = 0 || rightt = 0
            map.put(num-left,count);
            map.put(num+right,count);

            map.put(num,count);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {0,103,7,102,1055,8,104,6,0,101};
        LongestConsecutiveSubsequence lcs = new LongestConsecutiveSubsequence();
        System.out.println(lcs.longestConsecutive(num));
    }
}
