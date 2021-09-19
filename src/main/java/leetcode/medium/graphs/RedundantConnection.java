package leetcode.medium.graphs;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {

        DisjointSet disjointSet = new DisjointSet(edges.length+1);
        for(int[] edge: edges){
            if(!disjointSet.union(edge[0],edge[1])) return edge;
        }
        return new int[0];
    }

    static class DisjointSet {
        private int[] parent;
        private byte[] rank;

        public DisjointSet(int n) {
            if (n<0) throw new IllegalArgumentException();
            parent = new int[n];
            rank = new byte[n];
        }

        public int find(int x) {
            if(parent[x] == 0) return x;
            return parent[x] = find(parent[x]); //Path Compression
        }

        // Return false if x, y are connected.
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY)
                return false;

            if(rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            }
            else if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            }
            else{
                parent[rootX] = rootY;
                rank[rootY]++;
            }
            return true;
        }
    }
}
