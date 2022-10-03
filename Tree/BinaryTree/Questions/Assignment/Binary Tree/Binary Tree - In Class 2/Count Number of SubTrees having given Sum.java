/*

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
static int count;
static int findsum(Node root, int x){
    if(root==null){
        return 0;
    }
int leftsum=findsum(root.left,x);
int rightsum=findsum(root.right,x);
     if((leftsum+rightsum+root.data)==x){
         count++;
     }
     return (leftsum+rightsum+root.data);
}
static int countSubtreesWithSumX(Node root, int x){
    count=0;
    findsum(root,x);
     return count;
}

//method 02 
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
static int count;
static int findsum(Node root, int x){
    if(root==null){
        return 0;
    }
int leftsum=findsum(root.left,x);
int rightsum=findsum(root.right,x);
if((leftsum+rightsum+root.data)==x){
         count++;
     }
     //System.out.println(count);
     return (leftsum+rightsum+root.data);
}
static int countSubtreesWithSumX(Node root, int x){
    count=0;
    if(root==null){
        return 0;
    }
    int l= findsum(root.left,x);
    int r= findsum(root.right,x);
    if(l+r+root.data==x){
        count++;
    }
     return count;
}



// method 03

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
static class INT{
    int v;
    INT(int a)
    {
        v = a;
    }
}
static int countSubtreesWithSumXUtil(Node root,INT count, int x){
    if (root == null)
        return 0;
    int ls = countSubtreesWithSumXUtil(root.left,count, x);
    int rs = countSubtreesWithSumXUtil(root.right,count, x);
    int sum = ls + rs + root.data;
    if (sum == x)
        count.v++;
    return sum;
}
static int countSubtreesWithSumX(Node root, int x){
    if (root == null)
        return 0;
    INT count = new INT(0);
    int ls = countSubtreesWithSumXUtil(root.left,count, x);
    int rs = countSubtreesWithSumXUtil(root.right,count, x);
    if ((ls + rs + root.data) == x)
        count.v++;
    return count.v;
}

/*
Count Number of SubTrees having given Sum
easy
Problem Statement
Given a binary tree containing with N nodes and an integer X. Your task is to complete the function countSubtreesWithSumX() that returns the count of the number of subtress having total node’s data sum equal to a value X.
Example: A tree given below

Input
User Task:
Since this will be a functional problem. You don't have to take input. You just have to complete the function countSubtreesWithSumX() that takes "root" node and the integer x as parameter.

Constraints:
1 <= T <= 100
1 <= N <= 10^3
1 <= node values <= 10^4

Sum of "N" over all testcases does not exceed 10^5
Output
Return the number of subtrees with sum X. The driver code will take care of printing it.
Example
Sample Input:
1
3 5
1 2 3


Sum=5
Tree:-
1
/ \
2 3

Sample Output:
0

Explanation:
No subtree has a sum equal to 5.

Sample Input:-
1
5 5
2 1 3 4 5

Sum=5
Tree:-
2
/ \
1 3
/ \
4 5

Sample Output:-
1
*/
