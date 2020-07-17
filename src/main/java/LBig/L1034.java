package LBig;

import java.util.Arrays;

public class L1034 {
    public int[] numMovesStones(int a, int b, int c) {
        int[] m = new int[]{a,b,c};
        Arrays.sort(m);
        int aTob = m[1]-m[1]-1;
        int bToc = m[2]-m[1]-1;

        int arrOne = 0;
        int arrTwo = 0;
        if(aTob == 1 || bToc == 1){
            arrOne = 1;
        }else{
            arrOne += aTob == 0 ? 0 : 1;
            arrOne += bToc == 0 ? 0 : 1;
        }

        arrTwo += aTob == 1 ? 0 : aTob - 1;
        arrTwo += bToc == 1 ? 0 : bToc - 1;

        return new int[]{arrOne, arrTwo};

    }
}

