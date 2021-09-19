package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 315. Count of Smaller Numbers After Self
 * This is algoexpert solution but Time limit exceeds in this case
 */
public class CountSmallerNumberAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<Integer>(nums.length);
        for(int i: nums){
            result.add(i);

        }
        if(nums.length == 0){
            return result;
        }
        int lastIdx = nums.length-1;
        result.set(lastIdx,0);
        SpecialBST bst = new SpecialBST(nums[lastIdx]);
        for(int i=lastIdx-1;i>=0;i--){
            bst.insert(nums[i],i, result);
        }
        return result;
    }
}

class SpecialBST{
    public int val;
    public int leftSubtreeSize;
    public SpecialBST left;
    public SpecialBST right;

    public SpecialBST(int val){
        this.val = val;
        leftSubtreeSize = 0;
        left = null;
        right = null;
    }

    public void insert(int val, int idx, List<Integer>  result){
        insertHelper(val,idx, result,0);
    }

    public void insertHelper(int val, int idx, List<Integer>  result, int numSmallerAtInsert){

        if(val<this.val){
            leftSubtreeSize++;
            if(left == null){
                left = new SpecialBST(val);
                result.set(idx,numSmallerAtInsert);
            }else{
                left.insertHelper(val,idx,result,numSmallerAtInsert);
            }
        }else{
            numSmallerAtInsert += leftSubtreeSize;
            if(val>this.val){
                numSmallerAtInsert++;
            }
            if(right == null){
                right = new SpecialBST(val);
                result.set(idx,numSmallerAtInsert);
            }else{
                right.insertHelper(val,idx,result,numSmallerAtInsert);
            }
        }
    }
}