import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] students = new int[N];
        for(int i = 0; i < M; i++){
            int stIndex = Integer.parseInt(sc.nextLine()) - 1;
            students[stIndex]++;
            if(students[stIndex] >= K) {
                System.out.println(stIndex + 1);
                return;
            }
        }

        System.out.println(-1);
    }
}