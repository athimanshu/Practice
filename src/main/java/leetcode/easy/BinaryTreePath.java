package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 */

public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        findPath(root,result,sb);
        return result;
    }
    public void findPath(TreeNode node, List<String> result, StringBuilder path){

        if(node == null){
            result.add(path.toString().substring(0,path.toString().length()-2));
            path.setLength(0);
            return;
        }
        path.append(node.val).append("->");
        findPath(node.left,result,path);
        findPath(node.right,result,path);

    }
}
