public class L1000{
    /**
     * DP
     1000. Minimum Cost to Merge Stones

     There are N piles of stones arranged in a row.  The i-th pile has stones[i] stones.

     A move consists of merging exactly K consecutive piles into one pile,
     and the cost of this move is equal to the total number of stones in these K piles.

     Find the minimum cost to merge all piles of stones into one pile.  If it is impossible, return -1.



     Example 1:

     Input: stones = [3,2,4,1], K = 2
     Output: 20
     Explanation:
     We start with [3, 2, 4, 1].
     We merge [3, 2] for a cost of 5, and we are left with [5, 4, 1].
     We merge [4, 1] for a cost of 5, and we are left with [5, 5].
     We merge [5, 5] for a cost of 10, and we are left with [10].
     The total cost was 20, and this is the minimum possible.
     Example 2:

     Input: stones = [3,2,4,1], K = 3
     Output: -1
     Explanation: After any merge operation, there are 2 piles left, and we can't merge anymore.  So the task is impossible.
     Example 3:

     Input: stones = [3,5,1,2,6], K = 3
     Output: 25
     Explanation:
     We start with [3, 5, 1, 2, 6].
     We merge [5, 1, 2] for a cost of 8, and we are left with [3, 8, 6].
     We merge [3, 8, 6] for a cost of 17, and we are left with [17].
     The total cost was 25, and this is the minimum possible.


     Note:

     1 <= stones.length <= 30
     2 <= K <= 30
     1 <= stones[i] <= 100
     * */

    /**
     * 首先想到的是：1. 是选择最小的k元素，然后相加，归并成一个元素，替换成一个元素
     * 2. 看到DP标签，想起来的
     *      首先定义c[n] = c[n-k-1] + Sum (minK,minK-1,min0)
     * 3. 结合1和2，我们可以先排序，然后进行归并
     * 总结：理解题意错误
     * exactly K consecutive piles into one pile 意思是连续的堆，必须是连续的，不能随意的移动
     *
     * 在看DP标签，就是选择
     *
     * */
    public int mergeStones(int[] stones, int K) {
        return 0;
    }
}
