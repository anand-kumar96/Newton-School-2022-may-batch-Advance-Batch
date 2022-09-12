//https://leetcode.com/problems/maximum-width-of-binary-tree/

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
    class Pair{
    TreeNode currentNode;
    int index;
    Pair(TreeNode currentNode,int index){
        this.currentNode=currentNode;
        this.index=index;
    }
}
public int widthOfBinaryTree(TreeNode root) {
  int maxWidth=0;
   Pair rootNode=new Pair(root,0);
   ArrayDeque<Pair>dq=new ArrayDeque<>();
   dq.add(rootNode);
   while(!dq.isEmpty()){
      int size=dq.size();
      int firstIndex=dq.getFirst().index;
      int lastIndex=dq.getLast().index;
      int currentWidth=lastIndex-firstIndex+1;
       maxWidth=Math.max(maxWidth,currentWidth);
       for(int i=0;i<size;i++){
           Pair firstNode=dq.poll();
           TreeNode key=firstNode.currentNode;
           int value=firstNode.index;
           if(key.left!=null){
               int leftIndex=2*value+1;
               Pair pair=new Pair(key.left,leftIndex);
               dq.add(pair);
           }
           if(key.right!=null){
               int rightIndex=2*value+2;
               Pair pair=new Pair(key.right,rightIndex);
               dq.add(pair);
           }
       }
   }
  return maxWidth;
}  
}
