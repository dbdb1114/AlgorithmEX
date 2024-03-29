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

        recursive(0,seqArr);
    }
/*
5 3
12 145 23 52 2

5 2
1 21 451 21 1

5 2
14 14 5 12 3
 */
    public static void recursive(int dept, int[] seqArr){
        if(dept == M){
            StringBuilder sb = new StringBuilder();
            Arrays.stream(seqArr).forEach(x->sb.append(x+" "));
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
            seqArr[dept] = nArr[i];
            recursive(dept + 1, seqArr);
            ckArr[i] = false;
            seqArr[dept] = -1;
        }
    }
}
