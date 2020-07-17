package LLittle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L18 {
    /**
     * 18. 4Sum
     * 
     * Given an array nums of n integers and an integer target, are there elements
     * a, b, c, and d in nums such that a + b + c + d = target? 
     * Find all unique quadruplets in the array which gives the sum of target.
     * 
     * Note:
     * 
     * The solution set must not contain duplicate quadruplets.
     * 
     * Example:
     * 
     * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
     * 
     * A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
     */
  

    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] nums = new int[]{ 1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(L18.fourSum(nums,target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>  result = new ArrayList<List<Integer>>();
        if(nums== null || nums.length < 4) return result;
        Arrays.sort(nums);// 
        for(int i = 0; i < nums.length-3;i++){
            if(i!=0 && nums[i-1] == nums[i]) continue;
            for(int j = i+ 1 ; j < nums.length-2 ; j++){
                if (j != i + 1 && nums[j - 1] == nums[j]) continue;
                int local = target - nums[i] -nums[j];
                int m = j+1,n=nums.length-1;
                while(m < n){
                    if(local == (nums[m]+nums[n])){
                        result.add(Arrays.asList(nums[m],nums[n],nums[i],nums[j]));
                        m++;
                        n--;
                        while (m < n && nums[m] == nums[m - 1]) {
                            m++;
                        }
                        while (m < n && nums[n] == nums[n + 1]) {
                            n--;
                        }
                    }else if(local > (nums[m] + nums[n])){
                        m++;
                    }else{
                        n--; 
                    }
                }
            }

        }
        return result;

    }
}

