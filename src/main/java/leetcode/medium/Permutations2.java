package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result,nums, new ArrayList<>(),new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> resultList, int[] nums, ArrayList<Integer> tempList, boolean[] used) {
        if(tempList.size() == nums.length){
            resultList.add(new ArrayList<>(tempList));
        }
        else{
        for(int i=0;i<nums.length;i++){
            if(used[i] || (i>0 && nums[i] == nums[i-1] && !used[i-1])){
                continue;
            }

            used[i] = true;
            tempList.add(nums[i]);
            backtrack(resultList,nums,tempList,used);
            used[i] = false;
            tempList.remove(tempList.size()-1);
        }
        }
    }

    public static void main(String[] args) {
        Permutations2 permutations2 = new Permutations2();
        int[] nums = {2,1,2};
        permutations2.permute(nums).stream().forEach(p-> System.out.println(p));
    }

}
