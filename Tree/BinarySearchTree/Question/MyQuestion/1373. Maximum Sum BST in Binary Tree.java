//https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
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
        static class pair {
        int min;
        int max;
        int val;
         pair(int min, int max, int val) {
            this.min = min;
            this.max = max;
            this.val = val;
        }
    }
      int[] result={0};
    private  pair traverse(TreeNode root) {
        if (root == null) {
            return new pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        pair left = traverse(root.left);
        pair right = traverse(root.right);
        if (root.val > left.max && root.val < right.min) {
            int curSum = left.val + right.val + root.val;
            result[0] = Math.max(curSum, result[0]);
            return new pair(Math.min(root.val, left.min), Math.max(root.val, right.max), curSum);
        }
        return new pair(Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
     public  int maxSumBST(TreeNode root) {
        traverse(root);
        return result[0];
    }
}
