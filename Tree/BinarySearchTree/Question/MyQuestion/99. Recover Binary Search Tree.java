//explanation:https://leetcode.com/problems/recover-binary-search-tree/discuss/32562/Share-my-solutions-and-detailed-explanation-with-recursiveiterative-in-order-traversal-and-Morris-traversal
//https://www.youtube.com/watch?v=ZWGW7FminDM


// method. 01
// // tc=2*O(N)+Nlog(N), Ts=O(N)
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
// tc=O(N), Ts=O(1)
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
     TreeNode first;
     TreeNode second;
     TreeNode last;
     TreeNode prev;
    public void InorderHelper(TreeNode currentNode){
         if( currentNode!=null){
            InorderHelper(currentNode.left);
             if(prev!=null && currentNode.val<prev.val){
                 if(first==null){
                     first=prev;
                     second=currentNode;
                 }else{
                     last=currentNode;
                 }
             }
              prev=currentNode;
            InorderHelper(currentNode.right);
        }
    }
    public void recoverTree(TreeNode root) {
             first=null;
             second=null;
             prev=new TreeNode( Integer.MIN_VALUE);
             last=null;
            InorderHelper(root);
            if(first!=null && last!=null){
                int temp=first.val;
                first.val=last.val;
                last.val=temp;
            }
        if(first!=null && last==null){
            int temp=first.val;
                first.val=second.val;
                second.val=temp;
        }
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
      TreeNode firstNode = null;
    TreeNode secondNode = null;

    TreeNode previousElement = new TreeNode(Integer.MIN_VALUE);

    private void recoverTreeHelper(TreeNode currentNode) {
        if(currentNode != null) {
            recoverTreeHelper(currentNode.left);
            //process
            if(firstNode == null && previousElement.val > currentNode.val) {
                firstNode = previousElement;
            }
            if(firstNode != null && previousElement.val > currentNode.val) {
                secondNode = currentNode;
            }
            previousElement = currentNode;

            recoverTreeHelper(currentNode.right);
        }
    }
    public void recoverTree(TreeNode root) {
        recoverTreeHelper(root);
        //swap
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }
}
