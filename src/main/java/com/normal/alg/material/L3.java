package com.normal.alg.material;

import java.util.HashMap;
import java.util.Map;

public class L3 {
    public static void main(String[] args) {

    }

    // slid window
    //Longest Substring Without Repeating Characters
    public static int lengthOfLongestSubstring(String s) {
        int result = 0; // result of the problem
        int from=0,end=0; // from index，toindex
        Map<Character,Integer> window = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char chari = s.charAt(i);
            if(window.containsKey(chari)){
                int repeatIndex = window.get(chari);
                // case: abba second a index=0,from=2
                from = repeatIndex+1>from?repeatIndex+1:from;
            }
            end++;
            result=Math.max(result,end-from);
            window.put(chari,i);
        }
        return result;

    }
}
