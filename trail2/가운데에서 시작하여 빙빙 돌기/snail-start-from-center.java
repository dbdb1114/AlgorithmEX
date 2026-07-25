import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int x = N / 2;
        int y = N / 2;
        int now = 0;

        // 우 상 좌 하 
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};

        int count = 0;
        int sum = 0;

        Queue<Integer> q = new LinkedList<>();
        while(sum < N * N) {
            q.add(count / 2 + 1);
            count++;
            sum += q.peek();
        }

        int[][] map = new int[N][N];
        int num = 1;
        while(!q.isEmpty()) {
            int cnt = q.poll();

            for(int i = 0; i < cnt; i++){
                if(x >= N || y >= N || x < 0 || y < 0) break;
                map[x][y] = num++;
                x = x + dx[now];
                y = y + dy[now];
            }

            now++;

            if(now == 4) {
                now = 0;
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
}