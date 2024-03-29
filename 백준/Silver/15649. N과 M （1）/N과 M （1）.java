import java.io.*;

public class Main {

    static int N;
    static int M;
    static boolean[] check;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");

        N = Integer.parseInt(s[0]); 
        M = Integer.parseInt(s[1]);
        check = new boolean[N+1];  // 방문배열 초기화 

        recursive(0, new StringBuilder());
    }

    public static void recursive(int depth, StringBuilder sb){
        if(depth == M){
            System.out.println(sb);
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(check[i]) continue;
            sb.append(i + " ");
            check[i] = true;
            recursive(depth+1, sb);
            sb.delete(sb.lastIndexOf(i+" "), sb.length());
            check[i] = false;
        }
    }
}
