import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * [==========================문제 분석============================]
 * 리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다.
 * +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고
 * -를 누르면 -1된 채널로 이동한다.
 * 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.
 *
 * 수빈이가 지금 이동하려고 하는 채널은 N이다.
 * 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성
 * 수빈이가 지금 보고 있는 채널은 100번
 *
 * [==예제==]
 * 첫째 줄에 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)이 주어진다.
 * 둘째 줄에는 고장난 버튼의 개수 M (0 ≤ M ≤ 10)이 주어진다.
 * 고장난 버튼이 있는 경우에는 셋째 줄에는 고장난 버튼이 주어지며, 같은 버튼이 여러 번 주어지는 경우는 없다.
 *
 * 첫째 줄에 채널 N으로 이동하기 위해 버튼을 최소 몇 번 눌러야 하는지를 출력한다.
 *
 * [==입력 / 출력==]
 * 5457
 * 3
 * 6 7 8
 * / 6
 *
 * 100
 * 5
 * 0 1 2 3 4
 * / 0
 *
 * [==========================제한 조건============================]
 *  1. 입력값 범위
 *  N (0 ≤ N ≤ 500,000) / M (0 ≤ M ≤ 10)
 *  2. 시간 제한 2 초
 *  3. 메모리 제한 256 MB
 * [==========================해결 전략============================]
 * case 1 )
 * +/- 버튼만을 이용해 N으로 간다.
 *
 * case 2 )
 *  N을 낮춰가면서, 자리마다 못 쓰는 숫자들이 있는지 확인하는 경우
 *  6 * 6 * 9 * 3
 *
 * changeable : 누적 버튼 변수
 * [==========================슈도 코드============================]
 * N을 낮춰가면서, 자릿수별로 체크
 * for ( N을 탐색 ){
 *     unsuable.contains(N.charAt(i));
 *     N--;
 * }
 *
 * temp = N
 * while(){
 *     temp --;
 *
 * }
 *
 */
public class Main {
    static Set<Integer> unUsable = new HashSet<>();
    static int N;
    static int M;
    static int nLength;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        nLength = (int)(Math.log10(N))+1;
        String line3 = bf.readLine();

        if(line3 != null){
            StringTokenizer tk = new StringTokenizer(line3);
            while (tk.hasMoreTokens()) {
                unUsable.add(Integer.parseInt(tk.nextToken()));
            }
        }

        int pnmBtn = Math.abs(N - 100);

        int underN = Integer.MAX_VALUE;
        for (int i = 0; i <= N + 10; i++) {
            String str = (N - i) + "";
            boolean usable = true;

            for (int j = 0; j < str.length(); j++) {
                if(unUsable.contains((int)str.charAt(j) - 48)){
                    usable = false;
                    break;
                }
            }

            if(usable){
                if(i + str.length() < pnmBtn){
                    underN = str.length() + i;
                }
                break;
            }
        }

        int upperN = Integer.MAX_VALUE;
        for (int i = 1; i <= N + 10; i++) {
            String str = (N + i) + "";
            boolean usable = true;

            for (int j = 0; j < str.length(); j++) {
                if(unUsable.contains(str.charAt(j) - 48)){
                    usable = false;
                    break;
                }
            }

            if(usable){
                if(i + str.length() < pnmBtn){
                    upperN = str.length() + i;
                }
                break;
            }
        }

        int answer = Math.min(upperN,underN);
        answer = Math.min(answer, pnmBtn);

        System.out.println(answer);
    }
}
