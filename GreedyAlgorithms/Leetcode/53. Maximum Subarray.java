//https://leetcode.com/problems/maximum-subarray/
// brute force approach
class Solution {
    public int maxSubArray(int[] nums) {
        int sum;
        int maxsum=Integer.MIN_VALUE;;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                  sum=0;
                for(int k=i;k<=j;k++){
                  sum+=nums[k];
            }
             maxsum=Math.max(sum,maxsum);
            }
            
        }
        return maxsum;
    }
}
// optimized 
class Solution {
    public int maxSubArray(int[] nums) {
        // kadane's algorithm
        int sum=nums[0];
        int maxsum=nums[0];
        int firstsum=nums[0];
        for(int i=1;i<nums.length;i++){
             if(sum<0){
                sum=0;
            }
            sum+=nums[i];
            maxsum=Math.max(maxsum,sum);
            firstsum=Math.max(firstsum,nums[i]);
        }
        if(firstsum<0){
            return firstsum;
        }
        return maxsum;
    }
}
// method 02
class Solution {
   public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxElement = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum < 0) {
                sum = 0;
            }
            maxSum = Math.max(maxSum, sum);
            maxElement = Math.max(maxElement, nums[i]);
        }
        if(maxSum == 0) {
            maxSum = maxElement;
        }
        return maxSum;
    }
}
