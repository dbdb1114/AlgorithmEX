import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Please write your code here.
        // 
        Queue<Integer> Aqueue = new LinkedList<>();
        Queue<Integer> Bqueue = new LinkedList<>();

        Queue<int[]> AVT = new LinkedList<>();
        Queue<int[]> BVT = new LinkedList<>();
        

        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;

        int A = 0;
        int B = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer vt = new StringTokenizer(sc.nextLine());
            int[] arr = {Integer.parseInt(vt.nextToken()), Integer.parseInt(vt.nextToken())};
            AVT.add(arr);
        }
        
        for(int i = 0; i < M; i++) {
            StringTokenizer vt = new StringTokenizer(sc.nextLine());
            int[] arr = {Integer.parseInt(vt.nextToken()), Integer.parseInt(vt.nextToken())};
            BVT.add(arr);
        }
        
        int prevFirst = 1; // A 
        int[] Aarr_ = AVT.poll();
        int[] Barr_ = BVT.poll();

        ifEmpty(Aqueue, Aarr_[0], Aarr_[1]);
        ifEmpty(Bqueue, Barr_[0], Barr_[1]);

        // System.out.println(Aqueue);
        // System.out.println(Bqueue);

        while(A == B){
            if(Aqueue.isEmpty() && !AVT.isEmpty()){
                int[] Aarr = AVT.poll();
                ifEmpty(Aqueue, Aarr[0], Aarr[1]);
            }
            
            if(Bqueue.isEmpty() && !BVT.isEmpty()){
                int[] Barr = BVT.poll();
                ifEmpty(Bqueue, Barr[0], Barr[1]);
            }

            if(!Aqueue.isEmpty()) {
                A += Aqueue.poll();
            }
            
            if(!Bqueue.isEmpty()) {
                B += Bqueue.poll();
            }
        }

        if(Aqueue.isEmpty() && AVT.isEmpty() && Bqueue.isEmpty() && BVT.isEmpty()) {
            System.out.println(0);
            return;
        }

        answer++;
        prevFirst = A > B ? 1 : 2;

        while(true) {
            if(Aqueue.isEmpty() && !AVT.isEmpty()){
                int[] Aarr = AVT.poll();
                ifEmpty(Aqueue, Aarr[0], Aarr[1]);
            }
            
            if(Bqueue.isEmpty() && !BVT.isEmpty()){
                int[] Barr = BVT.poll();
                ifEmpty(Bqueue, Barr[0], Barr[1]);
            }

            if(!Aqueue.isEmpty()) {
                A += Aqueue.poll();
            }
            
            if(!Bqueue.isEmpty()) {
                B += Bqueue.poll();
            }
            
            if(prevFirst != 2 && A < B) {
                answer++;
                prevFirst = 2;
            } else if (prevFirst != 1 && A > B) {
                answer++;
                prevFirst = 1;
            } else if (prevFirst != 0 && A == B){
                answer++;
                prevFirst = 0;
            }

            if(Aqueue.isEmpty() && AVT.isEmpty() && Bqueue.isEmpty() && BVT.isEmpty()) break;
        }

        System.out.println(answer);
    }

    public static void ifEmpty(Queue<Integer> queue, int v, int t){
        for(int i = 0; i < t; i++) {
            queue.add(v);
        }
    }
}