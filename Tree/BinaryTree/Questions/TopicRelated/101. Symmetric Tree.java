//https://leetcode.com/problems/symmetric-tree/

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
    private boolean helper(TreeNode p,TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val==q.val){
            boolean leftstatus=helper(p.left,q.right); // here we get return value true or false
            boolean rightstatus=helper(p.right,q.left); // here we get return value true or false
            return (leftstatus &&  rightstatus);
        }
        return false;
    }
    
    public boolean isSymmetric(TreeNode root) {
    if(root==null){
        return true;
    }
        return helper(root.left,root.right);
    }
}



// second method
private boolean isSymmetricHelper(TreeNode leftChild, TreeNode rightChild) {
        if(leftChild == null && rightChild == null) {
            return true;
        }

        if(leftChild == null || rightChild == null) {
            return false;
        }

        if(leftChild.val != rightChild.val) {
            return false;
        }

        return (isSymmetricHelper(leftChild.left, rightChild.right)
                && isSymmetricHelper(leftChild.right, rightChild.left));
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }

        return isSymmetricHelper(root.left, root.right);
    }
}
