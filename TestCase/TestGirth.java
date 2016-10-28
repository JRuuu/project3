package TestCase;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by JRu on 10/25/16.
 */
public class TestGirth {

    public static void main(String[] args) throws IOException {

//        // test case 1
//        File file1 = new File("src" + File.separator + "TestCase" + File.separator + "girth"+ File.separator + "case1.txt");
//        int n1 = 6;
//        int[][] graph1 = IO.transfer(file1,n1);
//        int girth1 = Girth.Girth.findGirth(graph1);
//        System.out.println("The girth of case1: " + girth1);
//
//        // test case 2
//        File file2 = new File("src" + File.separator + "TestCase" + File.separator + "girth"+ File.separator + "case2.txt");
//        int n2 = 15;
//        int[][] graph2 = IO.transfer(file2,n2);
//        int girth2 = Girth.Girth.findGirth(graph2);
//        System.out.println("The girth of case2: " + girth2);

//        // test case 3 (me)
//        File file3 = new File("src" + File.separator + "TestCase" + File.separator + "girth"+ File.separator + "case3.txt");
//        int n3 = 6;
//        int[][] graph3 = IO.transfer(file3,n3);
//        int girth3 = Girth.Girth.findGirth(graph3);
//        System.out.println("The girth of case2: " + girth3);

        // connected undirected graphs of various sizes
        System.out.println("Please input the number of nodes:");
        Scanner s = new Scanner(System.in);
        int nodes = s.nextInt();

        int[][] graph = Girth.Graph.createConnectedGraph2D(nodes);

        long startTime = System.currentTimeMillis();
        int g1 = Girth.Girth.findGirth(graph);
        long endTime = System.currentTimeMillis();
        System.out.println("\ntime performance with "+nodes+" nodes: " + (endTime - startTime + "ms"));

        System.out.println("\nGirth of Graph: " + g1);



    }
}
