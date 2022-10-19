// method 01
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int divisor = 2;
        boolean result = true;
        for(int j = 1; j < N; j++) {
            while(divisor <= arr[j] && arr[j] % divisor != 0) {
                divisor++;
            }
            if(divisor > arr[j]) {
                result = false;
                break;
            }
            divisor++;
        }

        if(result) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
/*
Increasing array
easy
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Abhijit has an Array Arr which may or may not be in strictly increasing order. He wants to make this array increasing but does not wish to change the position of any element so he came with an idea that he will replace an element with any of its divisors i.e he changes an element X to M if X%M=0.

Your task is to tell whether the given array can be transformed to strictly increasing by performing the operation given above.
Input
First line of input contains the size of the array N. Next line of input contains N space- separated integers depicting the values of the array Arr.

Constraints:-
1 <= N <= 100000
1 <= Arr[i] <= 100000
Output
Print "YES" if the array can be transformed in the strictly increasing order else print "NO".
Example
Sample Input:-
5
1 2 16 16 16

Sample Output:-
YES

Sample Input:-
4
1 3 8 4

Sample Output:-
NO
*/
