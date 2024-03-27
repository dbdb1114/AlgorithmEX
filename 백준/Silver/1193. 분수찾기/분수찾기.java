import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int find = 1;
        int head = 1;
        int body = 1;

        for (int i = 1; i <= N; i++) {
            find += i;
            if(find > N){
                find -= i;
                head = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(head % 2 == 0){
            sb.append((body + (N-find)) + "/" + (head - (N-find)));
        }else {
            sb.append((head - (N-find)) + "/" + (body + (N-find)) );
        }
        System.out.println(sb);
    }
}