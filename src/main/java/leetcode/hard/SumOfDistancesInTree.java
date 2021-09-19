package leetcode.hard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Stream;

/**
 * Hard: 834. Sum of Distances in Tree
 * Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 * Output: [8,12,6,10,10,10]
 * Explanation:
 * Here is a diagram of the given tree:
 *   0
 *  / \
 * 1   2
 *    /|\
 *   3 4 5
 * We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 * equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on
 */
public class SumOfDistancesInTree {
    int[] res, count;
    ArrayList<HashSet<Integer>> tree;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<HashSet<Integer>>();
        res = new int[N];
        count = new int[N];
        for (int i = 0; i < N ; ++i)
            tree.add(new HashSet<Integer>());
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return res;
    }

    public void dfs(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) continue;
            dfs(i, root);
            count[root] += count[i];
            res[root] += res[i] + count[i];
        }
        count[root]++;
    }


    public void dfs2(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) continue;
            res[i] = res[root] - count[i] + count.length - count[i];
            dfs2(i, root);
        }
    }

    public static void main(String[] args) {
        SumOfDistancesInTree sumOfDistancesInTree = new SumOfDistancesInTree();
        int node = 6;
        int[][] arr ={{0,1},{0,2},{2,3},{2,4},{2,5}};
        int[] result = sumOfDistancesInTree.sumOfDistancesInTree(node,arr);
//        System.out.println(result);
        Stream.of(result).forEach(p-> System.out.println(p));

    }
}
