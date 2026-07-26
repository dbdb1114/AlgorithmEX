import java.util.*;

public class Main {

    static String[][] map;
    static int R;
    static int C;
    static int answer = 0;


    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new String[R][C];
        for(int i = 0; i < R; i++) {
            StringTokenizer st2 = new StringTokenizer(sc.nextLine());
            for(int j = 0; j < C; j++) {
                map[i][j] = st2.nextToken();
            }
        }

        recursive(0,0,0);
        
        // 탐색의 종료 조건은 최하단이거나 최우측인데, 현재 위치가 도착지점이 아닐때
        //   1. 최하단일 때
        //   2. 최우측일 때
        //   3. 세 번 움직였는데, 도착 지점이 아닐 때
        // 
        System.out.println(answer);
    }

    static void recursive(int x, int y, int count) {
        // System.out.println("x : " + x + ", y : " + y + ", count : " + count);
        if(count == 3){
            if(x == R - 1 && y == C - 1) {
                answer++;
            }
            return;
        } 

        for(int i = x + 1; i < R; i++) {
            for(int j = y + 1; j < C; j++) {
                if(!map[x][y].equals(map[i][j])){
                    recursive(i,j,count+1);
                }
            }
        }
    }
}