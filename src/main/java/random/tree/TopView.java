package random.tree;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

/**
 * Top view of a tree
 * https://www.youtube.com/watch?v=5avJ5Joqyw0&ab_channel=codeExplainer
 */
public class TopView {

	/*

    class Node
    	int data;
    	Node left;
    	Node right;
	*/

    static Map<Node,Integer> distMap = new HashMap<>();
    private static void updateHDistance(Node node, Integer dist) {

        if(node.left !=null){
            distMap.put(node.left,dist-1);
            updateHDistance(node.left,dist-1);
        }
        if(node.right !=null){
            distMap.put(node.right,dist+1);
            updateHDistance(node.right,dist+1);
        }
        return;
    }

    public static void topView(Node root){
        List<Integer> list = new ArrayList<>();
        distMap.put(root,0);
        updateHDistance(root, 0);

        Map<Integer,Integer> viewMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        viewMap.put(0, root.data);
        queue.add(root);
        while (!queue.isEmpty()){
            Node curr = queue.poll();

            if(curr.left != null){
                int k = distMap.get(curr.left);
                if(!viewMap.containsKey(k)){
                    //System.out.println(curr.left.data);
                    viewMap.put(k,curr.left.data);
                }
                queue.add(curr.left);
            }

            if(curr.right != null) {
                int k = distMap.get(curr.right);
                if(!viewMap.containsKey(k)){
                    viewMap.put(k,curr.right.data);
                }
                queue.add(curr.right);
            }

        }
        for (Map.Entry<Integer,Integer> map: viewMap.entrySet()){
            list.add(map.getKey());
        }
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            System.out.print(viewMap.get(list.get(i)) +" ");
        }
    }


    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }
}
/**
 * 13 4 105 3 278 2 372 1 377 17 393 409 416 418
 * 17 1 2 3 4 13 105 278 372 377 393 409 416 418
 */
