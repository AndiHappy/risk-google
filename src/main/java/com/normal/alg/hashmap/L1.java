package com.normal.alg.hashmap;

import java.util.Arrays;
import java.util.HashMap;

public class L1 {
    /**
     * 2.1 ask questions to clarify and think about edge cases
     * 2.2 think about solution :think aloud talk  aloud
     * 2.3 Coiding code correctness and code readability
     * 2.4 Testing
     * */

    public static int[] twoSum(int[] nums,int target){
        if(nums == null || nums.length < 2) return new int[2];
        HashMap<Integer,Integer> tmp = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < nums.length ; i ++){
            Integer one = tmp.get(target-nums[i]);
            if(one != null){
                return new int[]{one,i};
            }else{
                tmp.put(nums[i],i);
            }
        }
        return new int[2];

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1,2,3,4,5},7)));
    }
}
