import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer nandm = new StringTokenizer(sc.nextLine());
        
        int N = Integer.parseInt(nandm.nextToken());
        int M = Integer.parseInt(nandm.nextToken());

        Queue<Integer> AMove = new LinkedList<>();
        Queue<Integer> BMove = new LinkedList<>();

        Queue<String> ADQueue = new LinkedList<>();
        Queue<String> BDQueue = new LinkedList<>();

        for(int i = 0; i < N; i++){
            ADQueue.add(sc.nextLine());
        }

        for(int i = 0; i < M; i++){
            BDQueue.add(sc.nextLine());
        }
        
        int a = 0;
        int b = 0;

        int prev_a = 0;
        int prev_b = 0;

        fillMove(AMove, ADQueue);
        fillMove(BMove, BDQueue);

        // System.out.println(AMove);
        // System.out.println(BMove);

        int answer = 0;
        while(!(AMove.isEmpty() && BMove.isEmpty() && ADQueue.isEmpty() && BDQueue.isEmpty())) {
            // System.out.println("A : " + a + ", B : " + b);

            if(AMove.isEmpty() && !ADQueue.isEmpty()) {
                fillMove(AMove, ADQueue);
            }

            if(!AMove.isEmpty()) {
                a = a + AMove.poll();
            }
            
            if(BMove.isEmpty() && !BDQueue.isEmpty()) {
                fillMove(BMove, BDQueue);
            }

            if(!BMove.isEmpty()) {
                b = b + BMove.poll();
            }
            
            if(prev_a != prev_b && a == b ) {
                answer++;
            }

            prev_a = a;
            prev_b = b;
        }

        System.out.println(answer);

    }

    public static void fillMove (Queue<Integer> move, Queue<String> dque){
        StringTokenizer st = new StringTokenizer(dque.poll());
        int t = Integer.parseInt(st.nextToken());
        int d = st.nextToken().equals("R") ? 1 : -1;
        for(int i = 0; i < t; i++){
            move.add(d);
        }
    }

}