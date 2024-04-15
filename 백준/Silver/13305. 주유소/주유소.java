import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        long[] dist = new long[N-1];
        int[] price = new int[N];
        long answer = 0;

        dist[0] = 0;

        String[] line = bf.readLine().split(" ");
        for (int j = 0; j < N-1; j++) {
            dist[j] = Long.parseLong(line[j]);
        }

        line = bf.readLine().split(" ");
        for (int j = 0; j < N; j++) {
            price[j] = Integer.parseInt(line[j]);
        }

        int minOil = price[0];

        for (int i = 0; i < dist.length; i++) {
            minOil = Math.min(minOil,price[i]);
            answer += minOil * dist[i];
        }

        System.out.println(answer);
    }

}
