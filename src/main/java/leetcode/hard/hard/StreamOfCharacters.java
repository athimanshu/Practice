package leetcode.hard.hard;

/**
 * Hard: 1032. Stream of Characters
 * Implement the StreamChecker class as follows:
 *
 * StreamChecker(words): Constructor, init the data structure with the given words.
 * query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest,
 * including this letter just queried) spell one of the words in the given list.
 */
class StreamChecker {
    class TrieNode{
        boolean isWord;
        TrieNode[] next = new TrieNode[26];
    }
    TrieNode root = new TrieNode();
    StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        createTrie(words);
    }
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode node = root;
        for(int i = sb.length()-1;i>=0 && node!=null;i--){
            char c = sb.charAt(i);
            node = node.next[c-'a'];
            if(node!=null && node.isWord){
                return true;
            }
        }
        return false;
    }
    private void createTrie(String[] words) {
        for(String s: words){
            TrieNode node = root;
            int len = s.length();
            for(int i =len-1;i>=0;i--){
                char c = s.charAt(i);
                if(node.next[c - 'a'] == null){
                    node.next[c-'a'] = new TrieNode();
                }
                node = node.next[c-'a'];
            }
            node.isWord = true;
        }
    }
}
