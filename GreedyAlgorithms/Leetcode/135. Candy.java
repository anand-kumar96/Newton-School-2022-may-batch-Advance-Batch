//https://leetcode.com/problems/candy/
// method 01
class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int arrLR[]=new int[n];
        int arrRL[]=new int[n];
        Arrays.fill(arrLR,1);
        Arrays.fill(arrRL,1);
        // from left to right
      for(int i=1;i<n;i++){
          if(ratings[i]>ratings[i-1]){
              arrLR[i]=arrLR[i-1]+1;
          }
      }
        // from right  to left
        for(int i=n-2;i>=0;i--){
          if(ratings[i]>ratings[i+1]){
              arrRL[i]=arrRL[i+1]+1;
          }
      }
        int totalCandy=0;
        // taking max between both
        
        for(int i=0;i<n;i++){
            totalCandy+=Math.max(arrLR[i],arrRL[i]);
        }
        return totalCandy;
    }
}
