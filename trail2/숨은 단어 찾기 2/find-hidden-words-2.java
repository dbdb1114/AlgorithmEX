import java.util.*;

public class Main {

    static int n;
    static int m;
    static char[][] map;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 'L') {
                    findLee(i,j);
                }
            }
        }

        System.out.println(answer);
    }

    public static void findLee(int x, int y) {
        int[] dx = {0, -1, -1, -1, 0, 1, 1, 1 };
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1 };

        for(int i = 0; i < 8; i++) {
            int count = 0;

            for(int j = 1; j <= 2; j++) {
                int newX = x + dx[i] * j; 
                int newY = y + dy[i] * j;
                
                if(!isFineIndex(newX, newY)) {
                    break;
                }

                if(map[newX][newY] != 'E'){
                    break;
                } else {
                    count++;
                }
            }

            if(count == 2) {
                answer++;
            }
        }
    }

    public static boolean isFineIndex(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}