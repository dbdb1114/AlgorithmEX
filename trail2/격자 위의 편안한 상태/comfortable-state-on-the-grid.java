import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] map;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(sc.nextLine());
            int r = Integer.parseInt(st1.nextToken());
            int c = Integer.parseInt(st1.nextToken());

            map[r-1][c-1] = 3;
            if(isComport(r-1, c-1)) {
                sb.append(1);
            } else {
                sb.append(0);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean isComport(int x, int y) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int count = 0;

        for(int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(!isFineIndex(newX) ||!isFineIndex(newY)){
                continue;
            }

            if(map[newX][newY] == 3){
                count++;
            }
        }

        if(count == 3) {
        // System.out.println( x + ", " + y);
            return true;
        }

        return false;
    }


    static boolean isFineIndex(int idx) {
        if(idx < 0 || idx >= N) return false;
        
        return true;
    }
}