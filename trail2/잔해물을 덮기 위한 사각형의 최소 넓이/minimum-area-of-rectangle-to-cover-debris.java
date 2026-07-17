import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        // 덮기 위한 좌표를 구해야 되는데, 
        // 덮이지 않은 x의 최소, y의 최대, 
        // 덮이지 않은 x의 최대, y의 최소
        Scanner sc = new Scanner(System.in);
        int OFFSET = 1000; 
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int x1 = Integer.parseInt(st.nextToken()) + OFFSET;
        int y1 = Integer.parseInt(st.nextToken()) + OFFSET;
        int x2 = Integer.parseInt(st.nextToken()) + OFFSET;
        int y2 = Integer.parseInt(st.nextToken()) + OFFSET;
        
        st = new StringTokenizer(sc.nextLine());
        int ex1 = Integer.parseInt(st.nextToken()) + OFFSET;
        int ey1 = Integer.parseInt(st.nextToken()) + OFFSET;
        int ex2 = Integer.parseInt(st.nextToken()) + OFFSET;
        int ey2 = Integer.parseInt(st.nextToken()) + OFFSET;

        int[][] map = new int[2000][2000];
        for(int i = x1; i < x2; i++){
            for(int j = y1; j < y2; j++){
                map[i][j] = 1;
            }
        }
        
        for(int i = ex1; i < ex2; i++){
            for(int j = ey1; j < ey2; j++){
                map[i][j] = 2;
            }
        }


        int minX = 9999;
        int minY = 9999;
        int maxX = -9999;
        int maxY = -9999;
        int count = 0;
        for(int i = 0; i < 2000; i++){
            for(int j = 0; j < 2000; j++){
                if(map[i][j] == 1){
                    count++;
                    minX = Math.min(i, minX);
                    minY = Math.min(j, minY);
                    maxX = Math.max(i, maxX);
                    maxY = Math.max(j, maxY);
                }
            }
        }

        // 눕혔기 때문에 최대 X, 최소 Y => 좌하단
        // 최소 X, 최대 Y => 우하단 이다. 
        if(count == 0){
            System.out.println(0);
        } else {
            System.out.println((maxX - minX + 1) * (maxY-minY + 1));
        }
        

    }
}