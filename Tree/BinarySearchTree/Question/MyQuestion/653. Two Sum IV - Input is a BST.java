//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

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

// my method 
class Solution {
    static boolean result;
    static  HashMap<Integer,Integer>hm;
    public void finddiff(TreeNode currentNode,int k){
        if(currentNode!=null){
             finddiff(currentNode.left,k);
            if(!hm.containsKey(k-currentNode.val)){
                hm.put(currentNode.val,1);
            }else{
                result=true;
                return;
            }
       finddiff(currentNode.right,k);
             
        }
      
         
    }
    public boolean findTarget(TreeNode root, int k) {
        hm=new HashMap<>();
        result=false;
       finddiff(root, k);
        return result;
    }
}

// method 01
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
    static  HashSet<Integer>hs;
    public boolean finddiff(TreeNode currentNode,int k){
        if(currentNode==null){
            return false;
        } 
            if(!hs.contains(k-currentNode.val)){
                hs.add(currentNode.val);
            }else{
                return true;
            }
            return finddiff(currentNode.left,k) || finddiff(currentNode.right,k);
             
        }
         
    public boolean findTarget(TreeNode root, int k) {
        hs=new HashSet<>();
        return finddiff(root, k);
    }
}
