/*
Ancestral Path Sum
medium
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given a binary tree of N nodes, with root 1 and Q queries with nodes u and v. For each query find the sum of nodes on the shortest path from u to v, where node v is the ancestor of node u.
Input
First line contains the integer N and Q, denoting the number of nodes in the binary tree and the number of queries respectively.
Next N lines contains two integers denoting the left and right child of the i'th node respectively.
If the node doesn't have a left or right child, it is denoted by '-1'
Next Q lines contain two integers u and v
1 <= N <= 10000
1 <= Q <= 100000
1 <= u, v <= N
Output
Print Q lines denoting the sum of nodes on the shortest path from u to v
Example
Sample Input 1:
6 3
2 4
5 3
-1 -1
-1 -1
6 -1
-1 -1
6 2
3 1
5 5
Sample output 1:
13
6
5

Explanation: Given binary tree
1
/ \
2 4
/ \
5 3
/
6
Query 1: 6+5+2 = 13
Query 2: 3+2+1 = 6
Query 3: 5

*/
