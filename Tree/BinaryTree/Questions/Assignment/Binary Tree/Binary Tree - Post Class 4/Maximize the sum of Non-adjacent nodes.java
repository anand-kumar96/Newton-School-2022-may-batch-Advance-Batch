/*
// Information about the class Node
class Node
{
    int data;
    Node left, right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

*/
static Map<Node,Integer> m=new HashMap<>();
static int getMaxSum(Node root){
        if(root==null) return 0;
        if(m.containsKey(root)) return m.get(root); 
        int withnode=root.data;
        if(root.left!=null){
            withnode+=getMaxSum(root.left.left);
            withnode+=getMaxSum(root.left.right);
        }
        if(root.right!=null){
            withnode+=getMaxSum(root.right.left);
            withnode+=getMaxSum(root.right.right);
        }
        
        int withoutnode = getMaxSum(root.left) +  getMaxSum(root.right);
        
        m.put(root,Math.max(withnode,withoutnode));
        return Math.max(withnode,withoutnode);
    }

/*
Maximize the sum of Non-adjacent nodes
medium
Problem Statement
Given a binary tree with a value associated with each node, we need to choose a subset of these nodes such that sum of chosen nodes is maximum under a constraint that no two chosen node in subset should be directly connected, that is, if we have taken a node in our sum then we can’t take any of its children(one/two) in consideration and vice versa.

Input
User Task:
Since this will be a functional problem, you don't have to take input. You just have to complete the function getMaxSum() that takes "root" node as parameter.

Constraints:
1 <= T <= 80
1 <= N <= 10^5

Sum of N over all testcases does not exceed 10^6
Output
For each test case you need to return the maximum sum such that no two nodes are adjacent. The answer does not exceed integer data type. The driver code will take care of new line.
Example
Input:
2
11 1 2
1 2 3 4 N 5 6

Output:
11
16

Explanation:

Testcase 1: binary tree structure
11
/ \
1 2

The maximum sum is sum of node 11.

Testcase 2: binary tree structure
1
/ \
2 3
/ \ / \
4 N 5 6
The maximum sum is sum of nodes 1 4 5 6 , i.e 16. These nodes are non adjacent.
*/
