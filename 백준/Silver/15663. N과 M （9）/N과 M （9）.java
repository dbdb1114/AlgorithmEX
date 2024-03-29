import java.io.*;
import java.util.*;

public class Main {

    static boolean[] ckArr;
    static int[] seqArr;
    static int[] nArr;
    static int M;
    static Set<String> set;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());

        ckArr = new boolean[N];
        seqArr = new int[M];
        nArr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        set = new HashSet<>();

        recursive(0,new StringBuilder());
    }
    public static void recursive(int dept, StringBuilder sb){
        if(dept == M){
            String s = sb.toString().trim();
            if(!set.contains(s)){
                System.out.println(s);
                set.add(s);
            }
            return;
        }
        for (int i = 0; i < nArr.length; i++) {
            if(ckArr[i]) continue;
            ckArr[i] = true;
            sb.append(nArr[i] + " ");
            recursive(dept + 1, sb);
            ckArr[i] = false;
            sb.delete(sb.lastIndexOf(nArr[i] + " "), sb.length());
        }
    }
}
