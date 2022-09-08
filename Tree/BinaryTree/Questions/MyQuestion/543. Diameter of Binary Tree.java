//https://leetcode.com/problems/diameter-of-binary-tree/
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
    int longestpath=0;
    private int height(TreeNode root){
        if(root==null){
            return 0;
        }
            int lheight=height(root.left);
            int rheight=height(root.right);
            longestpath=Math.max(longestpath,lheight+rheight);
            return Math.max(lheight,rheight)+1;
        
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return longestpath;
    }
}
