
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.ListNode;

public class L22 {
    /**
     * 22. Generate Parentheses
     * 
     * Given n pairs of parentheses, write a function to generate all combinations
     * of well-formed parentheses.
     * 
     * For example, given n = 3, a solution set is:
     * 
     * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
     */
  

    public static void main(String[] args) {
        System.out.println("Hello world , L22");
    }

    /**
     * Backtracking
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if(n <=0 ) return result;
        if(n == 1){
            result.add("()");
            return result;
        } 

        if (n == 2) {
            result.add("()()");
            result.add("(())");
            return result;
        }

        return result;

    }
}

