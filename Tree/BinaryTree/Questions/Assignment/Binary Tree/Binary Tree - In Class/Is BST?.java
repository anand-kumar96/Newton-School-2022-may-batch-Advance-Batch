// https://my.newtonschool.co/playground/code/1koxzoled8g2/
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed

class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}

class Main {
	public static boolean isBST(Node tree, int min, int max){
    	if(tree == null)
			return true;
		if(tree.data < min || tree.data > max)
			return false;
		return isBST(tree.left, min, tree.data - 1) && isBST(tree.right, tree.data + 1, max);
	}

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node[] tree = new Node[n];
		for(int i = 0; i < n; i++){
			int value = sc.nextInt();
			tree[i] = new Node(value);
		}
		int root = sc.nextInt();
		 for(int i = 0; i < n; i++){
			int left = sc.nextInt();
			int right = sc.nextInt();
			if(left != 0)
				tree[i].left = tree[left - 1];
			if(right != 0)
				tree[i].right = tree[right - 1];
		}

		if(isBST(tree[root-1], Integer.MIN_VALUE, Integer.MAX_VALUE)){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
	}
}


/*
Is BST?
easy
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given a binary tree with n nodes (numbered from 1 to n) having weight wi and left and right children (li, ri), find whether the given tree is BST or not.
Input
The first line of the input contains an integer n, the number of nodes in the tree.
The second line of input contains n integers, the values of the nodes of the tree.
The third line of the input contains an integer, denoting the root node of the tree.
Next n lines contain two integers l, r denoting the left and right child of the tree. (The value is 0 if there is no left or right child)

Constraints
1 <= n <= 50000
0 <= l, r <= n (0 denotes no child)
1 <= w <= 1000000000
Output
Output "YES" if the given tree is BST, else output "NO"
Example
Sample Input
5
10 3 9 2 1
4
3 0
0 0
2 0
5 1
0 0

Sample Output
YES
*/
