package com.normal.alg.twopoint;

import java.util.Arrays;

public class Twopoint {

    public int maxOperations(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int begine=0,end=nums.length,result=0;
        while(begine < end){
            int sum = nums[begine]+nums[end];
            if(sum == k){
                result++;
                begine++;
                end--;
            }else if(sum < k){
                begine++;
            }else {
                end--;
            }
        }
        return result;
    }

}
