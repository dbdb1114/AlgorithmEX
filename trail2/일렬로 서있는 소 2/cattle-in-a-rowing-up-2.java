import java.util.*;

public class Main {

    static int N;
    static int[] cows;
    static int answer = 0;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        cows = new int[N];

        for(int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            recursive(i,1);
        }

        System.out.println(answer);
    }

    static void recursive(int n, int cnt) {
        if(cnt >= 3) {
            answer++;
            return;
        }

        for(int i = n+1; i < N; i++){
            if(cows[n] <= cows[i]) {
                recursive(i, cnt + 1);
            }
        }

        return;
    }
}