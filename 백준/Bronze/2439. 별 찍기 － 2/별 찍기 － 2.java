import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(" ".repeat(n-i-1));
            sb.append("*".repeat(i+1));
            System.out.println(sb.toString());
        }

    }
}
