import java.util.Scanner;

public class AdjecancyMatrixRepresentation {
    static int AdjecancyMatrix[][];
    AdjecancyMatrixRepresentation(int N){
        AdjecancyMatrix=new int [N][N];
    }
    public static boolean checkIfExists(int u,int v){
        if(AdjecancyMatrix[u][v]==1){
            return true;
        }
        return false;
    }

     public static void deleteEdge(int u,int v){
        AdjecancyMatrix[u][v]=0;
         AdjecancyMatrix[v][u]=0;

     }
    public static  void addEdge(int u,int v) {
        AdjecancyMatrix[u][v] = 1;
        AdjecancyMatrix[v][u] = 1;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        AdjecancyMatrixRepresentation adjecancyMatrixRepresentation=new AdjecancyMatrixRepresentation(N);
        for(int i=0;i<N;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
                adjecancyMatrixRepresentation.addEdge(u,v);
            }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(AdjecancyMatrix[i][j]+" ");
            }
        }
        System.out.println();
        System.out.println("Enter edge to be deleted");
        int x=sc.nextInt();
        int y=sc.nextInt();
        adjecancyMatrixRepresentation.deleteEdge(x,y);
        System.out.println("Enter edge to be check");
        int w=sc.nextInt();
        int z=sc.nextInt();
        System.out.println(adjecancyMatrixRepresentation.checkIfExists(w,z));

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(AdjecancyMatrix[i][j]+" ");
            }
        }
        }

    }
/*
input:

5
0 1
0 2
1 2
0 3
3 1
0 1 1 1 0 1 0 1 1 0 1 1 0 0 0 1 1 0 0 0 0 0 0 0 0
Enter edge to be deleted
0 3
Enter edge to be check
0 3
false
0 1 1 0 0 1 0 1 1 0 1 1 0 0 0 0 1 0 0 0 0 0 0 0 0

*/

