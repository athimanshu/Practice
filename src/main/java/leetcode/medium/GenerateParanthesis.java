package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 */

public class GenerateParanthesis {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtracking(list,"",0,0,n);
        return list;
    }

    private void backtracking(List<String> list, String s, int open, int close, int n) {

        if(s.length() == 2*n){
            list.add(s);
            return;
        }
        if(open<n){
            backtracking(list,s+"(",open+1,close,n);
        }
        if(close<open){
            backtracking(list,s+")",open,close+1,n);
        }
    }

    public static void main(String[] args) {
        GenerateParanthesis gp = new GenerateParanthesis();
        List<String> result = gp.generateParenthesis(3);
        for(String s: result){
            System.out.println(result);
        }

    }
}
