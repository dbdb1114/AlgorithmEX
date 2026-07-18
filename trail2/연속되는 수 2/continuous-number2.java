import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        int[] arr= new int[N];
        for(int i = 0; i < N-1; i++){
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        int answer = 0;
        for(int i = 0; i < N; i++){
            int num = arr[i];
            int count = 1;
            while(i<N-1 && num == arr[i]){
                count++;
                num = arr[i++];
            }

            answer =Math.max(answer,count);
        }

        System.out.println(answer);
    }
}