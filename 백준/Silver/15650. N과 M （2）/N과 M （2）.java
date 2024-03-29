import java.io.*;


public class Main {

    static int N;
    static int M;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        recursive(0,0, new StringBuilder());
    }

    public static void recursive(int depth, int st, StringBuilder sb){
        if(depth == M){
            System.out.println(sb.toString().trim());
            return;
        }
        for (int i = st + 1; i <= N; i++) {
            sb.append(i + " ");
            recursive(depth+1, i, sb);
            sb.delete(sb.lastIndexOf(i + " "), sb.length());
        }
    }
}
