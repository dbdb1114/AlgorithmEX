import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] timeTable = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int answer = 0;
        int total = 0;
        for(int time : timeTable){
            total += time;
            answer += total;
        }

        System.out.println(answer);
    }
}
