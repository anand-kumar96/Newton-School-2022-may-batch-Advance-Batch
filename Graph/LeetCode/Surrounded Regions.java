//https://leetcode.com/problems/surrounded-regions/
// method 01
class Solution {
    private void solveHelper(char board[][], int x, int y,boolean Visited[][]) {
          if(x < 0
        || x >= board.length
        || y < 0
        || y >= board[0].length
        || board[x][y] != 'O'
        ||Visited[x][y]==true) 
          {
            return;
        }
         Visited[x][y]=true;

        solveHelper(board, x - 1, y,Visited); //up
        solveHelper(board, x, y + 1,Visited); //right
        solveHelper(board, x + 1, y,Visited); //down
        solveHelper(board, x, y - 1,Visited); //left
    }
     
                      
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        if (n <= 2 || m <= 2) {
            return;
        }
        boolean Visited[][]=new boolean[n][m];
        for(int i=0;i<m;i++){
            // up 
            if(board[0][i]=='O'){
                 solveHelper(board, 0,i,Visited);
            }
            // down
            if(board[n-1][i]=='O'){
                 solveHelper(board, n-1,i,Visited);
            }
            }
           for(int i=0;i<n;i++){
                //left
            if(board[i][0]=='O'){
                 solveHelper(board, i,0,Visited);
            }
                    //right
            if(board[i][m-1]=='O'){
        solveHelper(board, i,m-1,Visited);
            }
        }

         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(Visited[i][j]==false && board[i][j]=='O' ){
                    board[i][j]='X';
                }
                 
         }
         }     
    }
}

// method 02
class Solution {private void solveHelper(char board[][], int x, int y) {
        if(x < 0
        || x >= board.length
        || y < 0
        || y >= board[0].length
        || board[x][y] != 'O') {
            return;
        }

        board[x][y] = '*';

        solveHelper(board, x - 1, y); //up
        solveHelper(board, x, y + 1); //right
        solveHelper(board, x + 1, y); //down
        solveHelper(board, x, y - 1); //left
    }

    public void solve(char[][] board) {
        int rowCount = board.length;
        int columnCount = board[0].length;

        if (rowCount <= 2 || columnCount <= 2) {
            return;
        }

        //first row and last row
        for (int i = 0; i < columnCount; i++) {
            if (board[0][i] == 'O') {
                //dfs
                solveHelper(board, 0, i);
            }
            if (board[rowCount - 1][i] == 'O') {
                //dfs
                solveHelper(board, rowCount - 1, i);
            }
        }

        //first column and last column
        for (int i = 1; i < rowCount - 1; i++) {
            if (board[i][0] == 'O') {
                //dfs
                solveHelper(board, i, 0);
            }
            if (board[i][columnCount - 1] == 'O') {
                //dfs
                solveHelper(board, i, columnCount - 1);
            }
        }

        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < columnCount; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if(board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
