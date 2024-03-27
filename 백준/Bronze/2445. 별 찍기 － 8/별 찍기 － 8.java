import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append("*".repeat(i+1));
            sb.append(" ".repeat(N*2 - i*2 - 2));
            sb.append("*".repeat(i+1));
            sb.append("\n");
        }
        for (int i = 1; i < N; i++) {
            sb.append("*".repeat(N-i));
            sb.append(" ".repeat(i*2));
            sb.append("*".repeat(N-i));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
