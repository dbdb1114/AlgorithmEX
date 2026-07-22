import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        int[][] map = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer (sc.nextLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int answer = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int count = 0;
                for(int k=0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (isFineIndex(x) && isFineIndex(y) && map[x][y] == 1) {
                        count++;
                    }
                }

                if(count >= 3) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    static boolean isFineIndex(int index) {
        if(N <= index || index < 0){
            return false;
        }

        return true;
    }
}