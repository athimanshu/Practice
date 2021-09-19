package interviewBit.tree;

import java.util.ArrayList;

//  Definition for binary tree
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

/**
 * Construct Binary Tree From Inorder And Preorder
 */
public class BuildTreeFromPreOrderAndInorder {
    static int pIndex=0;
    public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {

        int len = inorder.size();
        pIndex = 0;
        return createTree(0, len-1, inorder, preorder);
    }

    public TreeNode createTree(int start, int end, ArrayList<Integer> inorder, ArrayList<Integer> preorder){

        if(start > end)
            return null;

        TreeNode node = new TreeNode(preorder.get(pIndex++));
        if(start == end)
            return node;

        int inIndex = search(node.val, inorder, start, end);

        node.left = createTree(start, inIndex-1, inorder, preorder);
        node.right = createTree(inIndex+1, end, inorder, preorder);

        return node;
    }

    public int search(int num, ArrayList<Integer> inorder, int start, int end){
        int i;
        for(i = start; i< end; i++){
            if(inorder.get(i) == num)
                return i;
        }
        return i;
    }
}
