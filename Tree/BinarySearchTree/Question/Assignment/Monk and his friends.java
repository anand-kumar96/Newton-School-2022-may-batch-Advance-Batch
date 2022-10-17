// method 01
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int m=sc.nextInt();
   HashSet<Integer>hs=new HashSet<>();
    for(int i=0;i<n;i++){
       hs.add(sc.nextInt());
    }
    for(int i=n;i<n+m;i++){
        int candies=sc.nextInt();
       if(hs.contains(candies)){
      System.out.println("YES");
    }else{
       System.out.println("NO"); 
       hs.add(candies);
    }
}
    }
}

// method 02
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    public static boolean check(int s,int candies[]){
        int n=candies.length;
        for(int i=0;i<n;i++){
         if(candies[i]==s){
          return true;
         }
        }
        return false;
    }
    public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int m=sc.nextInt();
    int candies[]=new int[n+m];
    int i;
    for( i=0;i<n;i++){
        candies[i]=sc.nextInt();
    }
    for(int j=n;j<n+m;j++){
        int value=sc.nextInt();
        boolean ans=check(value,candies);
    if(ans==true){
      System.out.println("YES");
    }else{
       System.out.println("NO"); 
       candies[i++]=value;
    }
}
    }
}
// method 03 --> creating tree
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

public class Main {
    static Node root;
        static class Node{
            int data;
            Node left, right;
            public Node(int d){
                data =d;
                left=right=null;
        }
        }
        public static Node insertInBST(Node root,int key){
            if(root==null){
                Node newNode=new Node(key);
                root=newNode;
                return root;
            }
            if(key>root.data){
                root.right=insertInBST(root.right,key);
            }
            if(key<root.data){
                root.left=insertInBST(root.left,key);
            }
            return root;
        }
        public static boolean exist(Node root,int key){
            if(root!=null){
                if(root.data==key){
                    return true;
                }
                if(key<root.data){
                    return exist(root.left,key);
                }else if(root.data<key){
                    return exist(root.right,key);
                }
            }
            return false;
        }
        public static void main (String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int m=sc.nextInt();
            for(int i=0;i<n;i++){
                int key=sc.nextInt();
                root=insertInBST(root,key);
            }
        for(int i=n;i<n+m;i++){
            int key=sc.nextInt();
            if(exist(root,key)){
                System.out.println("YES");
                }
                else{
                System.out.println("NO");
                root=insertInBST(root,key);
            }
        }
    }
}

/*
Monk and his friends
medium
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Monk is standing at the door of his classroom. There are currently N students in the class, i'th student got Ai candies.
There are still M more students to come. At every instant, a student enters the class and wishes to be seated with a student who has exactly the same number of candies. For each student, Monk shouts YES if such a student is found, NO otherwise.
Input
First line contains two space- separated integers N and M.
Second line contains N + M space- separated integers, the candies of the students.
Output
output M new line, Monk's answer to the M students.
Print "YES" (without the quotes) or "NO" (without the quotes) pertaining to the Monk's answer.

Constraints:
1 ≤ N, M ≤ 100000
0 ≤ Ai ≤ 1000000000
Example
Sample Input 1:
2 3
3 2 9 11 2

Sample Output 1:
NO
NO
YES

Explanations:
Initially students with 3 and 2 candies are in the class.
A student with 9 candies enters, No student with 9 candies in class. Hence, "NO"
A student with 11 candies enters, No student with 11 candies in class. Hence, "NO"
A student with 2 candies enters, Student with 2 candies found in class. Hence, "YES"
*/
