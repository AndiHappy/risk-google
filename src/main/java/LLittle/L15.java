package LLittle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 */
public class L15 {

    public static void main(String[] args) {
        System.out.println(L15.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
        System.out.println(L15.threeSum(new int[] {-1,-1,0,0,1,1}));
        System.out.println(L15.threeSum(new int[] {0,0,0}));


    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // first sort
        Arrays.sort(nums);
        // second not same
        for (int i = 0; i < nums.length - 2; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1, k = nums.length - 1; k > j;) {
                int target = -nums[i];
                if (nums[j] + nums[k] == target) {
                    List<Integer> tmpresult = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(tmpresult);
                    j++;
                    k--;
                    while(j <= k && nums[j-1] == nums[j]) j++;
                    while(j <= k && nums[k+1] == nums[k]) k--;
                } else if (nums[k] + nums[j] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}