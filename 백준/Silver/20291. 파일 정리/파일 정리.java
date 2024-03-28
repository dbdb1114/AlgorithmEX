import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(bf.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = bf.readLine().split("\\.")[1];
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        sb.append(arr[0]);
        int cnt = 1;

        for (int i = 1; i < N; i++) {
            if(arr[i - 1].equals(arr[i])){
                cnt++;
            } else {
                sb.append(" " + cnt + "\n"); // 직전 확장자명에 대한 갯수
                sb.append(arr[i]); // 새로운 확장자명
                cnt = 1;
            }
        }
        sb.append(" " + cnt);

        System.out.println(sb);
        bf.close();
    }
}
