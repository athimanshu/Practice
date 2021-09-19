package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40 Combination Sum 2: Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 */

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(resultList,nums,target, new ArrayList<>(), 0);
        return resultList;
    }

    private void backtrack(List<List<Integer>> resultList, int[] nums, int target, ArrayList<Integer> tempList, int start) {
        if(target<0) return;
        else if(target == 0) resultList.add(new ArrayList<>(tempList));

        else{
            for(int i = start; i<nums.length;i++){
                if(i > start && nums[i] == nums[i-1]) continue;
                tempList.add(nums[i]);
                backtrack(resultList,nums,target-nums[i],tempList,i+1);
                tempList.remove(tempList.size()-1);
            }
        }

    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum = new CombinationSum2();
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        combinationSum.combinationSum2(arr,target).stream().forEach(p-> System.out.println(p));

    }
}
