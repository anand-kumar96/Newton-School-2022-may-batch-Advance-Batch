package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstSearch {
    static HashMap<Object, HashSet<Object>> graph;
    BreathFirstSearch(){
        graph=new HashMap<>(); // initialize
    }
    public static void bfsTraversal(Object startingVertex){
        HashSet<Object>visitedSet=new HashSet<>();
        visitedSet.add(startingVertex);
        Queue<Object> q=new LinkedList<>();
        q.add(startingVertex);
        while(!q.isEmpty()){
            Object currentVertex=q.poll();
            System.out.print(currentVertex+" ");
            HashSet<Object>neighbours=graph.get(currentVertex);
            for(Object eachVertex:neighbours){
                if(!visitedSet.contains(eachVertex)){
                    visitedSet.add(eachVertex);
                    q.add(eachVertex);
                }
            }
        }
        System.out.println();
    }


    public static void  addEdge(Object u,Object v){
        if(!graph.containsKey(u)){
            graph.put(u,new HashSet<>());
        }
        if(!graph.containsKey(v)){
            graph.put(v,new HashSet<>());
        }
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void main(String[] args) {
     BreathFirstSearch breathFirstSearch=new BreathFirstSearch();
     HashMap<Integer,String>CityMap=new HashMap<>();
        CityMap.put(1,"Pune");
        CityMap.put(2,"Bangalore");
        CityMap.put(3,"Hyderabad");
        CityMap.put(4,"Gurgaon");
        CityMap.put(5,"Noida");
        CityMap.put(6,"Ahmedabad");
        breathFirstSearch.addEdge(CityMap.get(1),CityMap.get(2));
        breathFirstSearch.addEdge(CityMap.get(1),CityMap.get(3));
        breathFirstSearch.addEdge(CityMap.get(2),CityMap.get(4));
        breathFirstSearch.addEdge(CityMap.get(2),CityMap.get(5));
        breathFirstSearch.addEdge(CityMap.get(3),CityMap.get(5));
        breathFirstSearch.addEdge(CityMap.get(4),CityMap.get(5));
        breathFirstSearch.addEdge(CityMap.get(4),CityMap.get(6));
        breathFirstSearch.addEdge(CityMap.get(5),CityMap.get(6));

        System.out.println(graph);
        breathFirstSearch.bfsTraversal(CityMap.get(3));
    }
}

/*
output
{Ahmedabad=[Gurgaon, Noida], Gurgaon=[Ahmedabad, Noida, Bangalore], Pune=[Hyderabad, Bangalore], Noida=[Ahmedabad, Gurgaon, Hyderabad, Bangalore], Hyderabad=[Pune, Noida], Bangalore=[Gurgaon, Pune, Noida]}
Hyderabad Pune Noida Bangalore Ahmedabad Gurgaon 

*/
