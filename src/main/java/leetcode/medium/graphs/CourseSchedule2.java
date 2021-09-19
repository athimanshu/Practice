package leetcode.medium.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Ref: https://leetcode.com/problems/course-schedule-ii/discuss/59317/Two-AC-solution-in-Java-using-BFS-and-DFS-with-explanation
 */

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incomingLinkCounts = new int[numCourses];
        List<List<Integer>> adjacents = new ArrayList<>(numCourses);
        initializeGraph(incomingLinkCounts,adjacents,prerequisites);
        return solveByBfs(incomingLinkCounts,adjacents);
    }

    /**
     * We observe that if a node has incoming edges, it has prerequisites. Therefore, the first few in the order must be those with no prerequisites, i.e. no incoming edges. Any non-empty DAG must have at least one node without incoming links.
     * You can draw a small graph to convince yourself. If we visit these few and remove all edges attached to them, we are left with a smaller DAG(Directed acyclic graph),
     * which is the same problem. This will then give our BFS solution.
     * @param incomingLinkCounts
     * @param adjacents
     * @return
     */
    private int[] solveByBfs(int[] incomingLinkCounts, List<List<Integer>> adjacents) {
        int[] order = new int[incomingLinkCounts.length];
        Queue<Integer> toVisit = new ArrayDeque<>();
        for(int i=0;i<incomingLinkCounts.length;i++){
            if(incomingLinkCounts[i] == 0)
                toVisit.offer(i);
        }
        int visited = 0;
        while (!toVisit.isEmpty()){
            int from = toVisit.poll();
            order[visited++] = from;
            for(int to: adjacents.get(from)){
                incomingLinkCounts[to]--;
                if(incomingLinkCounts[to] == 0) toVisit.offer(to);
            }
        }
        return visited == incomingLinkCounts.length?order:new int[0];

    }

    private void initializeGraph(int[] incomingLinkCounts, List<List<Integer>> adjacents, int[][] prerequisites) {
        int n = incomingLinkCounts.length;
        while (n-- >0) adjacents.add(new ArrayList<>());
        for(int[] edge: prerequisites){
            incomingLinkCounts[edge[0]]++;
            adjacents.get(edge[1]).add(edge[0]); // Creating Adjacency list graph data structure. 1 -> 2 means 1 must be taken before 2.

        }
    }
    public static void main(String[] args) {
        int[][] pre = {{1,0},{2,0},{4,3},{3,5},{1,3}};
        CourseSchedule2 cs = new CourseSchedule2();
        System.out.println(cs.findOrder(6,pre));
    }
}
