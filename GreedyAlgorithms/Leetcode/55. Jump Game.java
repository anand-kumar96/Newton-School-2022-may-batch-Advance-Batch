//method 01
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

// method 02
