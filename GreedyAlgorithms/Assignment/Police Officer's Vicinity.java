// method 01
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
    int N=sc.nextInt();
    int E=sc.nextInt();
    int X0=sc.nextInt();
    int Y0=sc.nextInt();
    int B=sc.nextInt();
    int X[]=new int[B];
    int Y[]=new int[B];
    for(int i=0;i<B;i++){
        X[i]=sc.nextInt();
        Y[i]=sc.nextInt();
    }
    //North side
    int value=Integer.MAX_VALUE;
    int sum=0;
    boolean flag=false;
    for(int i=0;i<B;i++){
        if(X0==X[i]){
            if(Y0>Y[i]){
                flag=true;
            int v=Y0-Y[i]-1;
            if(v>0){
          value=Math.min(value,v);
        }else{
            value=0;
        }
    }
   }
    }
    if(flag==false){
        sum+=Y0-1;
    }else{
        sum+=value;
    }

// South side
value=Integer.MAX_VALUE;
   flag=false;
   for(int i=0;i<B;i++){
       if(X0==X[i]){
           if(Y0<Y[i]){
               flag=true;
               int v=Y[i]-1-Y0;
               if(v>0){
               value=Math.min(value,v);
               }else{
                   value=0;
               }
           }
       }
   }
   if(flag==false){
       sum+=N-Y0;
   }else{
       sum+=value;
   }
   // East side
 value=Integer.MAX_VALUE;
 flag=false;
 for(int i=0;i<B;i++){
     if(Y0==Y[i]){
      if(X0>X[i]){
          flag=true;
          int v=X0-1-X[i];
          if(v>0){
              value=Math.min(value,v);
          }else{
              value=0;
          }
      }
     }
 }
 if(flag==false){
     sum+=X0-1;
 }else{
     sum+=value;
 }
 // West side
 value=Integer.MAX_VALUE;
 flag=false;
 for(int i=0;i<B;i++){
     if(Y0==Y[i]){
         if(X0<X[i]){
             flag=true;
             int v=X[i]-1-X0;
             if(v>0){
                 value=Math.min(value,v);
             }else{
                 value=0;
             }
         }
     }
 }
 //System.out.println(flag);
 if(flag==false){
     sum+=E-X0;
 }else{
     sum+=value;
    }
   System.out.println(sum);
    }
}
// method 02
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxNorth = scanner.nextInt();
        int maxEast = scanner.nextInt();
        int policeX = scanner.nextInt();
        int policeY = scanner.nextInt();
        int numberOfBarriers = scanner.nextInt();
        int up = maxNorth;
        int down = 1;
        int left = 1;
        int right = maxEast;
        for(int i = 0; i < numberOfBarriers; i++) {
            int barrierX = scanner.nextInt();
            int barrierY = scanner.nextInt();
            if(barrierX == policeX) {
                //barrier behind the police
                if(barrierY < policeY) {
                    down = barrierY + 1;
                }
                //barrier in-front of the police
                else {
                    up = barrierY - 1;
                }
            }
            else if(barrierY == policeY) {
                //barrier is on the left side of the police
                if(barrierX < policeX) {
                    left = barrierX + 1;
                }
                //barrier is on the right side of the police
                else {
                    right = barrierX - 1;
                }
            }
        }

        int answer = (up - down) + (right - left);

        System.out.println(answer);
    }
}
/*
Police Officer's Vicinity
easy
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Somewhere, at some point of time, there was/will be a vehicular traveling system where 1 Kilometre is the basic unit of traversal, that is a vehicle can either stay at rest or can travel distance which is multiple of 1 Km i. e., 2, 3, 4, 10, 35 Km are valid but 2.5, 6.34, 0.25 Km are invalid.
During the age of this system, there is a traffic policeman who stands at the intersection of 4 roads. Due to Development in the City, there are a few barriers placed on some of the roads at some distance from the intersection point.
Measurements are according to the cartesian coordinates, each unit representing a kilometer. You enter into the system and are provided with a coordinate of the Intersection point and the maximum north distance a vehicle can cover, the maximum eastern distance a vehicle can cover and the coordinates of the barrier.
You have to tell the sum of the total kilometers in which the policeman has the vicinity.

Example:
> The Coordinate of Intersection point: 4, 3
> The maximum north distance = 8Km
> The maximum East distance = 8Km
Coordinates of barrier = (1, 3); (4, 6); (5, 3).
Input
First- line contains 2 integers denoting maximum north and east distance.
Second- line contains 2 integers denoting the coordinate of the intersection.
the third line contains an integer ‘k’ denoting the number of barriers
next line contains the coordinate of barriers.

Constraints:-
1<=north distance, east distance<=10000
(0, 0) <=coordinates of intersection<= (10000, 10000)
1<=number of barriers<=1000
(0, 0) <=coordinates of barriers<= (10000, 10000)
Output
An integer denoting the sum of the kilometers in which the police officer has his vicinity.
Example
Sample Input:
8 8
4 3
3
1 3 4 6 5 3

Sample output:
6

*/
