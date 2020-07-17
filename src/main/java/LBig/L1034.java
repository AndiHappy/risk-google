package LBig;

import java.util.Arrays;

public class L1034 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(numMovesStones(1, 4, 3)));
    }

    public static int[] numMovesStones(int a, int b, int c) {
        int[] m = new int[]{a, b, c};
        Arrays.sort(m);
        int left = m[1] - m[0] - 1;
        int right = m[2] - m[1] - 1;
        int first = 0, seconde = 0;
        seconde = left + right;
        first = Math.min(right == 1 || left == 1 ? 1 : 2, (right == 0 ? 0 : 1) + (left == 0 ? 0 : 1));
        return new int[]{first, seconde};

    }
}