import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(bf.readLine());
        /**
         * 조합으로 해결할 수 있다.
         * i<j<k 가 항상 보장 될 수 있으므로, 1~N 중에서 세 개의 수를 뽑는 경우의 수와 같다.
         * */
        if (N > 3) {
            long answer = (N * (N - 1) * (N - 2))/ 6;
            System.out.println(answer);
        } else if (N == 3) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        System.out.println(3);
    }
}
