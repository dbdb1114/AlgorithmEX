import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] numbers = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] check = new int[N];
        int answer = 1;

        check[N-1] = 1;
        for (int i = N - 2; i >= 0; i--) {
            for (int j = i+1; j < N; j++) {
                if(numbers[j] < numbers[i]){
                    check[i] = Math.max(check[i], check[j] + 1);
                } else if (numbers[j] == numbers[i]){
                    check[i] = Math.max(check[i], check[j]);;
                } else {
                    check[i] = Math.max(check[i],1);
                }
            }
            answer = Math.max(answer, check[i]);
        }
        
        System.out.println(answer);
    }
}
