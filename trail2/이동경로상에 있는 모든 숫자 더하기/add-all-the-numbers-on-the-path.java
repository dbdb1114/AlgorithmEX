import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        String move = sc.nextLine();
        int[][] map = new int[N][N];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int x = N / 2;
        int y = N / 2;
        int now = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(sc.nextLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        int sum = map[x][y];

        for(int i = 0; i < move.length(); i++) {
            char di = move.charAt(i);
            if(di == 'R') now++;
            else if(di == 'L') now--;
            else if(di == 'F') {
                x += dx[now];
                y += dy[now];

                if(x >= N || y >= N || x < 0 || y < 0) {
                    x -= dx[now];
                    y -= dy[now];
                } else {
                    sum += map[x][y];
                }
            }
            
            if(now < 0) {
                now = 3;
            } else if (now == 4) {
                now = 0;
            }
        }

        System.out.println(sum);
    }
}