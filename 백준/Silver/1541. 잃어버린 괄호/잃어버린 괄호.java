import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();

        String[] split = line.split("-");
        int[] splitedResult = Arrays.stream(split).mapToInt(str -> getSum(str)).toArray();
        int answer = splitedResult[0]*2 - Arrays.stream(splitedResult).sum();

        System.out.println(answer);
    }

    static int getSum(String str) {
        int sum = 0;
        String[] split = str.split("[+]");
        for (int i = 0; i < split.length; i++) {
            sum += Integer.parseInt(split[i]);
        }
        return sum;
    }
}
