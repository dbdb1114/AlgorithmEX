import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[1_000_000];
        int[] B = new int[1_000_000];

        int aIdx = 0;
        for(int i = 0; i < N; i++){
            StringTokenizer st1 = new StringTokenizer(sc.nextLine());
            int v = Integer.parseInt(st1.nextToken());
            int t = Integer.parseInt(st1.nextToken());
            for(int j = 0; j < t; j++, aIdx++){
                A[aIdx] = v;
            }
        }
        
        int bIdx = 0;
        for(int i = 0; i < M; i++){
            StringTokenizer st1 = new StringTokenizer(sc.nextLine());
            int v = Integer.parseInt(st1.nextToken());
            int t = Integer.parseInt(st1.nextToken());
            for(int j = 0; j < t; j++, bIdx++){
                B[bIdx] = v;
            }
        }

        int totTime = aIdx;
        int a_pos = 0; // 1
        int b_pos = 0; // 2
        int prev = -1;
        int answer = 0;
        
        int start = 0;
        for(int i = 0; i < totTime; i++){
            a_pos += A[i];
            b_pos += B[i];

            if(a_pos > b_pos){
                prev = 1;
                start = i+1;
                break;
            } else if(b_pos > a_pos) {
                prev = 2;
                start = i+1;
                break;
            }
        }

        for(int i = start; i < totTime; i++){
            a_pos += A[i];
            b_pos += B[i];

            if(prev == 2 && a_pos > b_pos){
                prev = 1;
                answer++;
            } else if(prev == 1 && b_pos > a_pos) {
                prev = 2;
                answer++;
            }
        }

        System.out.println(answer);
    }
}