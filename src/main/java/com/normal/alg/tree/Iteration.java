package com.normal.alg.tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Iteration {


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

    public static void main(String[] args) {
        System.out.println("hello,world!");
        System.out.println(numTrees(1));
        System.out.println(numTrees(2));
        System.out.println(numTrees(3));

        TreeNode n5 = new TreeNode(5);
        n5.left=new TreeNode(3);
        n5.right=new TreeNode(6);
        n5.left.left = new TreeNode(2);
        n5.left.right = new TreeNode(4);
        n5.right.right = new TreeNode(7);
        System.out.println(findTarget(n5,9));
        System.out.println(findTarget(n5,10));
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


    /******************************************************************************************************/
    public static List<TreeNode> generate(int n){
        return generate(1,n,new ArrayList<TreeNode>());
    }
    private static List<TreeNode> generate(int i, int n, ArrayList<TreeNode> arrayList) {
        if( i > n) {
            arrayList.add(null);
            return arrayList;
        }

        if(i == n){
            arrayList.add(new TreeNode(i));
            return arrayList;
        }

        for(int j=i;j<=n;j++){
            List<TreeNode> leftNodes = generate(i,j-1,new ArrayList<TreeNode>());
            List<TreeNode> rightNodes = generate(j+1,n,new ArrayList<TreeNode>());
            for (int k = 0; k < leftNodes.size(); k++) {
                TreeNode left = leftNodes.get(k);
                for (int l = 0; l < rightNodes.size(); l++) {
                    TreeNode right = rightNodes.get(l);
                    TreeNode root = new TreeNode(j);
                    root.right=right;
                    root.left= left;
                    arrayList.add(root);
                }
            }
        }
        return arrayList;
    }
}


/******************************************************************************************************/
