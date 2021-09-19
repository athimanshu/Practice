package algoexpert.graph;

import java.util.*;

public class BoggleBoard {

    public static List<String> boggleBoard(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word: words){
            trie.add(word);
        }
        Set<String> finalWords = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                explore(i,j,board,trie.root,visited,finalWords);
            }
        }
        List<String> finalWordsList = new ArrayList<>();
        finalWordsList.addAll(finalWords);
        return finalWordsList;
    }

    private static void explore(int i, int j, char[][] board, TrieNode trieNode, boolean[][] visited, Set<String> finalWords) {
        if(visited[i][j]){
            return;
        }
        char letter = board[i][j];
        if(!trieNode.children.containsKey(letter)){
            return;
        }
        visited[i][j] = true;
        trieNode = trieNode.children.get(letter);
        if(trieNode.children.containsKey('*')){
            finalWords.add(trieNode.word);
        }
        List<Integer[]> neighbours = getNeighbours(i,j,board);
        for(Integer[] neighbour: neighbours){
            explore(neighbour[0],neighbour[1],board, trieNode, visited, finalWords);
        }
        visited[i][j] = false;
    }

    private static List<Integer[]> getNeighbours(int i, int j, char[][] board) {
        List<Integer[]> neighbors = new ArrayList<Integer[]>();

        if (i > 0 && j > 0) {
            neighbors.add(new Integer[]{i - 1, j - 1});
        }
        if (i > 0 && j < board[0].length - 1) {
            neighbors.add(new Integer[]{i - 1, j + 1});
        }
        if (i < board.length - 1 && j < board[0].length - 1) {
            neighbors.add(new Integer[]{i + 1, j + 1});
        }
        if (i < board.length - 1 && j > 0) {
            neighbors.add(new Integer[]{i + 1, j - 1});
        }
        if (i > 0) {
            neighbors.add(new Integer[]{i - 1, j});
        }
        if (i< board.length-1) {
            neighbors.add(new Integer[]{i+1,j});
        }
        if(j>0){
            neighbors.add(new Integer[]{i,j-1});
        }
        if(j< board[0].length-1){
            neighbors.add(new Integer[]{i,j+1});
        }
        return neighbors;
    }

    static class TrieNode{
        Map<Character,TrieNode> children = new HashMap<>();
        String word;
    }
    static class Trie{
        TrieNode root;
        char endChar;

        Trie(){
            this.root = new TrieNode();
            this.endChar = '*';
        }
        public void add (String s){
            TrieNode node = this.root;
            for(int i=0;i<s.length();i++){
                char letter = s.charAt(i);
                if(!node.children.containsKey(letter)){
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter,newNode);
                }
                node = node.children.get(letter);
            }
            node.children.put(this.endChar,null);
            node.word = s;
        }
    }
}
