package leetcode.easy;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            System.out.println(i);
            if(map.containsKey(target-nums[i]) && map.get(target-nums[i])!=i){
                System.out.println(i);
                result[0] = i;
                result[1] = map.get(target-nums[i]);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {3,2,4};
        int sum = 6;
        twoSum.twoSum(nums,sum);
    }
}
