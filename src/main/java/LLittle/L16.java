package LLittle;
import java.util.Arrays;

public class L16 {

    /**
     * 16. 3Sum Closest Medium
     * 
     * Share Given an array nums of n integers and an integer target, find three
     * integers in nums such that the sum is closest to target. Return the sum of
     * the three integers. You may assume that each input would have exactly one
     * solution.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [-1,2,1,-4], target = 1 Output: 2 Explanation: The sum that is
     * closest to the target is 2. (-1 + 2 + 1 = 2).
     * 
     * 
     * Constraints:
     * 
     * 3 <= nums.length <= 10^3 
     * -10^3 <= nums[i] <= 10^3 
     * -10^4 <= target <= 10^4
     */
    public static void main(String[] args) {
        System.out.println("Hello,world");
        System.out.println(2 == threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
        System.out.println(2 == threeSumClosest_for(new int[] { -1, 2, 1, -4 }, 1));

        System.out.println(threeSumClosest(new int[] { 0, 2, 1, -3}, 1));
        System.out.println(threeSumClosest_for(new int[] { 0, 2, 1, -3 }, 1));

        System.out.println(threeSumClosest(new int[] { -1,0,1,1,55}, 3));
        System.out.println(threeSumClosest_for(new int[] { -1, 0, 1, 1, 55 }, 3));
    }
    

    public static int threeSumClosest(int[] nums, int target) {
        // first sort the nums
        Arrays.sort(nums);
        Integer resuult = null;
        // second two index 
        for(int i =0;i< nums.length-2;i++){
            int fromindex = i+1,endinex = nums.length-1;
            while(fromindex < endinex){
                int tmptargetTarget = nums[fromindex]+nums[endinex]+nums[i];
                if(resuult == null || Math.abs(tmptargetTarget-target) < Math.abs(resuult-target)){
                    resuult=tmptargetTarget;
                }
                if(target == tmptargetTarget){
                    return target;
                }else if(target > tmptargetTarget){
                    fromindex++;
                    while (endinex > fromindex && nums[fromindex + 1] == nums[fromindex])
                        fromindex++;
                }else{
                    endinex--;
                    while (endinex > fromindex && nums[endinex - 1] == nums[endinex])
                        endinex--;
                    
                }
            }
        }
        return resuult;
    }

    public static int threeSumClosest_for(int[] nums, int target) {
        // first sort the nums
        Arrays.sort(nums);
        Integer resuult = null;
        // second two index
        for (int i = 0; i < nums.length - 2; i++) {
            if(i !=0 && nums[i] == nums[i - 1])
                continue;
            for(int fromindex = i + 1, endinex = nums.length - 1;fromindex < endinex;){
                int tmptargetTarget = nums[fromindex] + nums[endinex] + nums[i];
                if (resuult == null || Math.abs(tmptargetTarget - target) < Math.abs(resuult - target)) {
                    resuult = tmptargetTarget;
                }
                if (target == tmptargetTarget) {
                    return target;
                } else if (target > tmptargetTarget) {
                    fromindex++;
                    while (endinex > fromindex && nums[fromindex - 1] == nums[fromindex])
                        fromindex++;
                } else {
                    // 这个比对非常的有意思，需要单独的列出来，逻辑的判断，思维的敏捷
                    endinex--;
                    while (endinex > fromindex && nums[endinex + 1] == nums[endinex])
                        endinex--;

                }
            }
        }
        return resuult;
    }
    
}