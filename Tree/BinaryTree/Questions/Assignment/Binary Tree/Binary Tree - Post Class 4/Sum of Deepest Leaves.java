//method 01
/*
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

//ietrative
static int deepestLeavesSum(Node root){
    int res = 0;
    if (root == null) return res;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int curSum = 0;
        int len = queue.size();
        for (int i = 0; i < len; i++) {
            Node cur = queue.poll();
            curSum += cur.data;
            if (cur.left != null)
                queue.offer(cur.left);
            if (cur.right != null)
                queue.offer(cur.right);
        }
        res = curSum;
    }
    return res;
}

// method 02

// recursive
 int answer = 0;
 int maxHeight = -1;
static int deepestLeavesSum(Node root){
  search(root,0);
  return answer;
}
public static void search(Node root,int currHeight){
    if(root==null)  return;
    
    if(currHeight > maxHeight && root.left == null && root.right == null){
        answer = root.data;
        maxHeight = currHeight;
        return;
    }
    
    if(currHeight == maxHeight && root.left == null && root.right == null){
        answer += root.data;
        return;
    }
    
    search(root.left, currHeight + 1);
    search(root.right, currHeight + 1);
}


/*
Sum of Deepest Leaves
medium
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given a binary tree with N nodes, the task is to find the sum of deepest leaves of binary tree.

Deepest leaves: By this we mean that leaf nodes which are present at the bottom most point of the left and right subtrees of the root node. Number of deepest leaf nodes in case of left and right skewed binary tree would be 1. Which means that nodes with maximum depth are deepest leaf nodes.
Input
User Task:
Since this will be a functional problem, you don't have to take input. You just have to complete the function deepestLeavesSum() that takes "root" node as parameter.

Constraints:
1 <= T <= 40
1 <= N <= 10^5
1 <= node values <= 100

Sum of N over all testcases does not exceed 10^5
Output
For each testcase you need to return the sum of deepest leaves of binary tree in a new line. The answer would not exceed integer data type.
Example
Input:
2
4 5 3 4 N 6 1
3 5 N 6 N

Output:
11
6

Explanation:
Testcase 1:
4
/ \
5 3
/ \ / \
4 N 6 1
In case of this binary tree we have all leaf nodes at same level then they all should be considered in deepest leaf nodes category thus sum will be 11.


Testcase 2:
3
/ \
5 N
/ \
6 N
Given is left skewed binary tree 6 at the bottom most level thus we get sum as 6 only.
*/
