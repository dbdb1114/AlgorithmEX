import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        // StringTokenizer st = new StringTokenizer();
        String line = sc.nextLine();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int now = 0;
        int x = 0;
        int y = 0;
        int answer = 0;
        for(int i = 0; i < line.length(); i++) {
            char di = line.charAt(i);
            if(di == 'L'){
                now--;
                now = getIndex(now);
            } else if(di == 'R') {
                now++;
                now = getIndex(now);
            } else {
                x += dx[now];
                y += dy[now];
            }

            if(x == 0 && y == 0){
                answer = i + 1;
                break;
            }
        }

        if(answer == 0) {
            answer = -1;
        }

        System.out.println(answer);
    }

    static int getIndex(int n ) {
        if(n == 4) return 0;
        if(n == -1) return 3;
        return n;
    }
}