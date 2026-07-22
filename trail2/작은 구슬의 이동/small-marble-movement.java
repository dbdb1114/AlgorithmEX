import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(sc.nextLine());
        int x = Integer.parseInt(st1.nextToken());
        int y = Integer.parseInt(st1.nextToken());
        String di = st1.nextToken();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int now = getNowIndex(di);

        int[][] map = new int[N+1][N+1];
        for(int i = 0; i < T; i++){
            int newX = x + dx[now];
            int newY = y + dy[now];

            if(!checkIndex(newX) || !checkIndex(newY)) {
                now+=2;

                // 방향 전환
                if(now == 4) {
                    now = 0;
                } else if(now == 5) {
                    now = 1;
                }

                continue;
            }

            x = newX;
            y = newY;
        }

        System.out.printf("%d %d", x, y);

    }

    static boolean checkIndex(int index) {
        if(index < 1 || index > N) {
            return false;
        }
        return true;
    }

    static int getNowIndex(String di){
        if(di.equals("U")) {
            return 0;
        } else if (di.equals("R")) {
            return 1;
        } else if (di.equals("D")) {
            return 2;
        } else if (di.equals("L")) {
            return 3;
        }
        return -1;
    }
}