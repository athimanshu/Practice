package random;

import java.util.*;


public class LCA {
    static int counter  =0;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        System.out.println("Root: "+ (root!=null ? root.val: "N" )+ "\t P: "+ (p!=null ? p.val: "N" )+
                "\t Q: "+(q!=null ? q.val: "N"));
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
       // System.out.println("Left "+left.val);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
      //  System.out.println("Right "+right.val);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }

    public static void inOrderTraversal(TreeNode node){
        System.out.println(counter++);
        if(node==null) return;
        inOrderTraversal(node.left);
        System.out.println(node.val);
        inOrderTraversal(node.right);

    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(6);
        node.left = new TreeNode(2);
        node.right = new TreeNode(8);

        node.left.left= new TreeNode(0);
        node.left.right=new TreeNode(4);

        node.left.right.left = new TreeNode(3);
        node.left.right.right = new TreeNode(5);

        node.right.left = new TreeNode(7);
        node.right.right = new TreeNode(9);


      //  TreeNode lca = lowestCommonAncestor(node,node.left.left,node.left.right.right);
      //  System.out.println(lca.val);
        LCA.inOrderTraversal(node);
    }
    public int solution(String s) {
        // write your code in Java SE 8
        Map<Character, Integer> map = new HashMap<>();
        int result=0;

        for(Character c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Integer> mapList = new ArrayList<>(map.values());
        Set<Integer> valSet = new HashSet<>();

        //Iterating over the list
        for(Integer count: mapList){
            while(count!=0){
                if(valSet.contains(count)){
                    count--;
                    result++;
                }else{
                    valSet.add(count);
                    break;
                }
            }
        }
        return result;
    }

    //Problem 3
    public int solution(int[] a) {
        int minimumSum = Integer.MAX_VALUE;
        int element1 = Integer.MAX_VALUE;
        int element2 = Integer.MAX_VALUE;

        int minElement = a[1];
        int prevElement = a[2];

        for (int index = 3; index + 1 < a.length; index++) {
            int sum = minElement + a[index];
            if (sum < minimumSum) {
                minimumSum = sum;
                element1 = minElement;
                element2 = a[index];
            }

            if (prevElement < minElement) {
                minElement = prevElement;
            }
            prevElement = a[index];
        }

        return element1 + element2;
    }
}
