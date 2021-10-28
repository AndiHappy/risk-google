package com.normal.alg.tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Iteration {


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
