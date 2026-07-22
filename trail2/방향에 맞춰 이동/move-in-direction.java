import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};

        int x = 0;
        int y = 0;

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int diIndex = getDirection(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            for(int j = 0; j < distance; j++) {
                x += dx[diIndex];
                y += dy[diIndex];
            }
        }

        System.out.printf("%d %d",x,y);
    }

    static int getDirection(String di ){
        if(di.equals("N")) {        // 북
            return 3;
        } else if(di.equals("W")) { // 서
            return 2;
        } else if(di.equals("S")) { // 남
            return 1;
        } else {                    // 동
            return 0; 
        }
    }
}