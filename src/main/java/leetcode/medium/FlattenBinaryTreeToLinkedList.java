package leetcode.medium;

import java.util.List;

/**
 * 114. Flatten Binary Tree to Linked List
 */
public class FlattenBinaryTreeToLinkedList {
    TreeNode prev = null;
    public void flatten(TreeNode root){
        if(root == null){
            return;
        }
        flatten(root.right);
        flatten(root.left);

        root.left = null;
        root.right = prev;
        prev = root;
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.right = new TreeNode(6);

        FlattenBinaryTreeToLinkedList obj = new FlattenBinaryTreeToLinkedList();
        obj.flatten(node);
    }
}
