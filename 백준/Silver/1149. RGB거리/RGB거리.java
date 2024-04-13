import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * [==========================문제 분석============================]
 *  RGB거리에는 집이 N개 있다.
 *  거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
 *
 *  집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다.
 *  각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때,
 *  아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
 *
 *  1번 집의 색은 2번 집의 색과 같지 않아야 한다.
 *  N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
 *  i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
 * [==예제==]
 * [==입력==]
 * [==출력==]
 * [==========================제한 조건============================]
 *  1. 입력값 범위
 *  2. 시간 제한 N초
 *  3. 메모리 제한 NMB
 * [==========================해결 전략============================]
 * 각 라인별 최소를 고를 수 없는 경우에 로직처리를 하자
 * 71 39 44
 * 32 83 55
 * 51 37 63
 * 89 29 100
 * 83 10 110
 * 65 13 15
 * 47 25 29
 * 60 66 19

 * [==========================슈도 코드============================]
*/
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[][] RGB싫어 = new int[N+1][3];
        int[][] 이것이비용 = new int[N+1][3];

        for (int i = 1; i <= N; i++) {
            String[] s = bf.readLine().split(" ");

            RGB싫어[i][0] = Integer.parseInt(s[0]);
            RGB싫어[i][1] = Integer.parseInt(s[1]);
            RGB싫어[i][2] = Integer.parseInt(s[2]);
        }

        for (int i = 1; i <= N; i++) {
            이것이비용[i][0] = Math.min(이것이비용[i-1][1], 이것이비용[i-1][2]) + RGB싫어[i][0];
            이것이비용[i][1] = Math.min(이것이비용[i-1][0], 이것이비용[i-1][2]) + RGB싫어[i][1];
            이것이비용[i][2] = Math.min(이것이비용[i-1][0], 이것이비용[i-1][1]) + RGB싫어[i][2];
        }

        System.out.println(이것이최소다(이것이비용[N][0],이것이비용[N][1],이것이비용[N][2]));
    }

    public static int 이것이최소다(int 숫자1, int 숫자2, int 숫자3){
        return Math.min(숫자1,Math.min(숫자2,숫자3));
    }
}
