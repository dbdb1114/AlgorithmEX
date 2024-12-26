
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            Stack<String> stack = new Stack<>();
            String[] line = br.readLine().split("");
            if(line.length == 0){
                System.out.println("NO");
                continue;
            }
            stack.push(line[0]);
            for (int j = 1; j < line.length; j++) {
                if(!stack.isEmpty()&&stack.peek().equals("(") && line[j].equals(")")){
                    stack.pop();
                } else {
                    stack.push(line[j]);
                }
            }
            if(stack.isEmpty()){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
