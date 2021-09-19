package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result,new ArrayList(),nums,0);
        return result;
    }
    private void backtrack(List<List<Integer>> resultList, List<Integer> tempList, int[] nums, int start){

        resultList.add(new ArrayList(tempList));
        for(int i= start;i<nums.length;i++){

            if(i>start && nums[i] == nums[i-1]) continue;

            tempList.add(nums[i]);
            backtrack(resultList, tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        Subset2 subset2 = new Subset2();
        int[] nums= {1,2,3,3,3,2,2,4,6};
        List<List<Integer>> result = subset2.subsetsWithDup(nums);
        result.stream().forEach(p-> System.out.println(p));
    }
}
