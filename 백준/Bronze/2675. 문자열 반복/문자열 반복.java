import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] line = bf.readLine().split(" ");

            int R = Integer.parseInt(line[0]);
            String str = line[1];

            line[1].chars().forEach(x->addChar(sb,(char)x,R));

            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void addChar(StringBuilder sb, char ch, int cnt){
        for (int i = 0; i < cnt; i++) {
            sb.append(ch);
        }
    }
}
