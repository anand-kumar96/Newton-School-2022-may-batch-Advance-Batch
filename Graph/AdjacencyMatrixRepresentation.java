package com.company.Newton_School.AdvanceDataStructure.Graph;

public class AdjacencyMatrixRepresentation {
    static int adjacencyMatrix[][];
    AdjacencyMatrixRepresentation (int N){ // constructor of main class
      adjacencyMatrix=new int[N][N];
    }
    public static boolean checkIfEdgeExists(int u,int v){
        if(adjacencyMatrix[u][v]==1){
            return true;
        }
        return  false;
    }
    public static void deleteEdge(int u,int v){
        adjacencyMatrix[u][v]=0;
        adjacencyMatrix[v][u]=0;
    }

   public static void addEdge(int u,int v){
       adjacencyMatrix[u][v]=1; 
       adjacencyMatrix[v][u]=1;
       
   }

    public static void main(String[] args) {
        int N=5;
        AdjacencyMatrixRepresentation adjacencyMatrixRepresentation=new AdjacencyMatrixRepresentation(N);
        adjacencyMatrixRepresentation.addEdge( 0, 4);
        adjacencyMatrixRepresentation.addEdge( 1, 2);
        adjacencyMatrixRepresentation.addEdge( 1, 4);
        adjacencyMatrixRepresentation.addEdge( 2, 3);
        adjacencyMatrixRepresentation.addEdge( 3, 4);
        System.out.println(adjacencyMatrixRepresentation.checkIfEdgeExists(3,4));

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(adjacencyMatrixRepresentation.adjacencyMatrix[i][j]+" ");
            }
        }
        adjacencyMatrixRepresentation.deleteEdge(3,4);
        System.out.println();
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print( adjacencyMatrixRepresentation.adjacencyMatrix[i][j]+" ");
            }
        }
        System.out.println();
        System.out.println(adjacencyMatrixRepresentation.checkIfEdgeExists(3,4));
    }

}
