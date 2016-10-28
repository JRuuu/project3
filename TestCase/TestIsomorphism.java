package TestCase;

import java.io.File;
import java.io.IOException;

/**
 * Created by JRu on 10/25/16.
 */
public class TestIsomorphism {
    public static void main(String[] args) throws IOException {
        //test case 1
        int n1 = 7;
        File c1g1 = new File("src" + File.separator + "TestCase" + File.separator + "isomorphism"
                + File.separator + "case1" + File.separator + "g1.txt");
        File c1g2 = new File("src" + File.separator + "TestCase" + File.separator + "isomorphism"
                + File.separator + "case1" + File.separator + "g2.txt");
        int[][] g11 = IO.transfer(c1g1, n1);
        int[][] g12 = IO.transfer(c1g2, n1);
        System.out.print("test case 1: ");
        Isomorphism.Isomorphism.Isomorphism(g11,g12);


        //test case 2
        int n2 = 6;
        File c2g1 = new File("src" + File.separator + "TestCase" + File.separator + "isomorphism"
                + File.separator + "case2" + File.separator + "g1.txt");
        File c2g2 = new File("src" + File.separator + "TestCase" + File.separator + "isomorphism"
                + File.separator + "case2" + File.separator + "g2.txt");
        int[][] g21 = IO.transfer(c2g1, n2);
        int[][] g22 = IO.transfer(c2g2, n2);
        System.out.print("test case 2: ");
        Isomorphism.Isomorphism.Isomorphism(g21,g22);


        //test case 1
        int n3 = 7;
        File c3g1 = new File("src" + File.separator + "TestCase" + File.separator + "isomorphism"
                + File.separator + "case3" + File.separator + "g1.txt");
        File c3g2 = new File("src" + File.separator + "TestCase" + File.separator + "isomorphism"
                + File.separator + "case3" + File.separator + "g2.txt");
        int[][] g31 = IO.transfer(c3g1, n3);
        int[][] g32 = IO.transfer(c3g2, n3);
        System.out.print("test case 3: ");
        Isomorphism.Isomorphism.Isomorphism(g31,g32);


    }
}
