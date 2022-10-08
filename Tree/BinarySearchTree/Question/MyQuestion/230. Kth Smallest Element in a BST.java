//https://leetcode.com/problems/kth-smallest-element-in-a-bst/

// my method

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
    static TreeSet<Integer>hs;
    public void kthSmallestHelper(TreeNode currentNode){
        if(currentNode!=null){
            if(!hs.contains(currentNode.val)){
                hs.add(currentNode.val);
            }
            kthSmallestHelper(currentNode.left);
            kthSmallestHelper(currentNode.right);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        hs=new TreeSet<>();
        kthSmallestHelper(root);
        int result=0;
        int ans=-1;
       for(Integer value:hs){
           result++;
           if(result==k){
               ans=value;
               break;
           }
       }
        return ans;
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
    static int result;
    static int count;
    // inorderTraversal in bst give sorted data
    public void kthSmallestHelper(TreeNode root, int k){
         if(root!=null){
        kthSmallestHelper(root.left, k);
             count++;
         if(count==k){
             result=root.val;
                return;
         }
          kthSmallestHelper(root.right, k);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
       result=-1;
        count=0;
        kthSmallestHelper(root,k);
    
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
     int result;
    int count;
    private void kthSmallestHelper(TreeNode currentNode, int k) {
        if(currentNode != null) {
            kthSmallestHelper(currentNode.left, k);
            count++;
            if(count == k) {
                result = currentNode.val;
                return;
            }
            if(count < k) {
                kthSmallestHelper(currentNode.right, k);
            }
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        kthSmallestHelper(root, k);
        return result;
    }
}
