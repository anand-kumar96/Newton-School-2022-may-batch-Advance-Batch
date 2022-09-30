/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
  static void levelOrder(Node root){
    Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }

        }
    }

/*
Level order traversal of a tree
easy
Problem Statement
Write a function to print the level order traversal of a tree.

The level order traversal of a tree can be obtained by visiting every node of a tree level-wise from top to down and left to right direction.

Example:

1
/ \
2 4 The level order traversal of the following tree will be 1 2 4 5 6 3 7 9 8.
/ \ / \
5 6 3 7
/ \
9 8
Input
User task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function Levelorder() that takes root of both the trees as input.

Constraints:
1 <= T <= 20
1 <= N <= 200
1 <= Data of Nodes <= 500

For Custom Input:
First line of input should contains the number of test cases T. For each test case, there will be two lines of input.
First line contains number of nodes N. Second line will be a string representing the tree as described below:
Here the first integer will represent the parent node, second will represent the child node, and the third character ("L" or "R") will represent whether that node is the left child or the right child. Also, the first integer in the string will become the value of the root. A string with the value of "1 3 L 1 2 R 2 8 R 8 9 L 3 5 L 3 7 R" will represent the following tree.
Output
For each test case, the function will print the level order traversal of the tree.
Example
Sample Input:
2
11
1 2 L 1 3 R 2 4 L 2 5 R 3 6 L 3 7 R 5 8 L 5 9 R 7 10 L 7 11 R
5
1 3 L 1 2 R 2 5 L 2 4 R

Sample Output:
1 2 3 4 5 6 7 8 9 10 11
1 3 2 5 4
*/
