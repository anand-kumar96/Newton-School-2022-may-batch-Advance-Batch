//https://leetcode.com/problems/lemonade-change/
//01
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;
        for(int coin:bills){
            if(coin==5){
                five++;
            }else if(coin==10){
                ten++;
                five--;
            }else {
                if(ten>0 && five>0){
                ten--;
                five--;
            }else{
                five-=3;
            }
            }
            if(five<0){
                return false;
            }
        }
        return true;
    }
}

// 02
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        for(int bill : bills) {
            if(bill == 5) {
                fiveCount++;
            }
            else if(bill == 10) {
                tenCount++;
                fiveCount--;
            }
            else {
                if(tenCount > 0 && fiveCount > 0) {
                    tenCount--;
                    fiveCount--;
                }
                else {
                    fiveCount -= 3;
                }
            }
            if(fiveCount < 0) {
                return false;
            }
        }
        return true;
    }
}
