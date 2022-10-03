// method 01
/*
// Information about the class Node
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

*/
static int diameter;
public static int finddiameter(Node root){
    if(root==null){
        return 0;
    }
    int l=finddiameter(root.left);
    int r=finddiameter(root.right);
    diameter=Math.max(diameter,l+r);
    return Math.max(l,r)+1;
}
public static int getDiameter(Node root){
       diameter=0;
       finddiameter(root);
       return diameter+1; 
 }

/// method 02
static int longestpath;
    private static int height(Node root){
        if(root==null){
            return 0;
        }
            int lheight=height(root.left);
            int rheight=height(root.right);
            longestpath=Math.max(longestpath,lheight+rheight+1);
            return Math.max(lheight,rheight)+1;
        
    }
    public static int getDiameter(Node root) {
        longestpath=0;
        height(root);
        return longestpath;
    }

/*
Problem Statement
Given a Binary Tree, find diameter of it. The diameter of a tree is the number of nodes on the longest path between two leaves in the tree.
The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded 
(note that there is more than one path in each tree of length nine, but no path longer than nine nodes).

Input
User Task:
Since this will be a functional problem. You don't have to take input. You just have to complete the function getDiameter() that takes "root" node as parameter.

Constraints:
1 <= T <= 100
1 <= N <= 10^4
1 <= node values <= 10^3

Sum of "N" over all testcases does not exceed 10^5

For Custom Input:
First line of input should contains the number of test cases T. For each test case, there will be two lines of input.
First line contains number of nodes N. Second line will be a string representing the tree as described below:
The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.
Note: If a node has been declared Null using 'N', no information about its children will be given further in the array.
Output
Return the diameter of the tree.
Example
Sample Input:
2
3
1 2 3
5
10 20 30 40 60

Sample Output:
3
4

Explanation:
Test Case1: The tree is
1
/ \
2 3
The diameter is of 3 length.
Test Case2: The tree is
10
/ \
20 30
/ \
40 60
The diameter is of 4 length.
*/
