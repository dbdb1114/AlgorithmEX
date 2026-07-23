import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) {
        // Please write your code here.
        // 상 우 하 좌
    
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        char[][] map = new char[N][N];
        for(int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int K = Integer.parseInt(sc.nextLine());
        
        int x = 0;
        int y = 0;
        int di = 0;
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        // K - 1 / N => 1 미만이면 x = 0; y = (K - 1) % N; / di = 하
        // K - 1 / N => 2 미만이면 x = (K - 1) % N; y = K - 1; / di = 좌
        // K - 1 / N => 3 미만이면 x = K - 1 ; y = (K - 1) % N; / di = 상 
        // K - 1 / N => 4 미만이면 x = (K - 1) % N ; y = 0; / di = 우 
        if((K-1)/N < 1) {
            x = 0;
            y = (K - 1) % N;
            di = 2;
        } else if ((K-1)/N < 2) {
            x = (K - 1) % N;
            y = N - 1;
            di = 3;
        } else if ((K-1)/N < 3) {
            x = N - 1;
            y = N - 1 - ((K-1)%N); // 0 ~ N - 1
            // N - 1 - ((K-1)%N)

            di = 0;
        } else if ((K-1)/N < 4) {
            x = N - 1 - ((K-1)%N);
            y = 0;
            di = 1;
        }

        // System.out.println("X : " + x + ", y : " + y + ", di : " + di);

        int answer = 0;
        while(isValidIndex(x, y)) {
            // System.out.println(di);
            di = getNewDirection(di, map[x][y]);

            answer++;

            x += dx[di];
            y += dy[di];
        }

        System.out.println(answer);
    }

    static boolean isValidIndex(int x, int y) {
        if( x < 0 || x >= N || y < 0 || y >= N ) {
            return false;
        }

        return true;
    }

    // 9,8,7
    // 상 + \ => 좌 [ -1 ]
    // 상 + / => 우 [ +1 ]

    // 12,11,10
    // 우 + \ => 하 [ +1 ]
    // 우 + / => 상 [ -1 ]

    // 1,2,3
    // 하 + \ => 우 [ -1 ] 
    // 하 + / => 좌 [ +1 ]

    // 4,5,6
    // 좌 + \ => 상 [ +1 ]
    // 좌 + / => 하 [ -1 ]
    static int getNewDirection(int di, char ch){
        if(di == 0) {
            if(ch == '\\') {
                return 3;
            } else {
                return 1;
            }
        } else if(di == 1) {
            if(ch == '\\') {
                return 2;
            } else {
                return 0;
            }
        } else if(di == 2) {
            if(ch == '\\') {
                return 1;
            } else {
                return 3;
            }
        } else if(di == 3) {
            if(ch == '\\') {
                return 0;
            } else {
                return 2;
            }
        }

        return -1;
    }
}