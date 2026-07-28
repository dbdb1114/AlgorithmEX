import java.util.*;

public class Main {

    static int[] limits;
    static int N;
    
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);
        // N개의 방이 있다. 
        // 1~N까지 시계 반대 방향으로 번호가 있다. 
        // 각 방에는 이웃한 두 개의 방으로 통과하는 문이 있다. 
        // 사람들은 무조건 시계 반대 방향으로 이동한다. 
        N = Integer.parseInt(sc.nextLine());
        limits = new int[N];

        for(int i = 0; i < N; i++) {
            limits[i] = Integer.parseInt(sc.nextLine());
        }

        // 목적지,
        // 목적지까지 이동하는 거리를 재야하고, 
        // 목적지까지 이동하는 사람은 limits[] 배열에 있고,
        // 
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            int start = i;
            int sum = 0;
            // System.out.println("==== start : " + (start+1) + " =====");
            for(int j = 0; j < N; j++) {
                int goal = j;
                // System.out.println("=== goal : " + (goal+1) + " =====");
                if(goal == start) continue;
                int dist = calculate(start, goal);
                sum += dist;
                // System.out.println("== dist : " + dist + " =====");
            }

            answer = Math.min(sum, answer);
        }

        System.out.println(answer);
    }

    static int calculate(int start, int goal) {
        if(goal < start) {
            return (N - start + goal) * limits[goal] ;
        } else if (goal > start) {
            return (goal - start) * limits[goal] ;
        }
        return 0;
    }
}