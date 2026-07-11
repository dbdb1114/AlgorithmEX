import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        // 1~N N개의 칸 
        // Ai ~ Bi 까지 블럭을 쌓으라는 K번의 명령 
        // N과 K 
        // K 번 반복 
        // 
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] blucks = new int[N];
        for(int i = 0; i < K; i++) {
            int Ai = sc.nextInt();
            int Bi = sc.nextInt();

            for(int j = Ai - 1; j < Bi; j++){
                blucks[j]++;
            }
        }

        int answer = 0;
        for(int i = 0; i < blucks.length; i++){
            answer = Math.max(answer, blucks[i]);
        }

        System.out.println(answer);
    }
}