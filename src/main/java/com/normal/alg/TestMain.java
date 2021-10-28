package com.normal.alg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import util.TreeNode;




public class TestMain {






    public static void main(String[] args) {
        System.out.println("hello,world!");
        System.out.println(numTrees(1));
        System.out.println(numTrees(2));
        System.out.println(numTrees(3));
    }




    public static int numTrees(int n) {
        return numTrees(1,n);
    }

    private static int numTrees(int i, int n) {
        if(i >= n) return 1;
        int sum=0;
        for(int j =i;j<=n;j++){
            int leftNodes = numTrees(i,j-1);
            int rightNodes = numTrees(j+1,n);
            sum+= leftNodes*rightNodes;
        }
        return sum;
    }
}