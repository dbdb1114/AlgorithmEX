import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        // asis N 
        // tobe B 
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(N >= B) {
            sb.append(N%B);
            N /= B;
        }
        sb.append(N%B);
        System.out.println(sb.reverse());
    }
}