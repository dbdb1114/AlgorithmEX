import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int answer = 0;
        for(int i = 0; i < line.length(); i++) {
            int count = 0;
            if(line.charAt(i) == '(') {
                for(int j = i + 1; j < line.length(); j++) {
                    if(line.charAt(j) == ')') {
                        count++;
                    }
                }
            }
            answer += count;
        }

        System.out.println(answer);
    }
}