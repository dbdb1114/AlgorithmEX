import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        // N개의 직사각형
        // 처음 주어지는 직사각형 빨간색 
        // 그 다음에 주어지는 직사각형 파란색

        // 이렇게 빨간색 -> 파란색 번갈아 주어지고, 
        // 겹치는 위치가 있다면 가장 마지막에 덮힌 색으로 취급 
        // N개의 직사각형이 주어지고 난 뒤의 파란색 영역의 총 넓이를 구하시오 
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        int OFFSET = 100;
        int[][] check = new int[200][200];
        for(int i=0; i < N; i++) {
            StringTokenizer spots = new StringTokenizer(sc.nextLine());
            int x1 = Integer.parseInt(spots.nextToken()) + OFFSET;
            int y1 = Integer.parseInt(spots.nextToken()) + OFFSET;
            int x2 = Integer.parseInt(spots.nextToken()) + OFFSET;
            int y2 = Integer.parseInt(spots.nextToken()) + OFFSET;

            for(int j = x1; j < x2; j++){
                for(int k = y1; k < y2; k++){
                    check[j][k] = i%2==0?1:2; // 빨간색은 1, 파란색은 2
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < 200; i++){
            for(int j = 0; j < 200; j++){
                if(check[i][j]==2) {
                    answer++;
                } 
            }
        }

        System.out.println(answer);

    }
}