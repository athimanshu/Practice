package interviewBit.tree;

import leetcode.medium.Triangle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find the shortest unique prefix for every word in an array
 * Input:  [AND, BOOL, BONFIRE, CATCH, CASE, CHAR]
 * Output: [A, BON, BOO, CAS, CAT, CH]
 * Source: https://www.techiedelight.com/shortest-unique-prefix/
 */
class TrieNode{
    Map<Character, TrieNode> child = new HashMap<>();
    int freq = 0;
}
public class ShortestUniquePrefix {
    public static ArrayList<String> findShortestPrefix(String[] words)
    {
        ArrayList<String> result = new ArrayList<>();
        TrieNode trieNode = new TrieNode();
        for(int i=0;i<words.length;i++){
            insert(words[i],trieNode);
        }
        printShortestPrefix(trieNode,"",result);
        return result;
    }
    private static void insert(String word, TrieNode root){
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            current.child.putIfAbsent(word.charAt(i),new TrieNode());
            current.child.get(word.charAt(i)).freq++;
            current = current.child.get(word.charAt(i));
        }
    }
    private static void printShortestPrefix(TrieNode root, String wordSoFar, ArrayList<String> result) {
        if(root == null){
            return;
        }
        if(root.freq == 1){
            result.add(wordSoFar);
//            return;
        }
        for (Map.Entry<Character, TrieNode> child: root.child.entrySet()) {
            printShortestPrefix(child.getValue(), wordSoFar + child.getKey(),result);
        }
    }

    public static void main(String[] args) {
        String[] words = { "AND", "BOOL", "BONFIRE", "CATCH", "CASE", "CHAR" };
        List<String> output = findShortestPrefix(words);
        output.stream().forEach(p-> System.out.println(p));
    }
}
//Interview Bit Solution
//public class Solution {
//
//    private class TrieNode {
//        //char ch;
//        String str;
//        TreeMap<Character, TrieNode> map;
//
//        public TrieNode(String str){
//            this.str = str;
//            map = new TreeMap<>();
//        }
//
//    }
//
//    public void addToTrie(String str, TrieNode trie){
//        if(str == ""){
//            return;
//        }
//
//        int i=0;
//        char ch = str.charAt(i);
//        i++;
//        String str2 = "";
//        if(i<str.length())
//            str2 = str.substring(i, str.length());
//
//        if(trie.map.containsKey(ch)){
//            TrieNode nextNode = trie.map.get(ch);
//
//            String str1 = nextNode.str;
//            // if node string is empty
//            if(str1.equals("")){
//                addToTrie(str2, nextNode);
//            } else {
//                nextNode.str = "";// make the string empty
//
//                int x=0, y=0;
//                //compare the string
//                while(x<str1.length() && y<str2.length() &&
//                        str1.charAt(x) == str2.charAt(y)){
//                    char ch1 = str1.charAt(x);
//
//                    TrieNode node = new TrieNode("");
//                    nextNode.map.put(ch1, node);
//                    nextNode = node;
//                    x++; y++;
//                }
//                if(x < str1.length() && y < str2.length()){
//                    char ch1 = str1.charAt(x);
//                    char ch2 = str2.charAt(y);
//                    //System.out.println(">"+ch1+":"+ch2);
//                    x++; y++;
//                    TrieNode node1, node2;
//                    if(x!=str1.length())
//                        node1 = new TrieNode( str1.substring(x, str1.length()));
//                    else
//                        node1 = new TrieNode("");
//
//                    if(y!=str2.length())
//                        node2 = new TrieNode( str2.substring(y, str2.length()));
//                    else
//                        node2 = new TrieNode("");
//                    //System.out.println(nextNode.str+"#"+node1.str+":"+node2.str);
//                    nextNode.map.put(ch1, node1);
//                    nextNode.map.put(ch2, node2);
//                }
//                //<-----else----->
//
//            }
//
//        } else {
//            TrieNode node = new TrieNode(str2);
//            trie.map.put(ch, node);
//        }
//    }
//
//    ArrayList<String> ans;
//    /*void readTrie(TrieNode node, String str){
//
//        TreeMap<Character, TrieNode> map = node.map;
//
//        if(map.isEmpty()){
//            ans.add(str);
//            return;
//        }
//
//        for(Map.Entry<Character, TrieNode> entry:map.entrySet()){
//        	Character ch=entry.getKey();
//	        TrieNode tnode=entry.getValue();
//
//        	str = str.concat(""+ch);
//        	readTrie(tnode, str);
//        	str = str.substring(0, str.length()-1);
//	  }
//
//
//    }*/
//
//    String readTrie(TrieNode node, String str){
//        TreeMap<Character, TrieNode> map = node.map;
//        int i=0;
//        String ans = "";
//        //System.out.println(">>"+str);
//        while(i<str.length()){
//            char ch = str.charAt(i);
//            if(map.containsKey(ch)){
//                ans = ans.concat(""+ch);
//                // System.out.println("--"+ans);
//                node = map.get(ch);
//                map = node.map;
//            } else {
//                break;
//            }
//            i++;
//        }
//        return ans;
//    }
//
//    public ArrayList<String> prefix(ArrayList<String> a) {
//        ans = new ArrayList<String>();
//
//        TrieNode trie = new TrieNode("");
//
//        for(String str : a){
//            addToTrie(str, trie);
//        }
//        // <----read trie-->
//        for(String str : a){
//            ans.add(readTrie(trie, str));
//        }
//        return ans;
//    }
//}
