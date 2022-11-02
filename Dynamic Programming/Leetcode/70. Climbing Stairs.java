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
