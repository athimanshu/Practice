package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 78 Subsets: Given an integer array nums of unique elements, return all possible subsets (the power set). *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1,2,3,4,5};
        List<List<Integer>> result = subsets.subsets(nums);

        result.stream().forEach(p-> System.out.println(p));

    }
}
