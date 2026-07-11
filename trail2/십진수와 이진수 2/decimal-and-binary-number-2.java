import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        // 이진수로 표현되는 자연수 N
        // 심진수로 바꿔서 * 17 
        // 다시 이진수
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        int tenN = 0;
        // N => 십진수 
        for(int i = N.length()-1; i >=0; i--) {
            if(N.charAt(i) == '1'){
                tenN += Math.pow(2,N.length() - 1 - i);
            }
        }
        
        tenN *= 17;
        StringBuilder sb = new StringBuilder();
        while(tenN >= 2){
            sb.append(tenN % 2);
            tenN /= 2;
        }
        sb.append(tenN % 2);
        System.out.println(sb.reverse());
    }
}