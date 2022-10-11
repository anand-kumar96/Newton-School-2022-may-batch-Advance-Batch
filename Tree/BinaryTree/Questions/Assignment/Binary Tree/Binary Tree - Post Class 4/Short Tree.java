/*
Short Tree
hard
hint
Hint

Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given a tree with N nodes,

Saloni wants to put weights on all edges of the tree so that all weights are non-negative real numbers and their sum is s. At the same time, she wants to make the diameter of the tree as small as possible.

Let's define the diameter of a weighed tree as the maximum sum of the weights of the edges lying on the path between two some vertices of the tree. In other words, the diameter of a weighed tree is the length of the longest simple path in the tree, where length of a path is equal to the sum of weights over all edges in the path.

Find the minimum possible diameter that Saloni can get.
Input
The first line contains two integer numbers n and s, the number of vertices in the tree and the sum of edge weights.

Each of the following n−1 lines contains two space-separated integer numbers ai and bi (1≤ ai, bi ≤n, ai≠bi) — the indexes of vertices connected by an edge. The edges are undirected.

It is guaranteed that the given edges form a tree.

Constraints
1 <= n <= 100000
1 <= s <= 1000000000
Output
If the minimum diameter of the tree that Vanya can get by placing some non-negative real weights on its edges with the sum equal to s is d, print floor(d).
Example
Sample Input
4 3
1 2
1 3
1 4

Sample Output
2

Sample Input
5 5
1 2
2 3
3 4
3 5

Sample Output
3

Explanation:
In the first sample, we place 1 weight on each of the given edges.
In the second sample, we place weights 1.6666... on edges (1, 2), (3, 4), (3, 5). Therefore, minimum diameter achieved is equal to 3.333...
*/
