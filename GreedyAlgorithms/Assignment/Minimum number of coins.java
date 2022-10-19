// method 01
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
    int tc=sc.nextInt();
    while(tc-->0){
    int target=sc.nextInt();
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
System.out.println(count);
}
}
}
// method 02
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
   private int minimumCoins(int Target){
        int denominations[] = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        int numberOfNotes = 0;
        for(int i = 0; i < denominations.length; i++) {
            int currentDenominationCount = Target / denominations[i];
            numberOfNotes += currentDenominationCount;
            Target = Target % denominations[i];
        }
        return numberOfNotes;
    }
    public static void main(String[] args) {
        MinimumNumberOfCoins minimumNumberOfCoins = new MinimumNumberOfCoins();
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 0; i < T; i++) {
            int target = scanner.nextInt();
            int numberOfCoins = minimumNumberOfCoins.minimumCoins(target);
            System.out.println(numberOfCoins);
        }
    }
}
/*
Minimum number of coins
easy
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Write a program to find the minimum number of coins/ notes required to make the change of A amount of money.
For this problem, you can assume that there is an unlimited supply of the various notes/coins available in the Indian currency denominations. The various denominations available are 1, 2, 5, 10, 20, 50, 100, 200, 500 and 2000.
Input
The first line of the input contains the number of test cases T.
Each test case contains a single input A(amount).

Constraints:
1 <= T <= 100000
1 <= A <= 10^5
Output
For each test case, print the minimum number of changes of amount A.
Example
Input:
5
90
110
131
1111
23

Output:
3
2
4
5
3

Explanation:-
A = 90
O/P = 3 [50, 20, 20]

A = 120
O/P = 2 [100, 20]
*/
