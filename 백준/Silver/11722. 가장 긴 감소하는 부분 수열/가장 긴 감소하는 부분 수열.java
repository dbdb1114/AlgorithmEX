import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(line[i]);
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }

        for (int i = N-2; i >= 0; i--) {
            for (int j = i+1; j < N; j++) {
                if(A[i] > A[j]){
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
