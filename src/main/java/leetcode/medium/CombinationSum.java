package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39 CombinationSum: Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any orde
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(resultList,candidates,target,new ArrayList<>(),0);
        return resultList;
    }

    private void backtrack(List<List<Integer>> resultList, int[] nums, int remainder, ArrayList<Integer> tempList, int start) {
        if(remainder < 0) return;
        else if(remainder == 0) resultList.add(new ArrayList<>(tempList));

        else{
            for (int i=start;i<nums.length;i++){
                tempList.add(nums[i]);
                backtrack(resultList,nums,remainder-nums[i],tempList,i);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    /**Alternate solution
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSumAlternate(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList();

        Arrays.sort(candidates);

        combinationSum(candidates, 0, target, new ArrayList<Integer>(), result );
        return result;
    }

    private void combinationSum(int[] candidates, int index, int target, List<Integer> currentList,List<List<Integer>> result ) {


        if(target>0){
            for(int i=index;i<candidates.length && target >=candidates[i];i++){
                currentList.add(candidates[i]);
                combinationSum(candidates, i,target-candidates[i],currentList,result);
                currentList.remove(currentList.size()-1);
            }

        }
        else if(target == 0){
            result.add(new ArrayList(currentList));
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] arr = {2,3,5,7};
        int target = 7;
        combinationSum.combinationSum(arr,target).stream().forEach(p-> System.out.println(p));
    }
}
