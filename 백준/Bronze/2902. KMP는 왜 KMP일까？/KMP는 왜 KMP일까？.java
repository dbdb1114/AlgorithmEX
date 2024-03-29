import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bf.readLine().split("-");
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string.charAt(0));
        }
        System.out.println(sb);
    }
}
