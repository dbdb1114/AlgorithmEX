import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * [==========================문제 분석============================]
 * N개의 정수로 이루어진 수열
 * 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수
 * [==예제==]
 * [==입력==]
 * 첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다.
 * (1 ≤ N ≤ 20, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다.
 *  %% 주어지는 정수의 절댓값은 100,000을 넘지 않는다. %%
 *  %% 위와 같은 말이 있지만, 부등호 표시에서는 100만으로 나온다.
 *  20 * 1000000 = 20,000,000 => 그래도 long을 쓸 필요는 없다.
 *  5 0
 * -7 -3 -2 5 8
 * [==출력==]
 * 1
 * [==========================제한 조건============================]
 *  1. 입력값 범위
 *  (1 ≤ N ≤ 20, |S| ≤ 1,000,000)
 *  2. 시간 제한 2초
 *  3. 메모리 제한 256MB
 *  => 여유로운 정도
 * [==========================해결 전략============================]
 * 부분 수열의 합이 S가 되면 되므로, 이는 전체 탐색을 해야함.
 * DFS를 활용하면 좋을 것 같음
 * [==========================슈도 코드============================]
 * main(){
 *     N, S [init]
 *     int[] An [수열 init]
 *
 *     int answer = DFS(0,0,S);
 *
 * }
 *
 * dfs(int st, int sum, int goal){
 *     if( depth == goal ) {
 *         count++;
 *     }
 *
 *     for(st ~ goal) {
 *         sum += An[i];
 *         dfs(st + 1, sum, goal);
 *         sum -= An[i]
 *     }
 * }
*/
public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int answer = 0;
    static int[] An;
    static int N;
    static int S;
    public static void main(String[] args) throws IOException {

        int[] input = makeIntAr.apply(bf.readLine());
        An = makeIntAr.apply(bf.readLine());

        N = input[0];
        S = input[1];

        DFS(0,0,S);

        System.out.println(answer);
    }

    private static void DFS(int st, int sum, int goal) {
        if(sum == goal && st > 0){
            answer++;
        }

        for (int i = st; i < An.length; i++) {
            sum += An[i];
            DFS(i+1, sum, goal);
            sum -= An[i];
        }
    }

    static Function<String, int[]> makeIntAr = str ->Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();

}
