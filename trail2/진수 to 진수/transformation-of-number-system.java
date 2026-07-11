import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        // 정수 A, B / A 진수로 표현된 어떤 수 N 
        // N을 B 진수로 

        // N => A로 십진수로 다시 바꾸기 
        // A십진수를 다시 B진수로 바꾸기 
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        long B = sc.nextLong();
        sc.nextLine();
        String N = sc.nextLine();
        Long Na = 0l;
        for(int i = N.length()-1; i>=0; i--){
            if(N.charAt(i) != '0'){
                int digit = N.charAt(i) - '0';
                Na += digit * (long) Math.pow(A,N.length() - 1 -i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(Na >= B){
            sb.append(Na%B);
            Na /= B;
        }
        sb.append(Na%B);

        System.out.println(sb.reverse());
    }
}