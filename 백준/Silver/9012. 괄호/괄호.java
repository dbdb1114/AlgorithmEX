import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        // 1. stack에 담는다.
        // 2. peek가 '('이고, push 하는게 ')'라면 푸쉬하지 않고, 안에 있는 것을 팝한다.
        Stack<Character> stack = new Stack<>();
        String[] answer = new String[N];

        for (int i = 0; i < N; i++) {
            String s = bf.readLine();
            findPS(stack, s);
            answer[i] = stack.isEmpty() ? "YES" : "NO";
            stack.clear();
        }

        for (String s : answer) {
            System.out.println(s);
        }
    }
    private static void findPS(Stack<Character> stack, String s){
        for (int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == ')'){
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
    }
}
