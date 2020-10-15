package LLittle;

import java.util.ArrayList;
import java.util.List;

public class L17 {
    /**
     * 17. Letter Combinations of a Phone Number Medium
     * 
     * Share Given a string containing digits from 2-9 inclusive, return all
     * possible letter combinations that the number could represent.
     * 
     * A mapping of digit to letters (just like on the telephone buttons) is given
     * below. Note that 1 does not map to any letters.
     * 
     * 0 ==> ""
     * 1 ==> ""
     * 2 ==> "abc"
     * 3 ==> "def"
     * 4 ==> "ghi"
     * 5 ==> "jkl"
     * 6 ==> "mon"
     * 7 ==> "pqrs"
     * 7 ==> "tuv"
     * 9 ==> "wxyz"
     * Example:
     * 
     * Input: "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * Note:
     * 
     * Although the above answer is in lexicographical order, your answer could be
     * in any order you want.
     */
  
    public static String[] index2char = new String[]{"","","abc","def","ghi","lkj","mno","pqrs","tuv","wxyz"};


    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(L17.letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> charString = new ArrayList<String>();
        List<String> result = new ArrayList<String>();
        for(int i = 0 ; i < digits.length() ; i++){
            int index = digits.charAt(i)-'0';
            String v = index2char[index];
            if(!v.equals(""))charString.add(v);
        }
        result = letterCombinations(charString,result);
        return result;

    }

    private static List<String> letterCombinations(List<String> charString,List<String> result) {
        // charString = {"abc","defg"}
        for(int i = 0;i<charString.size();i++){
            String value = charString.get(i);
            if(result.isEmpty() && value.length() >0){
                for (Character c : value.toCharArray()) {
                     result.add(String.valueOf(c));
                }
            }else{
                List<String> newturn = new ArrayList<String>();
                for (String oldString : result) {
                    for (Character c : value.toCharArray()) {
                        newturn.add(oldString+String.valueOf(c));
                    }
                }
                result = newturn;
            }
        }
        
        return result;
    }
}

