import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        // 하 우 상 좌 
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        int now = 0;
        int x = 0;
        int y = 0;

        for(int i = 0; i < N * M; i++){
            map[x][y] = i + 1;

            int newx = x + dx[now];
            int newy = y + dy[now];

            // newx 랑 newy가 말이 안 된다면?
                // - 말이 안 된다는 건 다른 숫자가 이미 채워졌거나
                // - 인덱스를 넘어갔거나 
            // now 방향 전환 
            
            if(newx < 0 || newx >= N || newy < 0 || newy >= M || map[newx][newy] != 0) {
                now++;
                if(now > 3) {
                    now = 0;
                }

                newx = x + dx[now];
                newy = y + dy[now];
            } 

            x = newx;
            y = newy;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.printf("%d ", map[i][j]);
            }

            System.out.println();
        }
    }
}