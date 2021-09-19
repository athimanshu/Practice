package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 98 Validate Binary Search Tree
 */
public class ValidatingBST {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        traverse(root,list);
        return validate(list);

    }
    public void traverse(TreeNode root, List<Integer> list){

        if(root == null){
            return;
        }
        traverse(root.left,list);
        list.add(root.val);
        traverse(root.right,list);
    }
    public boolean validate(List<Integer> list){

        for(int i =0; i<list.size()-1;i++){
            if(list.get(i)>=list.get(i+1))
                return false;
        }
        return true;

    }
}
