/*
 // Information about the class Node
    class Node
    {
        int data;
        Node left,right;
        Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
    }
*/
static ArrayList<Integer> zigZagTraversal(Node root){
   int count=0;
        ArrayList<Integer>list1=new ArrayList<>();
        ArrayList<Integer>list2=new ArrayList<>();
        if(root!=null){
            Queue<Node>queue=new LinkedList<>();
            queue.add(root);
            queue.add(null);
            while(!queue.isEmpty()){
                Node temp=queue.poll();
                if(temp!=null){
                    list2.add(temp.data);
                    if(temp.left!=null){
                        queue.add(temp.left);
                    }
                    if(temp.right!=null){
                        queue.add(temp.right);
                    }
                }else{
                    ArrayList<Integer>list3=new ArrayList<>(list2);
                    if(count%2==1){
                     Collections.reverse(list3); 
                     for(int i=0;i<list3.size();i++){
                       list1.add(list3.get(i));
                     }
                       list3.clear();
                    }else{
                       for(int i=0;i<list3.size();i++){
                       list1.add(list3.get(i));
                     }
                       list3.clear();
                    }
                     list2.clear();   
                    count++;
                    if(!queue.isEmpty()){
                        queue.add(null);
                    }
                }
            }
             
        }
        return list1;
    }

/*
Given a Binary Tree containing N nodes. The task is to print the nodes of binary tree in ZigZag manner. Below diagram shows nodes of binary tree printed in ZigZag manner.

ZigZag: While traversing binary tree level wise you have print the nodes from left to right and then right to left alternatively i.e. first level from left to right,
next level right to left, then again left to right and so on.

Input
User Task:
Since this will be a functional problem, you don't have to take input. 
You just have to complete the function zigZagTraversa() that takes "root" node as parameter and The printing is done by the driver code.

Constraints:
1 <= T <= 50
1 <= N <= 10^4

Sum of N over all testcases does not exceed 10^5

Output
For each test case you need to return the ArrayList containing node values of binary tree in ZigZag manner. The driver code will take care of printing them up.
Example
Input:
2
3 2 1
7 7 9 8 8 6 N 10 9

Output:
3 1 2
7 9 7 8 8 6 9 10

Explanation:
Testcase 1: Given tree is
3
/ \
2 1
Hence the zigzag traversal will be 3 1 2.
Testcase 2: Given tree is
7
/ \
7 9
/ \ / \
8 8 6 N
/ \
10 9
Hence the zigzag traversal will be 7 9 7 8 8 6 9 10.
*/
