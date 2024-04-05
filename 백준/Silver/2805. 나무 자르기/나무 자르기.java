import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(tk.nextToken());
        long M = Long.parseLong(tk.nextToken());

        StringTokenizer tk1 = new StringTokenizer(bf.readLine());

        long[] trees = new long[N];
        long maxTreeHeight = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(tk1.nextToken());
            maxTreeHeight = Math.max(maxTreeHeight, trees[i]);
        }

        // 이진 탐색
        long left = 0;
        long right = maxTreeHeight;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long totalLength = 0;

            for (long tree : trees) {
                if (tree > mid) {
                    totalLength += tree - mid;
                }
            }

            if (totalLength >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
