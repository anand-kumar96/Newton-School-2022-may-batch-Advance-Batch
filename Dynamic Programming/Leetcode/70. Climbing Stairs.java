//https://leetcode.com/problems/climbing-stairs/
/*
Explanation
n=1--->1
n=2--->2
n=3--->3
n=4--->5
n=5--->8
so a Sequenece is forming i.e. add of previous two number
*/
// Using array
class Solution {
    public int climbStairs(int n) {
        if(n==1 || n==2) return n;
         int arr[]=new int[n+1];
        arr[1]=1;
        arr[2]=2;
        for(int i=3;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}

// method 02
class Solution {
    // without using array
    public int climbStairs(int n) {
        if(n==1 || n==2) return n;
        int first=1;
        int second=2;
        int third=0;
        for(int i=3;i<=n;i++){
           third=first+second;
            first=second;
            second=third;
        }
        return third;
    }
}
