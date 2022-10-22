package com.company.Newton_School.AdvanceDataStructure.Practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUnweighted {
    ArrayList<ArrayList<Integer>>graph;
    ShortestPathUnweighted(int N){
        graph=new ArrayList<>();
        for(int i=0;i<N;i++){
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int u,int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    private  void printShortestDistance(int source, int desti,int N) {
        // predecessor[i] array stores predecessor of i and distance array stores distance of  from s
        int dis[]=new int[N];
        int predecessor[]=new int[N];
        boolean result=bfs(source,desti,dis,predecessor); // destination getting or not
        if(result==false){
            System.out.println("Destination not found");
            return;
        }

        // to store path
        ArrayList<Integer>path=new ArrayList<>();
        int eachPath=desti;
        path.add(eachPath);
        while(predecessor[eachPath]!=-1){
            path.add(predecessor[eachPath]);
            eachPath=predecessor[eachPath];
        }

        // Print distance
        System.out.println("Shortest path length is: " + dis[desti]);

        // Print path
        System.out.println("Path is ::");
        for (int i = path.size()-1 ; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }
    public boolean bfs(int source,int destination,int dis[],int pred[]){
        HashSet<Integer>Visited=new HashSet<>();
        Queue<Integer>q=new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            dis[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }
        Visited.add(source);
        dis[source]=0;
        q.add(source);
        while(!q.isEmpty()){
            int curr=q.poll();

//            for(int i=0;i<graph.get(curr).size();i++){
//                if(!Visited.contains(graph.get(curr).get(i))){
//                    Visited.add(graph.get(curr).get(i));
//                    q.add(graph.get(curr).get(i));
//                    dis[graph.get(curr).get(i)]=dis[curr]+1;
//                    pred[graph.get(curr).get(i)]=curr;
//
//                    if(graph.get(curr).get(i)==destination){
//                        return true;
//                    }
//                }
//            }
            for(int eachNode:graph.get(curr)){
                if(!Visited.contains(eachNode)){
                    Visited.add(eachNode);
                    q.add(eachNode);
                    dis[eachNode]=dis[curr]+1;
                    pred[eachNode]=curr;
                    if(eachNode==destination){
                       return true;
                    }

                }
            }
        }
       return  false;
    }

    public static void main(String[] args) {
        int N=6;
        ShortestPathUnweighted shortestPathUnweighted=new ShortestPathUnweighted(N);
        shortestPathUnweighted.addEdge(0,1);
        shortestPathUnweighted.addEdge(1,2);
        shortestPathUnweighted.addEdge(2,3);
        shortestPathUnweighted.addEdge(2,5);
        shortestPathUnweighted.addEdge(3,4);
        shortestPathUnweighted.addEdge(4,2);
        shortestPathUnweighted.addEdge(4,5);
        System.out.println("Adj list : :  " + shortestPathUnweighted.graph);
        shortestPathUnweighted.printShortestDistance(0,5,N);

    }
}
