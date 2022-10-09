//explanation:https://leetcode.com/problems/recover-binary-search-tree/discuss/32562/Share-my-solutions-and-detailed-explanation-with-recursiveiterative-in-order-traversal-and-Morris-traversal
// method. 01
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
    static List<Integer>li;
    public void Inorder(TreeNode currentNode){
        if( currentNode!=null){
            Inorder(currentNode.left);
            li.add(currentNode.val);
            Inorder(currentNode.right);
        }
    }
    static int j;
    public void InorderHelper(TreeNode currentNode){
         if( currentNode!=null){
            InorderHelper(currentNode.left);
             if(currentNode.val!=li.get(j)){
                currentNode.val=li.get(j); 
                 j++;
             }else{
                 j++;
             }
            InorderHelper(currentNode.right);
        }
    }
    public void recoverTree(TreeNode root) {
        li=new ArrayList<>();
        Inorder(root);
       Collections.sort(li);
        j=0;
        InorderHelper(root);
    }
}
// method. 02

