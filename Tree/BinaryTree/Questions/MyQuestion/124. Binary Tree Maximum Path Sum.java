//https://leetcode.com/problems/binary-tree-maximum-path-sum/
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
// extension of diameter
class Solution {
    public int findmaxsum(TreeNode root,int maxi[]){
        if(root==null){
            return 0;
        }
        int lheight=Math.max(0,findmaxsum(root.left,maxi));
        int rheight=Math.max(0,findmaxsum(root.right,maxi));
        maxi[0]=Math.max(maxi[0],root.val+lheight+rheight);
        return root.val+(Math.max(lheight,rheight));
    }
    public int maxPathSum(TreeNode root) {
        int maxi[]=new int [1];
        maxi[0]=Integer.MIN_VALUE;
        findmaxsum(root,maxi);
        return maxi[0];
    }
}
