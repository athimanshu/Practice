package leetcode.medium.tree;

import java.util.Stack;

class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode curr = root;
        while(curr !=null){
            stack.push(curr);
            if(curr.left != null)
                curr = curr.left;
            else
                break;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        TreeNode curr = node;
        if(curr.right !=null){
            curr = curr.right;
            while(curr !=null) {
                stack.push(curr);
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    break;
                }
            }
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
