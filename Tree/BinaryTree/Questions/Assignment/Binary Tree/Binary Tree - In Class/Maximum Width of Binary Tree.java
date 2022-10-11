// mehod 01
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
static int getMaxWidth(Node root){
   if(root==null) return 0;
   int res=0;
   Queue<Node> qu=new LinkedList<>();
   qu.add(root);
   qu.add(null);
   List<List<Integer>>  ans=new ArrayList<>();
   List<Integer> t=new ArrayList<>();
   while(!qu.isEmpty()){
      Node temp=qu.poll();
      if(temp!=null){
         t.add(temp.data) ;
         if(temp.left!=null) qu.add(temp.left);
         if(temp.right!=null) qu.add(temp.right);
      }else{
        List<Integer> t2=new ArrayList<>(t);
        ans.add(t2);
        t.clear();
        if(!qu.isEmpty()){
           qu.add(null); 
        }  
      } 
   }
   for(List<Integer> ls:ans){
       res=Math.max(res,ls.size());
   }
   return res;
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
static int getMaxWidth(Node root){
    if(root==null) return 0;
    int res=0;
    List<List<Integer>>treeDta=new ArrayList<>();
    Queue<Node>q=new LinkedList<>();
    List<Integer>currentList=new ArrayList<>();
    q.add(root);
    q.add(null);
    while(!q.isEmpty()){
        Node temp=q.poll();
        if(temp!=null){
            currentList.add(temp.data);
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }else{
           List<Integer>tempList=new ArrayList<>(currentList); 
           treeDta.add(tempList);
           res=Math.max(res,currentList.size());
            currentList.clear();
            if(!q.isEmpty()){
                q.add(null);
            }
        }
    }
    return res;
}
/*
Maximum Width of Binary Tree
medium
Problem Statement
Given a Binary Tree, find the maximum width of it. Maximum width is defined as the maximum number of nodes in any level.

For example, maximum width of following tree is 4 as there are 4 nodes at 3rd level.

1
/ \
2 3
/ \ / \
4 5 6 7
\
8
Input
User Task:
Since this will be a functional problem. You don't have to take input. You just have to complete the function getMaxWidth() that takes "root" node as parameter.

Constraints:
1 <= T <= 100
1 <= N <= 10^5
1 <= node values <= 10^5

Sum of "N" over all testcases does not exceed 10^6

For Custom Input:
First line of input should contains the number of test cases T. For each test case, there will be two lines of input.
First line contains number of nodes N. Second line will be a string representing the tree as described below:
The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.
Note: If a node has been declared Null using 'N', no information about its children will be given further in the array.
Output
Return the maximum width of Binary Tree.
Example
Sample Input:
2
3
1 2 3
5
10 20 30 40 60

Sample Output:
2
2

Explanation:
Testcase1: The tree is
1
/ \
2 3
The second level has 2 nodes and hence the width is 2.
Testcase2: The tree is
10
/ \
20 30
/ \
40 60
Both second and third level have 2 nodes and hence max width is 2.
*/
