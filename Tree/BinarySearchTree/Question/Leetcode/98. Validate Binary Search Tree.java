//https://leetcode.com/problems/validate-binary-search-tree/

//method 01
  

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
    // Integer is wrapper class is contain default value null
    public static boolean isValidBsthelper(TreeNode root, Integer min,Integer max){
        boolean leftstatus=true;
        boolean rightstatus=true;
        if(root!=null){
            if(min!=null && root.val<=min){
                leftstatus=false;
            }
             if(max!=null && root.val>=max){
                rightstatus=false;
            }
            if(leftstatus && rightstatus){
                leftstatus=  isValidBsthelper(root.left,min,root.val);
               rightstatus= isValidBsthelper(root.right,root.val,max);
            }
        }
        
        return (leftstatus && rightstatus);
    }
    public boolean isValidBST(TreeNode root) {
        boolean result= isValidBsthelper(root,null,null);
        return result;
    }
}
// method 02
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
    // Integer is wrapper class is contain default value null
    public static boolean isValidBsthelper(TreeNode root, Integer min,Integer max){
        boolean leftstatus=true;
        boolean rightstatus=true;
        if(root!=null){
            if(min!=null && root.val<=min){
                 return false;
            }
             if(max!=null && root.val>=max){
                 return false;
            }
            leftstatus=  isValidBsthelper(root.left,min,root.val);
            rightstatus= isValidBsthelper(root.right,root.val,max);
        }
        
        return (leftstatus && rightstatus);
    }
    public boolean isValidBST(TreeNode root) {
        boolean result= isValidBsthelper(root,null,null);
        return result;
    }
}

// method 03
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
    // Integer is wrapper class is contain default value null
    public static boolean isValidBsthelper(TreeNode root, Integer min,Integer max){
        if(root==null){
            return true;
        }
            if(min!=null && root.val<=min){
                 return false;
            }
             if(max!=null && root.val>=max){
                 return false;
            }
             return isValidBsthelper(root.left,min,root.val) &&
              isValidBsthelper(root.right,root.val,max);
    }
    public boolean isValidBST(TreeNode root) {
        boolean result= isValidBsthelper(root,null,null);
        return result;
    }
}
