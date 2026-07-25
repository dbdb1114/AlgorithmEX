import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] house = new int[N];

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for(int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 999999999;
        for(int i = 0; i < N; i++) {
            int val = 0;
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                val += house[j] * Math.abs(j-i);
            }

            answer = Math.min(val, answer);
        }

        System.out.println(answer);
    }
}