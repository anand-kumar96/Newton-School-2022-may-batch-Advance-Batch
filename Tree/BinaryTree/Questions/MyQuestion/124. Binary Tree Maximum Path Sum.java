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
     // extension of diameter
    public int findMaxPath(TreeNode root,int maxi[]){
        if(root==null){
            return 0;
        }
            // int leftSum=findMaxPath(root.left,maxi);
            // int rightSum=findMaxPath(root.right,maxi);
        
        
          // to ignore -ve of left an d right part we have to right  // discard -ve value
         int leftSum=Math.max(0,findMaxPath(root.left,maxi));
        int rightSum=Math.max(0,findMaxPath(root.right,maxi));
        
            maxi[0]=Math.max(maxi[0],(root.val+leftSum+rightSum));
            return root.val+Math.max(leftSum,rightSum);
      
        
    }
    public int maxPathSum(TreeNode root) {
        int maxi[]=new int[1];
        maxi[0]=Integer.MIN_VALUE;
        int ans=findMaxPath(root,maxi);
        return maxi[0];
    }
}

// ex
/*
                10 
            15      30
                -10    -8
*/
