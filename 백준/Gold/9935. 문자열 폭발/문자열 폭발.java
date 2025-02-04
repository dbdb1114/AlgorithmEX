import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();
        int bombLength = bomb.length();
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            stack.push(c);

            // 스택이 폭발 문자열의 길이 이상일 때만 검사
            if (stack.size() >= bombLength) {
                boolean isMatch = true;

                // 스택의 끝부분이 폭발 문자열과 일치하는지 확인
                for (int j = 0; j < bombLength; j++) {
                    if (stack.get(stack.size() - bombLength + j) != bomb.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }

                // 폭발 문자열이면 제거
                if (isMatch) {
                    for (int j = 0; j < bombLength; j++) {
                        stack.pop();
                    }
                }
            }
        }

        // 결과 출력
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        System.out.println(result.length() == 0 ? "FRULA" : result.toString());
    }
}
