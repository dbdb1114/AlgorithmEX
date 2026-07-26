import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[][] checks = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            checks[i][0] = Integer.parseInt(st.nextToken());
            checks[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int totalDist = 0;
        int answer = Integer.MAX_VALUE;
        

        for(int i = 1; i < N - 1; i++) {
            int dist = 0;
            Queue<int[]> qu = new LinkedList<>();
            // System.out.println("------------------------------");
            // System.out.println(i + "는 제외");
            for(int j = 0; j < N; j++){
                if(j == i) continue;
                // System.out.println(Arrays.toString(checks[j]));
                qu.add(checks[j]);
            }
            
            int[] prevCheck = qu.poll();
            while(!qu.isEmpty()) {
                int[] check = qu.poll();
                dist += getDist(prevCheck[0],prevCheck[1],check[0],check[1]);
                prevCheck = check;
            }

            answer = Math.min(answer,dist);
        }
        System.out.println(answer);
    }

    static int getDist(int x1, int y1, int x2, int y2) {
        // System.out.println("x1 : " + x1 + ", y1 : " + y1);
        // System.out.println("x2 : " + x2 + ", y2 : " + y2);
        return Math.abs(x2-x1) + Math.abs(y2-y1);
    }
}