package Girth;

/**
 * Created by JRu on 10/26/16.
 */
public class Graph {

    // a connected graph with random links
    public static int[][] createConnectedGraph2D(int n)
    {
        // randomly generate the number of edges between (n-1) and n*(n-1)/2
        int edges = (int)((n-1) + Math.random()*(n-2)*(n-1)/2);
//        int edges = n;

        int[][] w = new int[n][n];
        int rowsum = n*(n-1)/2; // sum of n nodes index. if one node connected, subtract the index.
                                // If all nodes connected, then the result must <= 0;
        do {
            // if the graph with (n-1) edges is not connected, then re-generate
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    w[i][j] = 0;
                }
            }

            for (int i = 0; i < (n-1); i++) {
                int row = (int) (Math.random() * n);
                int col = (int) (Math.random() * n);
                if (row == col) {
                    i--;
                } else if (w[row][col] == 0) {
                    w[row][col] = 1;
                    w[col][row] = 1;
                    rowsum -= col;
                } else {
                    i--;
                }
            }
        }while(rowsum>0);

        for (int i = 0; i < (edges-n+1); i++) {
            int row = (int) (Math.random() * n);
            int col = (int) (Math.random() * n);
            if (row == col) {
                i--;
            } else if (w[row][col] == 0) {
                w[row][col] = 1;
                w[col][row] = 1;
            } else {
                i--;
            }
        }
        System.out.println("Graph is "+ n + " vertices with "+ edges + " edges");
        return w;
    }

}
