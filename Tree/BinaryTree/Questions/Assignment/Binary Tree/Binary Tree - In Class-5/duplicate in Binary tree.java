// method 01 using Recursion
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
    public static boolean checkDuplicate(TreeNode root, HashSet<Integer>hs){
        // If tree is empty, there are no duplicates. 
        if (root == null) return false;
        // If current node's val is already present.
        if (hs.contains(root.val))
            return true;
        // Insert current node
        hs.add(root.val);
        // Recursively check in left and right subtrees.
        return checkDuplicate(root.left,hs) || checkDuplicate(root.right,hs);
        
        /*
        checkDuplicate(root.left,hs);---> if return true
        checkDuplicate(root.right,hs);---> return false
        then we have to return true
         so  return using or
        */
    }
  
   public boolean duplicate(TreeNode root){
        HashSet<Integer> hs=new HashSet<>();
        return checkDuplicate(root, hs);
   }
  
}

// method 02 using Set
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
  
   public boolean duplicate(TreeNode root){
    if(root!=null){
      HashSet<Integer>hs=new HashSet<>();
      Queue<TreeNode>q=new LinkedList<>();
      q.add(root);
      while(!q.isEmpty()){
       TreeNode temp=q.poll();
          if(hs.contains(temp.val)){
            return true;
          }else{
            hs.add(temp.val);
          }
          if(temp.left!=null){
            q.add(temp.left);
          }
           if(temp.right!=null){
            q.add(temp.right);
          }
        }
      }
    return false;
   }
  
}

//  method 03 using hashset
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
   public boolean duplicate(TreeNode root){
     if(root==null){
       return false;
     }
    Queue<TreeNode>q=new LinkedList<>();
    HashSet<Integer>hs=new HashSet<>();
    q.add(root);
    while(!q.isEmpty()){
      TreeNode temp=q.poll();
      int data=temp.val;
      if(hs.contains(data)){
        return true;
      }else{
        hs.add(data);
      }
      if(temp.left!=null){
        q.add(temp.left);
      }
      if(temp.right!=null){
        q.add(temp.right);
      }
    }
    return false;
   }
  
}
