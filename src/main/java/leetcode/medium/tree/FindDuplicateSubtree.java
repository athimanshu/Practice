package leetcode.medium.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtree {
    int currId = 1;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String,Integer> serialToId = new HashMap<>();
        Map<Integer,Integer> idToCount = new HashMap<>();
        postOrder(root,serialToId,idToCount,result);
        return result;
    }

    private int postOrder(TreeNode root, Map<String, Integer> serialToId, Map<Integer, Integer> idToCount, List<TreeNode> result) {
      if(root == null) return 0;
      int leftId = postOrder(root.left,serialToId,idToCount,result);
      int rightId = postOrder(root.right,serialToId,idToCount,result);
      String currSerial = leftId + "," + root.val + "," + rightId;
      int serialId = serialToId.getOrDefault(currSerial,currId);
      serialToId.put(currSerial,serialId);
      if(serialId == currId) currId++;
      idToCount.put(serialId,idToCount.getOrDefault(serialId,0)+1);
      if(idToCount.get(serialId) == 2) result.add(root);
      return serialId;
    }
}
/**
 * Definition for a binary tree node.*/
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
