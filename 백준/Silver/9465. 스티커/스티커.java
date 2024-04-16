import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(bf.readLine());

            int[][] sticker = new int[2][N+1];
            int[][] dp = new int[2][N+1];

            int[] s1 = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int[] s2 = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int j = 1; j < N+1; j++) {
                sticker[0][j] = s1[j-1];
                sticker[1][j] = s2[j-1];
            }
            
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            for (int j = 2; j < N+1; j++) {
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + sticker[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + sticker[1][j];
            }
            sb.append(Math.max(dp[0][N], dp[1][N]) + "\n");
        }

        System.out.println(sb);
    }

}
