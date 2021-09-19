package company.airbnb;

import java.util.*;

public class Solution2 {


}

class Result {

    /*
     * Complete the 'findRoot' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY nodes as parameter.
     */

    public static int findRoot(List<List<Integer>> nodes) {
        Map<Integer,BSTNode> bstMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer,Boolean> isChild = new HashMap<>();
        for(List<Integer> list: nodes){
            BSTNode left = null;
            BSTNode right = null;
            set.add(list.get(0));
            set.add(list.get(1));
            set.add(list.get(2));
            if(isChild.containsKey(list.get(1)) && isChild.get(list.get(1)) && list.get(1) != -1){
                return -1;
            }else{
                isChild.put(list.get(1),true);
            }

            if(isChild.containsKey(list.get(2)) && isChild.get(list.get(2)) && list.get(2) != -1){
                return -1;
            }else{
                isChild.put(list.get(2),true);
            }
            if(list.get(1) != -1){
                if(bstMap.containsKey(list.get(1))){
                    left = bstMap.get(list.get(1));
                }else{
                    left = new BSTNode(list.get(1), null, null);
                }
            }
            if(list.get(2) != -1){
                if(bstMap.containsKey(list.get(2))){
                    right = bstMap.get(list.get(2));
                }else{
                    right = new BSTNode(list.get(2), null, null);
                }
            }

            BSTNode node = new BSTNode(list.get(0), left, right);
            bstMap.put(list.get(0), node);
        }
        boolean checkAllnodeExist = checkIfAllNodes(bstMap,set);
        if(!checkAllnodeExist){
            return -1;
        }
        return 1;
    }
    private static boolean checkIfAllNodes(Map<Integer,BSTNode> map,Set<Integer> set){

        for(Integer i: set){
            System.out.println(i);
            if(!map.containsKey(i)){
                return false;
            }
        }
        return true;
    }
}
class BSTNode {
    public int value;
    public BSTNode left;
    public BSTNode right;

    public BSTNode(int value, BSTNode left, BSTNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

