import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] arr= new int[N];
        StringTokenizer st2 = new StringTokenizer(sc.nextLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int count = arr[0] > T ? 1 : 0;
        int answer = count;

        for(int i = 1; i < N; i++){
            if(arr[i-1] > T && arr[i] > T){
                count++;
            } else if(arr[i-1] <= T && arr[i] > T) {
                count = 1;
            } else {
                count = 0;
            }

            answer = Math.max(count, answer);
        }

        System.out.println(answer);

    }
}