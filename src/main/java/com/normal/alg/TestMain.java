package com.normal.alg;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class TestMain {

    public static void main(String[] args) {
        int[][] in = new int[][]{{1,0,1},{0,0,0},{1,0,1}};
        System.out.println(compareSmallDistance_simple(in));
    }

    private static int compareSmallDistance_simple(int[][] in) {
        int ans = -1;
        if(in != null && in.length > 0 && in[0].length > 0){
            for (int i = 0; i < in.length; i++) {
                for (int j = 0; j < in[0].length; j++) {

                }
            }
        }
        return -1;
    }

    public static int compareSmallDistance(int[][] in){
        // problem had noted
        int N = in.length;
        Queue<int[]> island = new ArrayDeque<int[]>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(in[i][j] == 1){
                    island.add(new int[]{i,j});
                }
            }
        }

        // all water or all island
        if(island.isEmpty() || island.size() == N*N){
            return -1;
        }


        // 方向向量
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 由于BFS的第一层遍历是从陆地开始，因此遍历完第一层之后distance应该是0
        int distance = -1;
        // 对队列的元素进行遍历
        while (island.size() != 0) {
            distance++;
            int isLandLength = island.size();
            for (int i =0 ; i < isLandLength ; i ++){
                 System.out.println("------------------ "+i+" -------------------");
                print(in);

                int[] cellLand = island.poll();
                int currentX = cellLand[0];
                int currentY = cellLand[1];

                for (int[] direct:directions){
                    int newX = currentX + direct[0];
                    int newY = currentY + direct[1];
                    // 只关心有效范围内的海洋（0）
                    if (0 <= newX && newX < N && 0 <= newY && newY < N && in[newX][newY] == 0) {
                        // 赋值成为一个不等于 0 的整数均可，因为后续逻辑只关心海洋（0）
                        in[newX][newY] = 1;
                        island.add(new int[]{newX, newY});
                    }
                }

                print(in);
            }

        }

        return distance;
    }

    private static void print(int[][] in) {
        for (int i = 0; i < in.length ; i++) {
            System.out.println();
            for (int j = 0; j < in[0].length; j++) {
                System.out.print(in[i][j] +" ");
            }
        }
        System.out.println();
    }
}

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    int n;
    int[][] grid;

    public int maxDistance(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    ans = Math.max(ans, findNearestLand(i, j));
                }
            }
        }
        return ans;
    }

    public int findNearestLand(int x, int y) {
        boolean[][] vis = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{x, y, 0});
        vis[x][y] = true;
        while (!queue.isEmpty()) {
            int[] f = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int nx = f[0] + dx[i], ny = f[1] + dy[i];
                if (!(nx >= 0 && nx < n && ny >= 0 && ny < n)) {
                    continue;
                }
                if (!vis[nx][ny]) {
                    queue.offer(new int[]{nx, ny, f[2] + 1});
                    vis[nx][ny] = true;
                    if (grid[nx][ny] == 1) {
                        return f[2] + 1;
                    }
                }
            }
        }
        return -1;
    }
}