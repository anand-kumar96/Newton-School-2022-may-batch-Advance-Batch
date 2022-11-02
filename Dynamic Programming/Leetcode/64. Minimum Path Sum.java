class Solution {
    public int minPathSum(int[][] grid) {
    int NumberOfRow=grid.length;
     int NumberOfCol=grid[0].length;
        int totalCost[][]=new int[NumberOfRow][NumberOfCol];
        
        totalCost[0][0]=grid[0][0];
        // filling 0 th  Row
        for(int i=1;i<NumberOfCol;i++){
            totalCost[0][i]=totalCost[0][i-1]+grid[0][i];
        }
         // filling 0 th Col
        for(int i=1;i<NumberOfRow;i++){
            totalCost[i][0]=totalCost[i-1][0]+grid[i][0];
        }
        for(int i=1;i<NumberOfRow;i++){
            for(int j=1;j<NumberOfCol;j++){
                totalCost[i][j]=Math.min(totalCost[i-1][j],totalCost[i][j-1])+grid[i][j];
            }
        }
        return totalCost[NumberOfRow-1][NumberOfCol-1];
    }
}
