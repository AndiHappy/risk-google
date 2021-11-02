package com.normal.alg.hashmap;

import util.TreeNode;

import java.util.*;

public class Change {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1},2));
    }

    public static void countKDifference_test(String[] args) {
        System.out.println(countKDifference(new int[]{1,2,2,1},1));
    }

    public static int countKDifference(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        HashMap<Integer,Integer> cache = new HashMap<>();
        int result=0;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            Integer times = cache.get(value-k);
            Integer times2 = cache.get(value+k);
            if(times != null) result+=times;
            if(times2 != null) result+=times2;
            cache.put(value,cache.getOrDefault(value,0)+1);
        }
        return result;
    }

    static Set<Integer> powoftwo = new HashSet<>();
    static {
        for (int i = 0; i <=22 ; i++) {
            powoftwo.add((int) Math.pow(2,i));
        }
    }

    public static void countPairs_test(String[] args) {
        int[] tmp = new int[]{32,32,32,32,32,32,32,32,32,32,32,32};
        Arrays.sort(tmp);
        System.out.println(Arrays.toString(tmp));
        System.out.println(countPairs(tmp));
    }

    public static int countPairs(int[] deliciousness) {
        Map<Integer,Integer> cache = new HashMap<>();
        int result =0;
        for (int i = 0; i < deliciousness.length; i++) {

            int value= deliciousness[i];
            for (Integer twopower: powoftwo) {
                Integer times=cache.get(twopower-value);
                if(times != null) {
                    result += cache.get(twopower - value);
                }
            }
            cache.put(value,cache.getOrDefault(value,0)+1);
            System.out.println(result);
        }
        return result;
    }



    public int maxOperations(int[] nums, int k) {
        Map<Integer,Integer> cache = new HashMap<>();
        int result=0;
        for (int i = 0; i < nums.length; i++) {
            Integer times = cache.get(k-nums[i]);
            if(times != null && times > 0){
                result++;
                cache.put(k-nums[i],cache.get(k-nums[i])-1);
            }else{
                cache.put(nums[i],cache.getOrDefault(nums[i],0)+1);
            }
        }
        return result;
    }


    public static boolean findTarget(TreeNode root, int k) {
        Set<Integer> cache = new HashSet<Integer>();
        // iteration tree
        return iteration(root,cache,k);
    }

    public static boolean iteration(TreeNode root,Set<Integer> cache,int k){
        if(root == null) return false;
        if(cache.contains(k-root.val))  return true;
        cache.add(root.val);
        return iteration(root.left,cache,k) || iteration(root.right,cache,k);
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> cache = new HashMap<Integer, Integer>();

        cache.put(0,1);// greate Attention!

        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // sumi - sum-else = k
            if(cache.get(sum-k) != null){
                result += cache.get(sum-k);
            }else{
                cache.put(sum,cache.getOrDefault(sum,0)+1);
            }
        }

        return result;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        // change [3 sum] to [2 sum]
        for (int i = 0; i <= nums.length - 3; i++) {
            if(i>0 && nums[i-1] == nums[i]) continue;
            int ohter = 0 -nums[i];
            int m = i+1;
            int n = nums.length-1;
            while(m < n){
                int sum = nums[m]+nums[n];
                if(sum == ohter){
                    result.add(Arrays.asList(nums[i],nums[m],nums[n]));
                    m++;
                    n--;
                    while(nums[m-1] == nums[m]) m++;
                    while (nums[n] == nums[n+1]) n--;
                }else if(sum > ohter){
                    n--;
                }else{
                    m++;
                }
            }
        }
        return result;

    }
}
