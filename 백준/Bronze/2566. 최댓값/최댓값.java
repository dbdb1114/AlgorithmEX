import java.io.*;
import java.util.*;
import java.util.function.*;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws Exception{
        
        int max = -1;
        
        int maxX = 0;
        int maxY = 0;
        
        for (int i = 0; i < 9; i++) {
            
            int[] ar = getIntAr();
            int[] lineMax = getMax.apply(ar); // [0]은 큰 값, [1]은 위치
            
            if(max < lineMax[0]){
                
                max = lineMax[0];
                
                maxY = lineMax[1] + 1;
                maxX = i + 1;
                
            }
        }
        
        System.out.println(max);
        System.out.println(maxX + " " + maxY);
    }


    static int[] getIntAr() throws IOException {
        return Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    static Function<int[], int[]> getMax = (ar) -> {
        int[] max = new int[2];
        for (int i = 0; i < ar.length; i++) {
            if(ar[i] > max[0]){
                max[0] = ar[i];
                max[1] = i;
            }
        }
        return max;
    };
}
