import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        // 여는 괄호 갯수를 0번 인덱스 
        // 닫는 괄호 갯수를 1번 인덱스 
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int N = line.length();
        int answer = 0;

        for(int i = 1; i < N; i++) {
            boolean isContinuousOpend = line.charAt(i-1) == '(' 
                && line.charAt(i) == '(';
            if(!isContinuousOpend) continue;
            
            for(int j = i + 1; j < N - 1; j++) {
                if(line.charAt(j) == ')' && line.charAt(j+1) == ')' ) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}