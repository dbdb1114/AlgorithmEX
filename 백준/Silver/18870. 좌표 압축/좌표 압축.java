import com.sun.source.tree.Tree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        StringTokenizer tk = new StringTokenizer(bf.readLine());

        TreeMap<Long, Integer> treeMap = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        long[] nArr = new long[N];

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(tk.nextToken());
            treeMap.put(num, 1);
            nArr[i] = num;
        }

        int prev = 0;
        for (Long aLong : treeMap.keySet()) {
            treeMap.put(aLong, prev++);
        }


        for (int i = 0; i < N; i++) {
            sb.append(treeMap.get(nArr[i]) + " ");
        }
        sb.delete(sb.length()-1,sb.length());
        System.out.println(sb);
    }
}
