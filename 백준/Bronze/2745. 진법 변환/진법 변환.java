import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");

        int answer = Integer.parseInt(input[0], Integer.parseInt(input[1]));
        System.out.println(answer);
    }
}
