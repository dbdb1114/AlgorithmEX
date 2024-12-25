import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            String line = bf.readLine();
            String[] arr = line.split(" ");
            for (int j = 0; j < arr.length; j++) {
                int target = Integer.parseInt(arr[j]);
                if(max <= target){
                    max = target;
                    sb.setLength(0);
                    sb.append(target).append("\n").append((i + 1) + " " + (j + 1));
                }
            }
        }
        System.out.println(sb);
    }
}
