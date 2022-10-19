// method 01
static int minimumCoins(int Target){
        int denominations[] = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        int numberOfNotes = 0;
        for(int i = 0; i < denominations.length; i++) {
            int currentDenominationCount = Target / denominations[i];
            numberOfNotes += currentDenominationCount;
            Target = Target % denominations[i];
        }

        return numberOfNotes;
    }

// method 02
static int minimumCoins(int target){
    int count=0;
    int val=0;
if(target>=2000){
     val=target/2000;
     count+=val;
     target=target-2000*val;
} if(target>=500){
     val=target/500;
     count+=val;
     target=target-500*val;
} if(target>=200){
     val=target/200;
     count+=val;
     target=target-200*val;
} if(target>=100){
     val=target/100;
     count+=val;
     target=target-100*val;
} if(target>=50){
     val=target/50;
     count+=val;
     target=target-50*val;
} if(target>=20){
     val=target/20;
     count+=val;
     target=target-20*val;
} if(target>=10){
     val=target/10;
     count+=val;
     target=target-10*val;
} if(target>=5){
     val=target/5;
     count+=val;
     target=target-5*val;
}if(target>=2){
     val=target/2;
     count+=val;
     target=target-2*val;
} if(target>=1){
     val=target/1;
     count+=val;
     target=target-1*val;
}
return count;
}

/*
Minimum coins (Challenge)
easy
Problem Statement
Write a program to find the minimum number of coins/ notes required to make the change of A amount of money.
For this problem, you can assume that there is an unlimited supply of the various notes/coins available in the Indian currency denominations. The various denominations available are 1, 2, 5, 10, 20, 50, 100, 200, 500 and 2000.
Input
User Task:
Since this will be a functional problem, you don't have to worry about input. You just have to complete the function minimumCoins() which takes the target amount as a parameter.

Constraints:
1 <= Target < = 100000
Output
Return the minimum number of coins required.
Example
Sample Input:-
90

Sample Output:-
3

Explanation:-
50 + 20 + 20 = 90

Sample Input:-
2058

Sample Output:-
5

Explanation:-
2000 + 50 + 5 + 2 + 1
*/
