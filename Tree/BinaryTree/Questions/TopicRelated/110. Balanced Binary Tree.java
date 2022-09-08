/*
Leetcode Link: https://leetcode.com/problems/balanced-binary-tree/
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int lheight=height(root.left);
        if(lheight==-1){
            return -1;
        }
       int  rheight=height(root.right);
        if(rheight==-1){
            return -1;
        }
         if(Math.abs(lheight-rheight)>1){
            return -1;
         }
        return Math.max(lheight,rheight)+1;
    }
    public boolean isBalanced(TreeNode root){
        int ans=height(root);
        if(ans==-1){
            return false;
        }
    return true;
       /*
        The above code can be reduced to just one line:
        return (isBalancedHelper(root) != -1);
         */
    }
}
