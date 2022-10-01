/*
class Node
{
    int data;
    Node left, right;
    Node(int data)
   {
      this.data = data;
      this.left = this.right = null;
   }
}
*/

static int getHeight(Node node){
   if(node==null){
      return 0;
   }
   int lheight=getHeight(node.left);
   int rheight=getHeight(node.right);
    return (Math.max(lheight,rheight)+1);
}

/*
Height of Binary Tree
easy
Problem Statement
Given a binary tree, find height of it.

1
/ \
10 39
/
5

The above tree has a height of 3.
Note: Height of empty tree is considered 0.
Input
User Task:
Since this will be a functional problem. You don't have to take input. 
You just have to complete the function getHeight() that takes "root" node as parameter and returns the height. 
The printing is done by the driver code.

Constraints:
1 < = T < = 100
1 < = N < = 10^5
1 < = node values < = 10^5

Sum of "N" over all testcases does not exceed 10^5

For Custom Input:
First line of input should contains the number of test cases T. For each test case, there will be two lines of input.
First line contains number of nodes N. Second line will be a string representing the tree as described below:
The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.
Note: If a node has been declared Null using 'N', no information about its children will be given further in the array.
Output
Return the height of the tree.
Example
Sample Input:
1
3
1 2 3

Sample Output:
2

Explanation:
Testcase1: The tree is
1
/ \
2 3
So, the height would be 2.
*/
