//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
//method 01 by me
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      int count=0;
        List<List<Integer>>list1=new ArrayList<>();
        List<Integer>list2=new ArrayList<>();
        if(root!=null){
            Queue<TreeNode>queue=new LinkedList<>();
            queue.add(root);
            queue.add(null);
            while(!queue.isEmpty()){
                TreeNode temp=queue.poll();
                if(temp!=null){
                    list2.add(temp.val);
                    if(temp.left!=null){
                        queue.add(temp.left);
                    }
                    if(temp.right!=null){
                        queue.add(temp.right);
                    }
                }else{
                    List<Integer>list3=new ArrayList<>(list2);
                    if(count%2==1){
                     Collections.reverse(list3); 
                        list1.add(list3);
                    }else{
                        list1.add(list3);
                    }
                     list2.clear();   
                    count++;
                    if(!queue.isEmpty()){
                        queue.add(null);
                    }
                }
            }
             
        }
        return list1;
    }
}



// method 02

public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            boolean isZigZag = false;
            queue.add(root);
            while(!queue.isEmpty()) {
                List<Integer> currentLevel = new ArrayList<>();
                int queueSize = queue.size();
                for(int i = 0; i < queueSize; i++) {
                    TreeNode temp = queue.poll();
                    if(!isZigZag) {
                        currentLevel.add(temp.val);
                    }
                    else {
                        currentLevel.add(0, temp.val);
                    }

                    if(temp.left != null) {
                        queue.add(temp.left);
                    }

                    if(temp.right != null) {
                        queue.add(temp.right);
                    }
                }

                result.add(currentLevel);
                isZigZag = !isZigZag;
            }
        }

        return result;
    }
}
