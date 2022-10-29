// https://leetcode.com/problems/jump-game/
// method 01
class Solution {
    /*
    start from last index if  you reach thn makke your destination to lastindex -1 as destination and at last if lastindex==0 return true
    */
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int destinationIndex=n-1;
        for(int i=n-1;i>=0;i--){
            if(i+nums[i]>=destinationIndex){
                destinationIndex=i;
            }
        }
        return destinationIndex==0;
    }
}


//method 02
class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int maxjump=nums[0];
        if(maxjump==0 && n>1){
             return false;
        }
           
        for(int i=1;i<n;i++){
            maxjump--;
            if(maxjump<nums[i]){
                maxjump=nums[i];
            }
            if(maxjump<=0 && i!=(n-1)){
                return false;
            }
        }
        return true;
    }
}

