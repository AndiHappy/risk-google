package LLittle;

import java.util.Stack;

import util.ListNode;

public class L20 {
    /**
     * 20. 
     * Valid Parentheses Given a string containing just the characters '(', ')',
     * '{', '}', '[' and ']', determine if the input string is valid.
     * 
     * An input string is valid if:
     * 
     * Open brackets must be closed by the same type of brackets. Open brackets must
     * be closed in the correct order. Note that an empty string is also considered
     * valid.
     */
  

    public static void main(String[] args) {
        System.out.println("Hello world , L20");
        System.out.println(L20.isValid(""));
        System.out.println(L20.isValid("{}[]()"));
        System.out.println(L20.isValid("{[]()"));
        System.out.println(L20.isValid("{{}[()]}"));
        System.out.println(L20.isValid("{{}[()]}}"));

    }

    // use stack
    public static boolean isValid(String s) {
        if(s == null || s.length() <=0) return true;
        Stack<Character> contain = new Stack<Character>();
        for(int i = 0; i< s.length() ;i++){
            Character tmp = s.charAt(i);
            if(tmp == '{' || tmp == '[' || tmp == '('){
                contain.push(tmp);
            } 
            if(tmp == '}'){
                if(!contain.isEmpty() && contain.peek() == '{'){
                    contain.pop();
                } else{
                    return false;
                }
            }

            if (tmp == ']') {
                if (!contain.isEmpty() && contain.peek() == '[') {
                    contain.pop();
                } else {
                    return false;
                }
            }
            if (tmp == ')') {
                if (!contain.isEmpty() && contain.peek() == '(') {
                    contain.pop();
                } else {
                    return false;
                }
            }
        }

        return contain.isEmpty();
    }
}

