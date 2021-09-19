package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 131 Palindrome Partitioning: Given a string s, partition s such that every substring of the partition
 * is a palindrome. Return all possible palindrome partitioning of s. *
 * A palindrome string is a string that reads the same backward as forward.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        s.matches("s");
        List<List<String>> resultList = new ArrayList<>();
        backtracking(resultList, new ArrayList<>(), s,0);
        return resultList;
    }

    private void backtracking(List<List<String>> resultList, ArrayList<String> tempList, String input, int start) {
        if(input.length() == start){
            resultList.add(new ArrayList<>(tempList));
        }else{
            for(int i=start;i<input.length();i++){
                 if(isPalindrome(input,start,i)){
                     tempList.add(input.substring(start,i+1));
                     backtracking(resultList,tempList,input,i+1);
                     tempList.remove(tempList.size()-1);
                 }
            }
        }
    }
    public boolean isPalindrome(String s, int low, int high){
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        palindromePartitioning.partition("aab").stream().forEach(p-> System.out.println(p));
    }

}
