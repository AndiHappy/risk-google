/**
 * 14. Longest Common Prefix Easy
 * 
 * Share Write a function to find the longest common prefix string amongst an
 * array of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * Input: ["flower","flow","flight"] Output: "fl" Example 2:
 * 
 * Input: ["dog","racecar","car"] Output: "" Explanation: There is no common
 * prefix among the input strings. Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 */



public class L14 {

    public static void main(String[] args) {
        assert "dd".equals("dd");
        assert L14.longestCommonPrefix(new String[] {}).equals("");
        assert L14.longestCommonPrefix(new String[] { "abcde"}).equals("abcde");
        assert L14.longestCommonPrefix(new String[] { "abcde", "abcded" }).equals("abcde");

        // Assert.assertEquals();
        // Assert.assertEquals(L14.longestCommonPrefix(new String[]{}), "");
        // Assert.assertEquals(L14.longestCommonPrefix(new String[]{"abcde"}), "abcde");
        // Assert.assertEquals(L14.longestCommonPrefix(new String[]{"abcde","abcded"}), "abcde");

    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length==0) return "";
        if(strs.length == 1) return strs[0];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs[0].toCharArray().length;i++) {
            Character indexchar = strs[0].toCharArray()[i];
            boolean equal = true;
            for(int j=1;j < strs.length;j++){
                equal = equal && i < strs[j].length() && strs[j].charAt(i) == indexchar;
                if(!equal) break;
            }
            if(equal){
                result.append(indexchar);
            }else{
                break;
            }
        }
        
        return result.toString();
    }

}