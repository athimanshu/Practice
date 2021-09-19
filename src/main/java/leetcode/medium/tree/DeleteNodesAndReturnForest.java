package leetcode.medium.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Medium 1110. Delete Nodes And Return Forest
 */
public class DeleteNodesAndReturnForest {
    Set<Integer> toDelete;
    List<TreeNode> result = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] toDeleteArr) {

        if(root == null) return result;
        toDelete = new HashSet<>();
        for(int i=0;i<toDeleteArr.length;i++)
            toDelete.add(toDeleteArr[i]);
        helper(root,true);
        return result;
    }
    private TreeNode helper(TreeNode root, Boolean isRoot){
        if(root == null) return null;
        boolean isDeleted = toDelete.contains(root.val);
        if(isRoot && !isDeleted) result.add(root);
        root.left = helper(root.left,isDeleted);
        root.right = helper(root.right,isDeleted);
        return isDeleted? null : root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int[] toDelete = {3,5};
        System.out.println(new DeleteNodesAndReturnForest().delNodes(root,toDelete));
    }
}
