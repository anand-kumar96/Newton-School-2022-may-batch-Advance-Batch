/*
//Information about the class Node
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/
 private static void getRightView(Node rootNode,int levelNumber,List<Integer>rightViewList){
    if(rootNode==null){
        return;
    }
    if(rightViewList.size()==levelNumber){
        rightViewList.add(rootNode.data);
        System.out.print(rootNode.data+" ");
    }
    getRightView(rootNode.right,levelNumber+1,rightViewList);
    getRightView(rootNode.left,levelNumber+1,rightViewList);
    }
static void printRightView(Node node){
    List<Integer>rightViewList=new ArrayList<>();
    getRightView(node,0,rightViewList);
   // System.out.println(rightViewList);
}

/*
Right View of Binary Tree
easy
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given a Binary Tree, print Right view of it. Right view of a Binary Tree is set of nodes visible when tree is viewed from right side.

Right view of following tree is 1 3 7 8.

1
/ \
2 3
/ \ / \
4 5 6 7
\
8
Input
Your Task:
This is a function problem. You don't have to take input. Just complete the function rightView() that takes node as parameter and prints the right view. Also the functional part visible to you contains information about the Node class

Constraints:
1 <= T <= 100
1 <= N <= 10^5
1 <= node values <= 10^5

Sum of "N" over all testcases does not exceed 10^5

For Custom Input:
First line of input should contains the number of test cases T. For each test case, there will be two lines of input.
First line contains number of nodes N. Second line will be a string representing the tree as described below:
The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.
Note: If a node has been declared Null using 'N', no information about its children will be given further in the array.
Output
Print the right view of the binary tree.
Example
Sample Input:
2
3
1 3 2
5
10 20 30 40 60

Sample Output:
1 2
10 30 60

Explanation:
Test case 1: Below is the given tree

1
/ \
3 2
For the above test case the right view is: 1 2
Test case 2: Below is the given tree

10
/ \
20 30
/ \
40 60

Right View is: 10 30 60.
*/
