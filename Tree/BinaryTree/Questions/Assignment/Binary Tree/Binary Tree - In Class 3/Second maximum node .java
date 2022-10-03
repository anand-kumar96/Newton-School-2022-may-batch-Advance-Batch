// method 01

//class TreeNode {
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

class Solution{
    
    class Result{
        int highest;
        int secondHighest;
        Result(){
            highest = -1;
            secondHighest = -1;
        }
    }

    private void preorderTraversal(TreeNode currentNode, Result result) {
        if(currentNode == null) {
            return;
        }
        if(currentNode.val > result.highest) {
            result.secondHighest = result.highest;
            result.highest = currentNode.val;
        }
        else if(currentNode.val > result.secondHighest) {
              result.secondHighest = currentNode.val;
        }
        preorderTraversal(currentNode.left, result);
        preorderTraversal(currentNode.right, result);
    }

    public int SecondMaxNode(TreeNode root){
         Result result = new Result();
         preorderTraversal(root, result);
         return ((result.secondHighest != -1) ? 
         (result.secondHighest) : (result.highest));
    }
}

/*
Second maximum node
easy
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given the root of a non empty binary tree, return the second highest value among all node's value.

If second maximum doesn't exist, return the maximum value of the node.
Input
You don't have to input anything.

Constraints:
1 <= Number of nodes <= 105
0 <= value of nodes <= 10^9
Output
You don't have to output anything. You just need to implement the function and return the value.
Example
Input:
3 5 7 null 4

Output:
5

Explanation:
3
/ \
5 7
\
4

Input:
2 2

Output:
2
*/
