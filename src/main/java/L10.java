/**

 10. Regular Expression Matching

 Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.
 The matching should cover the entire input string (not partial).

 Note:

 s could be empty and contains only lowercase letters a-z.
 p could be empty and contains only lowercase letters a-z, and characters like . or *.
 Example 1:

 Input:
 s = "aa"
 p = "a"
 Output: false
 Explanation: "a" does not match the entire string "aa".
 Example 2:

 Input:
 s = "aa"
 p = "a*"
 Output: true
 Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 Example 3:

 Input:
 s = "ab"
 p = ".*"
 Output: true
 Explanation: ".*" means "zero or more (*) of any character (.)".
 Example 4:

 Input:
 s = "aab"
 p = "c*a*b"
 Output: true
 Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 Example 5:

 Input:
 s = "mississippi"
 p = "mis*is*p*."
 Output: false

 * */
public class L10 {

    public static void main(String[] args) {
        L10 test = new L10();
        boolean result = test.isMatch("aa","a");
        System.out.println(result);

        result = test.isMatch("mississippi","mis*is*p*.");
        System.out.println(result);


    }

    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        // init dp dp[i][0] = false
        // dp[0][j] meet condition j=*
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }

        for(int i =1 ; i< dp.length; i++){
            for (int j = 1; j< dp[0].length ; j++){
                // first situaition: char s[i] = p[j]|'.'
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    dp[i][j]=dp[i-1][j-1];
                }
                // second situaition
                if(p.charAt(j-1) == '*'){
                    //here are two sub conditions:
//                   1. p.charAt(j-1) != s.charAt(i)
                    if(s.charAt(i-1) != p.charAt(j-2) && p.charAt(j-2) != '.'){
                        dp[i][j]=dp[i][j-2];
                    }else{
                        //if p.charAt(j-1) == s.charAt(i) or p.charAt(j-1) == '.':
                        //                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
                        //                           or dp[i][j] = dp[i-1][j-2]   // in this case, a* counts as single a
                        //                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
                        dp[i][j] = dp[i][j-2]|| dp[i-1][j-2]||dp[i-1][j];
                    }
                                   }
            }
        }
        return dp[s.length()][p.length()];
    }

}
