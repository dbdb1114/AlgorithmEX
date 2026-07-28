import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 0;
        for(int i = 0; i < N - 2; i++) {
            for(int j = i + 2; j < N; j++) {
                answer = Math.max(arr[i] + arr[j], answer);
            }
        }

        System.out.println(answer);
    }
}