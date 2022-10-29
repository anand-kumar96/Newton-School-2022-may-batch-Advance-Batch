//https://leetcode.com/problems/jump-game-ii/
//method 01
class Solution {
    public int jump(int[] nums) {
        int reachingPosition=0;// reaching or maxdistance in a particular position
        int max=0;
        int count=0;// minimum step to reach destination
        for(int i=0;i<nums.length-1;i++){
            max=Math.max(max,nums[i]+i);
            if(i==reachingPosition){
                count++;
                reachingPosition=max;
              //  max=0; // or not write no issue
            }
        }
        return count;
    }
}

// method 02 --> class
class Solution {
public int jump(int[] nums) {
        int numberOfJumps = 0;
        int currentRangeEnd = 0;
        int farthest = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if(i == currentRangeEnd) {
                currentRangeEnd = farthest;
                numberOfJumps++;
            }
        }

        return numberOfJumps;
    }
        }
