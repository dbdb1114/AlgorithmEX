import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] moving = line.split("");
        int N = moving.length;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0;
        int y = 0;
        int now = 0;
        for(int i = 0; i < N; i++) {
            if(moving[i].equals("F")) {
                x += dx[now];
                y += dy[now];
                continue;
            } else if (moving[i].equals("R")) {
                now = getDiIndex(++now);
            } else {
                now = getDiIndex(--now);
            }
        }
        System.out.printf("%d %d", x, y);
    }

    static int getDiIndex(int now){
        if(now < 0) {
            return 3;
        } else if(now > 3) {
            return 0;
        }
        return now;
    }
}