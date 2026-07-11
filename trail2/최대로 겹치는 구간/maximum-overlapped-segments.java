import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        int st = 100;
        int ed = -100;
        for(int i = 0; i < N; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            arr[i] = new int[] {x1, x2};

            st = Math.min(st,x1);
            ed = Math.max(ed,x2);
        }
        
        int answer = 0;
        for(int i = st; i < ed; i++){
            int count = 0;
            for(int j = 0; j < N; j++){
                if(arr[j][0] <= i && i < arr[j][1]) {
                    count++;
                }
            }
            answer = Math.max(count, answer);
        }
        
        System.out.println(answer);
    }   
}