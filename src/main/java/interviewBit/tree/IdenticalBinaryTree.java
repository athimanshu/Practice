package interviewBit.tree;

public class IdenticalBinaryTree {
    public int isSameTree(TreeNode A, TreeNode B) {
        return iterate(A,B)?1:0;
    }
    public boolean iterate(TreeNode root1, TreeNode root2){
        if(root1 ==null || root2 == null)
            return root1 == root2;

        if(root1.val != root2.val)
            return false;
        return iterate(root1.left, root2.left) && iterate(root1.right, root2.right);

    }
}
