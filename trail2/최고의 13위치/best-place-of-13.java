import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int i = 0; i < N; i++) {
            int sum = map[i][0] + map[i][1] + map[i][2];
            answer = Math.max(answer,sum);
            for(int j = 3; j < N; j++) {
                sum -= map[i][j-3];
                sum += map[i][j];
                answer = Math.max(answer,sum);
            }
            // System.out.println(i);
        }

        System.out.println(answer);
    }
}