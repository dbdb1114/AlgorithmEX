import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        // 0,0에서 시작하여 총 N번 움직
        // N번에 걸쳐 움직이려는 방향과 움직일 거리가 주어짐. 
        // 1초에 한 칸씩 움직일 때 몇 초 뒤에 0,0으로 돌아오는가?

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int x = 0;
        int y = 0;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int time = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int di = getDirectionIndex(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            for(int j = 0; j < number; j++){
                time++;
                x += dx[di];
                y += dy[di];
                if(x == 0 && y == 0) break;
            }

            if(x == 0 && y == 0) break;            
        }

        if(x != 0 || y != 0){
            System.out.println(-1);
            return;
        }

        System.out.println(time);

    }

    static int getDirectionIndex(String di) {
        if(di.equals("N")) return 0;
        if(di.equals("E")) return 1;
        if(di.equals("S")) return 2;
        if(di.equals("W")) return 3;

        return 0;
    }
}