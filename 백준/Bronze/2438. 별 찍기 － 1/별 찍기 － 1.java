import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    /**
     * 문제
     * 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
     *
     * 입력
     * 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
     *
     * 출력
     * 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
     *
     * 해결 방향
     * 입력받은 수 까지 반복문을 출력한다
     *  1. 입력받은 수 까지 지역변수를 증가시키고, 수만큼 별을 반복하여 찍는다.
     *
     * 테스트 케이스
     * ------------------------------------------------------------------
     * N = 1
     * *
     * ------------------------------------------------------------------
     * N = 3
     * *
     * **
     * ***
     * ------------------------------------------------------------------
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                answer.append("*");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}
