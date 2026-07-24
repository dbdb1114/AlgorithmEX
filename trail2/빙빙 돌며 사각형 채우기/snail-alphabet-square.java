import java.util.*;

public class Main {
    public static void main(String[] args) {
        char[] alphabet = new char[26];
        for(int i = 0; i < 26; i++) {
            alphabet[i] = (char) (65 + i);
        }
        

        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        int now = 0;

        int x = 0;
        int y = 0;

        char[][] map = new char[N][M];
        for(int i = 0; i < N * M; i++) {
            try{
                map[x][y] = alphabet[i % 26];
                } 
                catch (Exception e) {
                System.out.println(x + ", " + y);
            }
            
            int newX = x + dx[now];
            int newY = y + dy[now];
            if(newX < 0 || newX >= N || newY < 0 || newY >= M || map[newX][newY] >= 65){
                now++;

                if(now == 4) {
                    now = 0;
                }

                newX = x + dx[now];
                newY = y + dy[now];
            }

            x = newX;
            y = newY;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}