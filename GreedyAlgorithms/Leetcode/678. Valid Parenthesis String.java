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
/*
greedy solution 
we take two variable leftmin=0  and leftmax=0   and considering *=( for leftmax and *=) for leftmin
leftmin-->min ( bracket  possible
leftmax-->max ( bracket  possible
means this is range of open bracket
if leftmin<0 thn reset back to 0
and if leftmax<0 return false;

condition: if in loop leftmin<0 reset back to 0 
but if leftmax<0 return false;

at last if leftmin==0 return true else false

ex:1-->       (         *          )               *      (           )
leftmax--> 0->1-> (1+1)=2->(2-1)=1       ->(1+1)=2  ->(2+1)=3->(3-1)=2
leftmin--> 0->1-> (1-1)=0->(0-1)=-1:re->0->(0-1)=-1:0->(0+1)=1->(1-1)=0

since letmin=0 return true;

ex:2-->       (        )          )      (       (     )
leftmax--> 0->1->(1-1)=0->(0-1)=-1    since leftmax<0 return false  
leftmin--> 0->1->(1-1)=0->(0-1)=-1-->0 reset
/*
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
