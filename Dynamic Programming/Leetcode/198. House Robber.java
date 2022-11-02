//https://leetcode.com/problems/house-robber/
// method 01 --> with array                         --> theory on copy
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        // at every point we need to make decision
        int dpRob[]=new int[n+2];
        int a=0,b=0; // f(n+1)-->0 // f(n)-->0 
        for(int i=n-1;i>=0;i--){
            a=nums[i]+dpRob[i+2];
            b=dpRob[i+1];
            dpRob[i]=Math.max(a,b);
        }
        return dpRob[0];
    }
}

// method 2 without array--> left to right iteration
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        // at every point we need to make decision
        
        int c=0;  // f(n-1)
        int d=0;  //for f(n-2)
        int a=0;
        int b=0;
        int current=0;
        for(int i=0;i<n;i++){
           a=d+nums[i];
           b=c;
           current=Math.max(a,c);
           d=c;
           c=current;
        }
        return current;
    }
}
// method 03--> right to left iteration
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        // at every point we need to make decision
        // if we start from n--> Max(nums[n]+f(n+2),f(n+1))
        int d=0;  //for f(n+2)
        int c=0;  // for f(n+1)
        int a=0;
        int b=0;
        int current=0;
        for(int i=n-1;i>=0;i--){
           a=d+nums[i];
            b=c;
           current=Math.max(a,c);
           d=c;
           c=current;
        }
        return current;
    }
}
