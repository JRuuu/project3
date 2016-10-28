package Girth;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by JRu on 10/25/16.
 */
public class Girth {
    // find the girth of a graph

    static class Node
    {
        public int vertex, depth;
        public Node(int vertex, int depth)
        {
            this.vertex = vertex;
            this.depth = depth;
        }
    }

    public static int findGirth(int[][] graph)
    {

        int n = graph.length;
        int[] labels = new int[n]; // labelling vertex
        int length = Integer.MAX_VALUE; // shortest cycle length in graph with all n vertex, if cycle, length >=3
        Queue<Node> queue = new LinkedList<Node>();
        int root = 0;
        while (root < n){

            for(int i = 0; i < n; i++){
                labels[i] = -1; //reset labels
            }

            labels[root] = 0;
            // add initial node to the queue
            queue.add(new Node(root,0));
            // take next item from the queue
            Node node = queue.poll();


            while (node != null && (node.depth + 1) * 2 - 1 < length){
                // depth of neighbours
                int depth = node.depth + 1;
                // check all neighbours
                for(int neighbour : getNeighbours(graph, node.vertex)){
                     if(labels[neighbour] < 0){
                         // neighbour did not seen before
                         queue.add(new Node(neighbour, depth));
                         labels[neighbour] = depth;
                     } else if (labels[neighbour] == depth - 1){
                         // cycle with odd number of edges
                         if(depth * 2 - 1 < length){
                             length = depth * 2 - 1;
                         }
                     }else if(labels[neighbour] == depth){
                         // cycle with even number of edges
                         if(depth * 2 < length){
                             length = depth * 2;
                         }
                     }
                 }
                 node = queue.poll(); // take next item from the queue
             }
             queue.clear();
             root++;
        }

        if(length == Integer.MAX_VALUE){
            length = 0;
            System.out.println("This graph has no cycle");
        }
        return length;

    }


    public static List<Integer> getNeighbours(int[][]graph, int vertex){
        int n = graph.length;
        List<Integer> neighbours = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            if(graph[vertex][i] == 1){
                neighbours.add(i);
            }
        }
        return neighbours;
    }

}


//reference: https://github.com/jaspervdj/Genus/blob/master/src/genus/Order.java