import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int[] cows = new int[N];

        for(int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int i = 0; i < N; i++) {
            int ftCow = cows[i];
            for(int j = i + 1; j < N; j++ ){
                if(cows[j] < ftCow) continue;
                int scCow = cows[j];
                for(int k = j + 1; k < N; k++){
                    if(cows[k] < scCow) continue;
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}