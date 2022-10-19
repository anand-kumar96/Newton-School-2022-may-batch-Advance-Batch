// method 01
static int minDistanceCoveredBySara(int N){
if((N%4==0) || ((N+1)%4==0)){
    return 0;
}
    return 1;
}
// method 02
static int minDistanceCoveredBySara(int N){
        int n = 0;
        n = (N * (N + 1)) / 2;
        if(n % 2 == 1) {
            return 1;
        }
            return 0;
        }
/*
Sara's Game
easy
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Sara is trying a new type of game in which she can jump in either the left direction or in the right direction. Also after each jump the range of her jump increases by 1 unit. i.e if starts from 1 in the next jump she has to jump 2 units then 3 units and so on.
Given the number of jumps as N, the range of the first jump to be 1. What will be the minimum distance Sara can be at from the starting point.
Input
User Task:
Since this will be a functional problem, you don't have to take input. You just have to complete the function minDistanceCoveredBySara() that takes integer N as an argument.

Constraints:-
1 <= N <= 1000
Output
Return the minimum distance Sara can be at from the starting point.
Example
Sample Input:-
3

Sample Output:-
0

Explanation:-
First jump:- right
Second jump:- right
Third jump:- left
Total distance covered = 1+2-3 = 0

Sample Input:-
5

Sample Output:-
1
*/
