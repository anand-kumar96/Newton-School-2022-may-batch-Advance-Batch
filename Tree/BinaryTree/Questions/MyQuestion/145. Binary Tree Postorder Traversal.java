//https://leetcode.com/problems/binary-tree-postorder-traversal/
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>list=new LinkedList<>();
        postorder(root,list);
        return list;
    }
    public TreeNode postorder(TreeNode root,List<Integer>list){
        if(root==null){
            return root;
        }
        postorder(root.left,list);
        postorder(root.right,list);
        list.add(root.val);
        return root;
        
    }
}
