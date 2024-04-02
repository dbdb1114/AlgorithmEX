import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();

        String[] strToAr = s.replace("::",":HERE:").split(":");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strToAr.length; i++) {
            if(strToAr[i].equals("HERE")){
                sb.append("0000:".repeat(9 - strToAr.length));
            } else {
                sb.append("0".repeat(4-strToAr[i].length())).append(strToAr[i]).append(":");
            }
        }

        sb.delete(sb.length()-1,sb.length());
        System.out.println(sb);
    }
}
