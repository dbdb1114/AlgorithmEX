import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[][] map = new int[200][200];
        int OFFSET = 100;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int x = Integer.parseInt(st.nextToken()) + OFFSET;
            int y = Integer.parseInt(st.nextToken()) + OFFSET;

            for(int j = x; j < x + 8; j++){
                for(int k = y; k < y + 8; k++){
                    map[j][k] = 1;
                }
            } 
        }

        int answer = 0;
        for(int i = 0; i < 200; i++){
            for(int j = 0; j < 200; j++){
                answer += map[i][j];
            }
        }

        System.out.println(answer);
    }
}