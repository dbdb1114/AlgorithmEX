import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * [==========================문제 분석============================]
 * 오늘은 스타트링크에 다니는 사람들이 모여서 축구를 해보려고 한다.
 * 축구는 평일 오후에 하고 의무 참석도 아니다.
 * 축구를 하기 위해 모인 사람은 총 N명이고 신기하게도 N은 짝수이다.
 * 이제 N/2명으로 이루어진 스타트 팀과 링크 팀으로 사람들을 나눠야 한다.
 *
 * BOJ를 운영하는 회사 답게 사람에게 번호를 1부터 N까지로 배정했고, 아래와 같은 능력치를 조사했다.
 * 능력치 Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치이다.
 * 팀의 능력치는 팀에 속한 모든 쌍의 능력치 Sij의 합이다. Sij는 Sji와 다를 수도 있으며,
 * i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij와 Sji이다.
 *
 *
 * [==예제==]
 * [==입력==]
 * 첫째 줄에 N(4 ≤ N ≤ 20, N은 짝수)이 주어진다.
 * 둘째 줄부터 N개의 줄에 S가 주어진다.
 * 각 줄은 N개의 수로 이루어져 있고,
 * i번 줄의 j번째 수는 Sij 이다. Sii는 항상 0이고,
 * 나머지 Sij는 1보다 크거나 같고, 100보다 작거나 같은 정수이다.
 * [==출력==]
 * 첫째 줄에 스타트 팀과 링크 팀의 능력치의 차이의 최솟값을 출력한다.
 *
 * [==========================제한 조건============================]
 *  1. 입력값 범위
 *  2. 시간 제한 N초
 *  3. 메모리 제한 NMB
 * [==========================해결 전략============================]
 * 각 두 명 : 두 명으로 나누어서 각 나올 수 있는 수들의 차이의 최소를 구해주자.
 * [==========================슈도 코드============================]
 * N은 1~20 까지가 됨.
 *  해당 문제의 경우 nPr 혹은 nCr이 사용될텐데 nPr은 O(N!) 정도기 때문에
 *  2억을 훌쩍 넘어가서 사용할 수 없음.
 *  nCr을 사용하는게 좋음 nCr은 N^20임.
*/
public class Main {

    static boolean[] visit;
    static int[][] matrix;
    static int N, answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        matrix = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            String[] s = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(s[j]);
            }
        }

        combination(0,0);
        System.out.println(answer);
    }

    public static void combination(int st, int depth){

        if(depth == N/2){
            answer = Math.min(answer, calculation());
            return;
        }

        for (int i = st; i < N; i++) {
            visit[i] = true;
            combination(i+1, depth+1);
            visit[i] = false;
        }
    }

    private static int calculation() {
        int stateam = 0;
        int linteam = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i+1; j < N; j++) {
                if(visit[i] && visit[j]){
                    stateam += matrix[i][j];
                    stateam += matrix[j][i];
                }
                if(!visit[i] && !visit[j]){
                    linteam += matrix[i][j];
                    linteam += matrix[j][i];
                }
            }
        }

        return Math.abs(stateam - linteam);
    }

}
