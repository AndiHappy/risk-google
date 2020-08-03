package LBig;

import java.util.HashMap;

/**
 1032. Stream of Characters

 Implement the StreamChecker class as follows:

 StreamChecker(words): Constructor, init the data structure with the given words.
 query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.


 Example:

 StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
 streamChecker.query('a');          // return false
 streamChecker.query('b');          // return false
 streamChecker.query('c');          // return false
 streamChecker.query('d');          // return true, because 'cd' is in the wordlist
 streamChecker.query('e');          // return false
 streamChecker.query('f');          // return true, because 'f' is in the wordlist
 streamChecker.query('g');          // return false
 streamChecker.query('h');          // return false
 streamChecker.query('i');          // return false
 streamChecker.query('j');          // return false
 streamChecker.query('k');          // return false
 streamChecker.query('l');          // return true, because 'kl' is in the wordlist


 Note:

 1 <= words.length <= 2000
 1 <= words[i].length <= 2000
 Words will only consist of lowercase English letters.
 Queries will only consist of lowercase English letters.
 The number of queries is at most 40000.
 *
 * */
public class L1033 {

    /**
     * 理解题意非常的关键
     * 查找串，来进行分析
     * */


    public static void main(String[] args) {
        StreamChecker test = new StreamChecker(new String[]{"ab","ba","aaab","abab","baa"});
        System.out.println(test.query('a'));
    }



    /**
     * ["StreamChecker","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query"]
     * [[["ab","ba","aaab","abab","baa"]],
     * ["a"],["a"],["a"],["a"],["a"],["b"],["a"],["b"],["a"],["b"],["b"],["b"],["a"],["b"],["a"],["b"],["b"],["b"],["b"],["a"],["b"],["a"],["b"],["a"],["a"],["a"],["b"],["a"],["a"],["a"]]
     * [f  ,  fal,  f,     f,    f,   t  ,  t  ,  t ,    t ,   t ,   f ,false,true,true,true,true,false,false,false,true,true,true,true,true,true,false,true,true,true,false]
     * */
    static class StreamChecker {

         HashMap<Character,String> hashMap = new HashMap<Character, String>();

        public StreamChecker(String[] words) {
            if(words != null && words.length > 0){
                for (String word:words){
                    hashMap.put(word.charAt(word.length()-1),word);
                }
            }

        }

        public  boolean query(char letter) {
            return hashMap.get(letter) != null;
        }
    }

}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * L1033 obj = new L1033(words);
 * boolean param_1 = obj.query(letter);
 */
