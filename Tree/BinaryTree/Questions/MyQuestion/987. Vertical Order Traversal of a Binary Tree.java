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

// method 01 -->Using 

class Solution {
    TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>>nodeMap;
    List<List<Integer>>result;
    public  void  beautifyResult(){
        for(TreeMap<Integer,ArrayList<Integer>>eachNodeMap:nodeMap.values()){
            List<Integer> columnList=new ArrayList<>();
            for(ArrayList<Integer>eachNodeList:eachNodeMap.values()){
                Collections.sort(eachNodeList);
                columnList.addAll(eachNodeList);
            }
            result.add( columnList);
        }
    }
    public void  getverticalTraversal(TreeNode currentNode,int row,int column){
        if(currentNode!=null){
            if(!nodeMap.containsKey(column)){
                nodeMap.put(column,new TreeMap<>());
            }
             if(!nodeMap.get(column).containsKey(row)){
                nodeMap.get(column).put(row,new ArrayList<>());
            }
            nodeMap.get(column).get(row).add(currentNode.val);
            getverticalTraversal(currentNode.left,row+1,column-1);
            getverticalTraversal(currentNode.right,row+1,column+1);
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // we have to also create object of map and list
        nodeMap=new TreeMap<>();
        result=new ArrayList<>();
        
        getverticalTraversal(root,0,0);
        beautifyResult();
        return result;
    }
}
