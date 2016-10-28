package Isomorphism;

/**
 * Created by JRu on 10/26/16.
 */
public class Isomorphism {


    public static void Isomorphism(int[][] graph1, int[][] graph2)
    {
        if (graph1.length != graph2.length) { // diff vertices
            System.out.println("not isomorphic");
        } else {
            int n = graph1.length;
            int[] order = new int[n];
            boolean[] used = new boolean[n];
            for (int i = 0; i < n; i++) {
                used[i] = false;
                order[i] = -1;
            }
            boolean isomorphism = DFS_isomorphism(n,n-1,graph1,graph2,used,order);
            if(isomorphism){
                System.out.println("isomorphic");
                System.out.print("  order of vertices for graph1: ");
                for(int i = 0; i < n; i++){
                    System.out.print((i+1)+" ");
                }
                System.out.print("\n  order of vertices for graph2: ");
                for(int i = 0; i < n; i++){
                    System.out.print((order[i]+1)+" ");
                }
                System.out.println();
            }else{
                System.out.println("not isomorphic");
            }
        }
        System.out.println();
    }

    public static boolean DFS_isomorphism(int n, int level, int[][] graph1, int[][] graph2, boolean[]used, int[]order)
    {
        boolean result = false;
        if(level == -1){
            result = Edge(n,graph1,graph2,order);
        }else{
            int i = 0;
            while (i < n && !result){
                if(!used[i]){
                    order[level] = i;
                    result = DFS_isomorphism(n, level-1, graph1, graph2, used, order);
                    used[i] = false;
                }
                i++;
            }
        }
        return  result;
    }


    public static Boolean Edge(int n, int[][] graph1, int[][] graph2, int[] order) {
        boolean label = true;
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < n && label) {
                if (graph1[i][j] != graph2[order[i]][order[j]]) {
                    label = false;
                }
                j++;
            }
        }
        return label;
    }

}
