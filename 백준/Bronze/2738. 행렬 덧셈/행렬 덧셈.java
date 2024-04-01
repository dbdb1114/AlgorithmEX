import java.io.*;
import java.util.*;
import java.util.function.*;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        int[] NandM = line();

        int N = NandM[0];
        int M = NandM[1];

        int[][] NM1 = new int[N][M];
        int[][] answer = new int[N][M];

        for (int i = 0; i < N; i++) {
            int[] arr = line();
            for (int j = 0; j < M; j++) {
                NM1[i][j] = arr[j];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int[] arr = line();
            for (int j = 0; j < M; j++) {
                sb.append(NM1[i][j] + arr[j] + " ");
            }
            setLine.accept(sb);
        }
        System.out.println(sb);
    }

    public static int[] line() throws IOException {
        return Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    static Consumer<StringBuilder> setLine = sb -> sb.delete(sb.length()-1,sb.length()).append('\n');
}
