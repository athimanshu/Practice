package algoexpert.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectCycle {
    public int WHITE = 0; // UNVISITED
    public int GREY = 1; // VISITING
    public int BLACK = 2; // VISITED
    public int solve(int numberOfNodes, ArrayList<ArrayList<Integer>> edges) {

        int[] colors = new int [numberOfNodes];
        Arrays.fill(colors,WHITE);

        for(int node = 0;node<edges.size();node++){
            if(colors[node] != WHITE) continue;

            boolean cycleExist = traverseAndFillColor(node, edges, colors);
            if(cycleExist) return 1;
        }
        return 0;
    }

    public boolean traverseAndFillColor(int node, ArrayList<ArrayList<Integer>> edges,int[] colors ){
        colors[node] = GREY;

//        List<Integer> neighbors = edges.get(node);
        int neighbor = edges.get(node).get(1);
        if(colors[neighbor] == GREY)
            return true;

        boolean cycleExist = traverseAndFillColor(neighbor, edges, colors);
        if(cycleExist) return true;

        colors[node] = BLACK;
        return false;
    }

    public static void main(String[] args) {
        DetectCycle obj = new DetectCycle();
        int a = 2;
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(list1);
        obj.solve(a,list);
    }
}
