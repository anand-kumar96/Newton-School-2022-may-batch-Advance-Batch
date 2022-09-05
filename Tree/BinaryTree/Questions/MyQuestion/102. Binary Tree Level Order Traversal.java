//https://leetcode.com/problems/binary-tree-level-order-traversal/
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
    public List<List<Integer>> levelOrder(TreeNode rootNode) {
         List<List<Integer>>TreeData=new ArrayList<>();
        if(rootNode!=null){
             Queue<TreeNode> queue = new LinkedList<>();
        queue.add(rootNode);
        queue.add(null);
        List<Integer>CurrentLevelData=new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            if(temp!=null){
              CurrentLevelData.add(temp.val);
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }else{
                List<Integer>tempList=new ArrayList<>(CurrentLevelData);
                TreeData.add(tempList);
               CurrentLevelData.clear();
               if(!queue.isEmpty()){
                   queue.add(null);
               }
                }
                }
        
            }
       return TreeData;
    }
}
