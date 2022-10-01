
// method 01
/*
// Information about the class Node
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
static boolean isFoldable(Node node){   
    if(checkNode(node.left,node.right)){
        return true;
    }else{
        return false;
    }

} 
static boolean checkNode(Node left,Node right ){
    if(left==null && right==null) return true;
    if (left==null || right==null){
        return false;
    }

    return checkNode(left.left, right.right)
            && checkNode(left.right, right.left);
}


// method 02
/*
// Information about the class Node
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
public static boolean check(Node node1,Node node2){
    if(node1==null && node2==null)
     return true;
    if(node1==null || node2==null)
        return false;
    return check(node1.left, node2.right)
    && check(node1.right, node2.left);
}
static boolean isFoldable(Node node){
 if(node==null || (node.left==null && node.right==null)) {
     return true;
 }
return check(node.left,node.right);
}


/*
Foldable or Not
easy
Problem Statement
Given a binary tree, check if the tree can be folded or not. A tree can be folded if left and right subtrees of the tree are mirror images of each other. An empty tree is considered as foldable.
Consider the below trees:
(a) and (b) can be folded.
(c) and (d) cannot be folded.

Input
User Task:
Since this will be a functional problem. You don't have to take input. You just have to complete the function isFoldable() that takes "root" node as parameter.

Constraints:
1 <= T <= 100
1 <= N <= 10^3
1 <= node values <= 10^4

Sum of "N" over all testcases does not exceed 10^5

For Custom Input:
First line of input should contains the number of test cases T. For each test case, there will be two lines of input.
First line contains number of nodes N. Second line will be a string representing the tree as described below:
The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.
Note: If a node has been declared Null using 'N', no information about its children will be given further in the array.
Output
Return "Yes" or "<>bNo" whether the tree is Foldable or not
Example
Sample Input:
2
5
10 7 15 N 9 11 N
5
10 7 15 5 N 11 N

Sample Output:
Yes
No

Explanation:
Testcase 1: Given tree is
10
/ \
7 15
/ \ / \
N 9 11 N
Hence, above tree is structure wise same so it is foldable.
Testcase 2: Given tree is
10
/ \
7 15
/ \ / \
5 N 11 N
Hence, above tree is not structure wise same so it is not foldable.
*/
