// method 01
static int Phone(int N, int K, int M){
int totalmemory=N*K;
int ans=0;
int app;
if(M%K==0){
     app=M/K;
    if(app>N){
        return -1;
    }else{
        ans=app;
    }
}else{
    app=M/K+1;
    if(app>N){
        return -1;
    }else{
         ans=app;
    }
}
return ans;
}
// method 02
static int Phone(int N, int K, int M){
        //Enter your code here
        if(N * K < M) {
            return -1;
        }

        int numberOfApps = M / K;

        if(M % K != 0) {
            numberOfApps++;
        }

        return numberOfApps;
    }

/*
Sara's Phone (Functional Problem)
easy
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Sara's Phone has N apps and each app takes K unit of memory. Now Sara wants to release M units of memory. Your task is to tell the minimum apps Sara needs to delete or say it is not possible.
Input
User Task:
Since this will be a functional problem, you don't have to take input. You just have to complete the function Phone() that takes integers N, K, and M as arguments.

Constraints:-
1 <= N <= 1000
1 <= K <= 100
0 <= M <= 10000
Output
Return minimum apps to delete and if it is not possible return -1.
Example
Sample Input:-
10 3 10

Sample Output:-
4

Sample Input:-
10 3 40

Sample Output:-
-1
*/
