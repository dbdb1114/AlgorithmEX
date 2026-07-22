import java.util.*;

public class Main {
    
    static int N;
    static int M;

    public static void main(String[] args) {
        // Please write your code here.
        // 오른쪽 만나면 아래로, 
        // 아래를 만나면 왼쪽으로, 
        // 왼쪽을 만나면 위로,
        // 위를 만나면 오른쪽으로 

        // 우하좌상
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int now = 0;
        int x = 0;
        int y = 0;

        for(int i = 0; i < N * M; i++) {
            map[x][y] = i + 1;

            int newX = x + dx[now];
            int newY = y + dy[now];

            // 벽을 만났을 때 
            if(newX >= N || newX < 0 || newY >= M || newY < 0 || map[newX][newY] != 0 ) {
                now++;

                if(now > 3) {
                    now = 0;
                }

                newX = x+dx[now];
                newY = y+dy[now];
            }
            
            x = newX;
            y = newY;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++){
                System.out.print(map[i][j] +" ");
            }
            System.out.println();
        }
    }
}