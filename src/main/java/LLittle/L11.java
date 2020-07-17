package LLittle;

/**
 * 11. Container With Most Water
 * 
 * 
 * Given n non-negative integers a1, a2, ..., an , where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In
 * this case, the max area of water (blue section) the container can contain is
 * 49.
 * 
 * 
 * 
 * Example:
 * 
 * Input: [1,8,6,2,5,4,8,3,7] Output: 49
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * 
 **/
public class L11 {

	public static void main(String[] args) {
		System.out.println(L11.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));

	}

	public static int maxArea(int[] height) {
		int from = 0, end = height.length - 1, masRes = 0;
		while (from < end) {
			int result = Math.min(height[from], height[end]) * (end - from);
			if (result > masRes)
				masRes = result;
			if (height[from] > height[end]) {
				end--;
			} else {
				from++;
			}
		}
		return masRes;
	}

}
