//method 01
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
    int sum;
    public int leafSum(TreeNode root){
        sum=0;
      if(root!=null){
          if(root.left==null && root.right==null){
              sum+=root.val;
          }
          sum+=leafSum(root.left);
          sum+=leafSum(root.right);
      }
      return sum;
    }
    
}

//method 02
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
    int sum=0;
    public int leafSum(TreeNode root){
        if (root == null) return 0;
        if (root.left == null && root.right == null)
        sum += root. val;
        leafSum(root.left);
        leafSum(root.right);
        return sum;
    }
    
}
/*
Leaf sum
easy
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given the root of a binary tree, return the sum of values of all leaf nodes.

A leaf is node with no children.
Input
You don't have to input anything.

Constraints:
1 <= Number of nodes <= 105
0 <= value of nodes <= 109
Output
You don't have to output anything. You just need to implement the function and return the value.
Example
Input:
3 5 4 null 7

output:
11

Explanation:
3
/ \
5 7
\
4
4 and 7 are the leaves .
Leaf sum
easy
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given the root of a binary tree, return the sum of values of all leaf nodes.

A leaf is node with no children.
Input
You don't have to input anything.

Constraints:
1 <= Number of nodes <= 105
0 <= value of nodes <= 109
Output
You don't have to output anything. You just need to implement the function and return the value.
Example
Input:
3 5 4 null 7

output:
11

Explanation:
3
/ \
5 7
\
4
4 and 7 are the leaves .
*/
