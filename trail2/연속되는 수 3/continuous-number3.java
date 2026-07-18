import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        int prev = arr[0];
        boolean prevIsPlus = prev > 0;
        int count = 1;
        int answer = 1;
        for(int i = 1; i < N; i++){
            if(prevIsPlus == arr[i] > 0){
                count++;
            } else {
                count = 1;
                prevIsPlus = arr[i] > 0;
            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}