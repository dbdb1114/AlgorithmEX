import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static int getInteger() throws IOException {
        return Integer.parseInt(bf.readLine());
    }

    public static int[] getIntegerArr() throws IOException{
        return Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) throws IOException {
        int K = getInteger();
        Stack<Integer> arrStack = new Stack<>();

        // 처음 수로 0이 들어왔을 때
        arrStack.add(0);
        int sum = 0;

        for (int i = 0; i < K; i++) {
            int JaHyun = getInteger();
            if(JaHyun == 0){
                sum -= arrStack.peek();
                arrStack.pop();
            } else {
                sum += JaHyun;
                arrStack.push(JaHyun);
            }
        }

        System.out.println(sum);
    }
}
