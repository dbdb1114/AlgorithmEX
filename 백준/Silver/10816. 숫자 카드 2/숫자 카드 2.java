import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        String[] nKeys = bf.readLine().split(" ");

        Map<String,Integer> sangKn = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int cNum = sangKn.getOrDefault(nKeys[i], 0);
            sangKn.put(nKeys[i], cNum + 1);
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(bf.readLine());
        String[] mKeys = bf.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            int cnt = sangKn.getOrDefault(mKeys[i], 0);
            sb.append(cnt + " ");
        }

        System.out.println(sb);
    }
}
