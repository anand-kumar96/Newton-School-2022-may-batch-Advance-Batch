// method 01
//https://leetcode.com/problems/valid-parenthesis-string/
class Solution {
    public boolean checkValidString(String s) {
      Stack<Integer>bracket=new Stack<>();
      Stack<Integer>asterisks=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            // for'('
            if(ch=='('){
                bracket.push(i);
                
                // for '*'
            }else if(ch=='*'){
               asterisks.push(i);
                
                 // for ')' 
                
            }else if(!bracket.isEmpty()){
                  bracket.pop();
              }else if(!asterisks.isEmpty()){
                  asterisks.pop();
            }else{
                  return false;
              }
        }
        
        // check open bracket with asterisks
        while(!bracket.isEmpty() && !asterisks.isEmpty() 
              && bracket.peek()<asterisks.peek()){ // asterisks bad me aane chiye '(' ke
             bracket.pop();
            asterisks.pop();
        }
        
        // now check braket is empty or not only check for bracket not asterisks
        
   // return bracket.isEmpty();
        // or
         if(bracket.isEmpty()){
             return true;
         }
        return false;
    }
}
// method 02
class Solution {
    public boolean checkValidString(String s) {
    int length=s.length();
        int count1=0;
        int count2=0;
        for(int i=0;i<length;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                count1++;
                 count2++;
            }else if(ch==')'){
                count1--;
                count2--;
            }else if(ch=='*'){
                count1++;
                count2--;
            }
      if(count1<0){
          return false;
          }
        count2 = Math.max(count2, 0);
        }
     
        return count2==0;
    }
}
