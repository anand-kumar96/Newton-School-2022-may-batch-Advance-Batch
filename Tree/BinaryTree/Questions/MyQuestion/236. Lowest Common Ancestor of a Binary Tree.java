//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p||root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left, p,q);
        TreeNode right=lowestCommonAncestor(root.right, p,q);
        if(left==null){
            return right;
        }else if(right==null){
            return left;
        }else
        return root;
    }
}
// method 02

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root==null || root==p || root==q){
           return root;
       } 
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null && right==null){
           return null; 
        }else if(left!=null && right!=null){
            return root;
        }else if(left==null){
            return right;
        }else
            return left;
    }
}

//// method 03

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root==null){
           return root; //null
       }
         if(root.val==p.val || root.val==q.val){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null && right==null){
           return null; 
        }else if(left!=null && right!=null){
            return root;
        }else if(left==null){
            return right;
        }else
            return left;
    }
}
/*
explanation:
3,5,1,6,2,0,8,null,null,7,4     case (1) p=7, q =4 
                                case (2) p=6, q =8
                                 tree
                                 3
                            5          1
                         6     2    0     8
                             7   4
                             
                  case 01
         lowestCommonAncestor(root,7, 4) {
        if(root==null || root==7||root==4){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left (5), 7,4);--------->
        TreeNode right=lowestCommonAncestor(root.right, 7,4);
        if(left==null){
            return right;
        }else if(right==null){
            return left;
        }else
        return root;
    }                
                                                                                               lowestCommonAncestor(root(5),7, 4) {
                                                                                              if(root==null || root==7||root==4){
                                                                                               return root;
                                                                                               }
                                                                                  <--------   TreeNode left=lowestCommonAncestor(root.left (6), 7,4);
                                                                                              TreeNode right=lowestCommonAncestor(root.right, 7,4);
                                                                                              if(left==null){
                                                                                              return right;
                                                                                             }else if(right==null){
                                                                                              return left;
                                                                                             }else
                                                                                           return root;
                                                                                              }  
                                                                                              
        lowestCommonAncestor(root(6),7, 4) {
        if(root==null || root==7||root==4){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left (null), 7,4);--------->
        TreeNode right=lowestCommonAncestor(root.right, 7,4);
        if(left==null){
            return right;
        }else if(right==null){
            return left;
        }else
        return root;
    }                                                                                                 
                                                                                             lowestCommonAncestor(root(null),7, 4) {
                                                                                              if(root==null || root==7||root==4){  //this part execute 
                                                                                               return root; // return null
                                                                                               }
                                                                                             TreeNode left=lowestCommonAncestor(root.left (6), 7,4); // left=null
                                                                                              TreeNode right=lowestCommonAncestor(root.right, 7,4); // also null 
                                                                                              if(left==null){
                                                                                              return right; // this execute return null
                                                                                             }else if(right==null){
                                                                                              return left;
                                                                                             }else
                                                                                           return root;
                                                                                              }                                                                                         
                                                                                              
                                                                                              
                                                                                              
                                                                                              
                                                                                              
                         
*/                            
