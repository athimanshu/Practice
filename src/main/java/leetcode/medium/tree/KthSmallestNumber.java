package leetcode.medium.tree;

import java.util.Stack;

public class KthSmallestNumber {
    public int kthsmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode n = root;
        while(n != null){
            stack.push(n);
            n = n.left;
        }

        while(!stack.isEmpty()){
            n = stack.pop();
            k--;
            if(k == 0){
                return n.val;
            }
            if(n.right != null){
                n = n.right;
                while(n != null){
                    stack.push(n);
                    n = n.left;
                }
            }

        }
        return -1;
    }
}
