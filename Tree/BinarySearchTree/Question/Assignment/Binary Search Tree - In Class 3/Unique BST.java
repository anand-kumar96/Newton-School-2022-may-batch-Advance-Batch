// method 01
// using recursion-->give tle but lastly submit using catalan number

import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    public static int uniqueBst(int n){
        // base condition catalan of 0 and 1   is 1
     if(n<=1){
         return 1;
     }
     int result=0;
     for(int i=0;i<n;i++){
      result+=uniqueBst(i)*uniqueBst(n-i-1);
     }
     return result;
    }
    public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.println(uniqueBst(n));
    }
}

// method 02 --> using dynamic programming

import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    static int dp[]=new int[20];
    public static int uniqueBst(int n){
        // base condition catalan of 0 and 1   is 1
     if(n<=1){
         return 1;
     }
     dp[0]=dp[1]=1;
     if(dp[n]>0){
         return dp[n];
     }
     for(int i=1;i<=n;i++){
      dp[n]+=uniqueBst(i-1)*uniqueBst(n-i);
     }
     return dp[n];
    }
    public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.println(uniqueBst(n));
    }
}

// method 03 --> using dynamic programming
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    static int dp[]=new int[20];
    public static int uniqueBst(int n){
     dp[0]=dp[1]=1;
     for(int i=2;i<=n;i++){
         for(int j=0;j<i;j++){
       dp[i]+=dp[j]*dp[i-j-1]; // it giving all combination product
        }
     }
     return dp[n];
    }
    public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.println(uniqueBst(n));
    }
}

// method 04  using ncr
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	if(n<=1){
		System.out.println("1");
		return;
	}

	// best way to find ncr
	int r=2*n;
	long result=1;
	for(int i=0;i<n;i++){
     result=((result*(r-i))/(i+1));

	}
 System.out.println(result/(n+1));
    }
}


// method 05 using binomial expression

import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    public static long catalan(int n){ 
	// Calculate value of 2nCn 
	long c = binomialCoeff(2*n, n); 
	// return 2nCn/(n+1) 
	return c/(n+1); 
} 
   public static long binomialCoeff(int n,int k){ 
	long res = 1; 
	// Since C(n, k) = C(n, n-k) 
	if (k > n-k) 
		k = n-k; 
	// Calculate value of [n*(n-1)*---*(n-k+1)] / [k*(k-1)*---*1] 
	for (int i = 0; i < k; ++i) { 
		res *= (n - i); 
		res /= (i + 1); 
	} 
	return res; 
} 
    public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.println(catalan(n));
    }
}
// A Binomial coefficient based function to find nth catalan 
// number in O(n) time

/*
Unique BST
easy
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
Input
first line contain a single integer N.
Output
print number of unique BST.

Constraints:
1<=N<=19
Example
Sample Input 1:
3

Sample Output 1:
5

Explanation :
1 1 2 3 3
\ \ / \ / /
3 2 1 3 2 1
/ \ / \
2 3 1 2

These are all possible numbers of unique BST which contains a number from 1 to 3.
*/
