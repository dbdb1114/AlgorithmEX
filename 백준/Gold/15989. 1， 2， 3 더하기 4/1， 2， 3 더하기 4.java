import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            int answer = 0;
            int three = n / 3;
            int two = (n - (three * 3)) / 2;
            int one = n - (three * 3) - (two * 2);
            // answer++;
            while(three >= 0){
                while(two > 0) {
                    two --;
                    one += 2;
                    answer++;
                }
                three--;
                two = (n - (three * 3)) / 2;
                one = n - (three * 3) - (two * 2);
                answer++;
            }

            // answer++;
            System.out.println(answer);
        }
    }
}
