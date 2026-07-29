import java.util.*;

public class Main {

    static int N;
    static String line;
    static int answer = 0;
    static char[] COW = {'C', 'O', 'W'};

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        line = sc.nextLine();
        
        for(int i = 0; i < N; i++) {
            if(line.charAt(i) == 'C'){
                recursive(i,1);
            }
        }
        
        System.out.println(answer);
    }

    public static void recursive(int pos, int now) {
        // System.out.println(now);
        if(now == 3) {
            answer++;
            return ;
        }

        for(int i = pos + 1; i < N; i++) {
            if(line.charAt(i) == COW[now]) {
                recursive(i, now+1);
            }
        }
    }
}