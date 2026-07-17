import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        // 배열 좌표 평면 표현하는 배열 201의 길이를 가진 행과 열 배열 
        int[] x1 = new int[N];
        int[] y1 = new int[N];
        int[] x2 = new int[N];
        int[] y2 = new int[N];
        // 배열 좌표를 표현해서, 각 색을 칠할 수 있는 2차원 배열 200 * 200
        int[][] square = new int[200][200];
        // offset = 100
        int OFFSET = 100;
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(sc.nextLine());

            x1[i] = Integer.parseInt(st.nextToken()) + OFFSET;
            y1[i] = Integer.parseInt(st.nextToken()) + OFFSET;
            x2[i] = Integer.parseInt(st.nextToken()) + OFFSET;
            y2[i] = Integer.parseInt(st.nextToken()) + OFFSET;
        }

        for(int i = 0; i < N; i++){
            for(int j = x1[i]; j < x2[i]; j++){
                for(int k=y1[i]; k < y2[i]; k++){
                    square[j][k] = 1;
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < 200; i++){
            for(int j = 0; j < 200; j++){
                answer += square[i][j];
            }
        } 

        System.out.println(answer);

    }
}