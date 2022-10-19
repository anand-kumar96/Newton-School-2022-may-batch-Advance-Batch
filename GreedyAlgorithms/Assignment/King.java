// method 01
static int King(int x, int y){
if((x==1 && y==1) || (x==1 && y==8) || (x==8 && y==1) || (x==8 && y==8) ){
    return 3;
}
if(x==1 || y==1 || x==8 || y==8 ){
    return 5;
}
 return 8;
}
//method 02
    static int King(int X, int Y) {
        //Enter your code here
        int directions[][] = {
                {0, -1},
                {0, 1},
                {-1, 0},
                {-1, -1},
                {-1, 1},
                {1, 0},
                {1, -1},
                {1, 1}
        };

        int positionCount = 0;

        for(int i = 0; i < directions.length; i++) {
            int nextX = X + directions[i][0];
            int nextY = Y + directions[i][1];

            if (nextX >= 1
                    && nextX <= 8
                    && nextY >= 1
                    && nextY <= 8) {
                positionCount++;
            }
        }

        return positionCount;
    }
/*
King
easy
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Given the position of the king in an 8X8 chessboard. Your task is to find the number of positions King can go into in one move.

Note:-
Remember king can move in all eight directions but can not go outside of the chess board
Input
User Task:
Since this will be a functional problem, you don't have to take input. You just have to complete the function King() that takes integers X, and Y as arguments.

Constraints:-
1 <= X, Y <= 8
Output
Return the number of positions King can go into in one move.
Example
Sample Input:-
2 1

Sample Output:-
5

Explanation:-
the king can go into:- (1, 1), (3, 1), (1, 2). (2, 2), (3, 2)

Sample Input:-
4 4

Sample Output:-
8
*/
