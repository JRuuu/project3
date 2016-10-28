package TestCase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * Created by JRu on 10/25/16.
 */
public class IO {
    public static int[][] transfer(File srcFile, int n) throws IOException {
        int[][] graph=new int[n][n];
        BufferedReader br = new BufferedReader(new FileReader(srcFile));
        int currentline = 0;
        int number=0;
        String line = null;
        while ((line = br.readLine()) != null) {
            String newLine = line.replace(".", "10000");
            String[] elements = newLine.split(" +");
            for(int j=0;j<n;j++){
                if(currentline==j){
                    number=0;
                }
                else{
                    number=Integer.parseInt(elements[j]);
                }
                graph[currentline][j]=number;
            }
            currentline++;
        }
        br.close();
        return graph;
    }
}

// reference: https://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
