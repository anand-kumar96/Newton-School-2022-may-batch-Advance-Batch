//https://leetcode.com/problems/binary-tree-inorder-traversal/
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
    public TreeNode inorderLis(TreeNode root, List<Integer>list){
        if(root==null){
            return root;
         }
        inorderLis(root.left,list);
        list.add(root.val);
        inorderLis(root.right,list); 
        return root;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>list=new LinkedList<>();
         inorderLis(root,list);
        return list;
    }
}
