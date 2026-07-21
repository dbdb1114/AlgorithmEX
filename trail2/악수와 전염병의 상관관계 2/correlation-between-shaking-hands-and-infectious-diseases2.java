import java.util.*;

public class Main {

    // 감염여부 
    static boolean[] sick;
    static int[] count;

    static int N;
    static int K;
    static int P;
    static int T;
    
    public static void main(String[] args) {
        // Please write your code here.

        // N명의 개발자들이 있고, T번에 걸쳐 t초에 x 개발자가 y개발자와 악수
        // 최초 감염 이후 K번의 악수 동안만 전염병을 옮김 
        // 
        // N => N 명의 개발자 
        // K => 감염자가 감염 직후 점염시키는 횟수 
        // P => 처음 전염병 걸린 사람 
        // T => T번에 걸쳐 악수
        
        // 
        // 각 개발자들의 감염 이후 악수 횟수가 필요함

        // 감염의 조건은 t초 동안 악수를 해야함
        // t를 기반으로 정렬 => 
        // 감염자와 악수를 하면 감염됨
        // 감염 이후 악수 횟수도 카운팅을 해야함 

        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        // System.out.printf("N : %d, K : %d, P : %d, T : %d", N, K, P, T );

        sick = new boolean[N+1];
        count = new int[N+1];

        sick[P] = true;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for(int i = 0; i < T; i++){
            StringTokenizer handshake = new StringTokenizer(sc.nextLine());
            int[] arr = {
                Integer.parseInt(handshake.nextToken()),
                Integer.parseInt(handshake.nextToken()),
                Integer.parseInt(handshake.nextToken())
            };

            pq.add(arr);
        }

        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
            // System.out.println(Arrays.toString(arr));
            handShake(arr[1],arr[2]);
        }

        for(int i = 1; i <= N; i++) {
            System.out.print(sick[i]?1:0);
        }

    }

    static void handShake(int x, int y) {
        if((sick[x] && count[x] < K) || (sick[y] && count[y] < K)){

            // 감염자의 카운팅
            if(sick[x] && count[x] < K) {
                count[x]++;
            }
            
            if(sick[y] && count[y] < K) {
                count[y]++;
            }

            sick[x] = true;
            sick[y] = true;
        }
    }
}