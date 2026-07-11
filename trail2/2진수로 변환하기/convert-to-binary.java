import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while ( N >= 2 ){
            int n = N % 2;
            N /= 2;
            sb.append(n);
        }
        sb.append(N%2);
        System.out.println(sb.reverse());
    }
}