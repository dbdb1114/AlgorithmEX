import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        // 0과 1로 이루어진 이진수
        Scanner sc = new Scanner(System.in);
        String biN = sc.nextLine();
        int answer = 0;
        
        for(int i = biN.length() - 1; i >= 0; i--) {
            if(biN.charAt(i) == '1'){
                answer += Math.pow(2,biN.length() - 1 - i);
            }
        }
        System.out.println(answer);
    }
}