package interviewBit.tree;

public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {

        return findSum(root,0);
    }
    public int findSum(TreeNode node, int currentSum){
        if(node==null)
            return 0;
        currentSum = currentSum*10 + node.val;
        if(node.left ==null && node.right == null)
            return currentSum;

        int leftSum = findSum(node.left,currentSum);
        int rightSum = findSum(node.right,currentSum);
        return leftSum + rightSum;

    }
}
