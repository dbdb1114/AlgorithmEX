import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제
 * 지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다.
 * 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다.
 * 지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.
 *
 * 체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다.
 * 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고,
 * 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다.
 * 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다.
 * 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.
 *
 * 보드가 체스판처럼 칠해져 있다는 보장이 없어서,
 * 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다.
 * 당연히 8*8 크기는 아무데서나 골라도 된다.
 * 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N과 M이 주어진다.
 * N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다.
 * 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.
 *
 * 출력
 * 첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.
 *
 * 해결방안
 * 문제 분석
 * 1. 전체 입력 크기 :
 *  - N*M 크기의 보드에서 8*8 체스판을 만들 수 있는 모든 경우를 검사해야 함
 *  - 체스판의 좌측 상단이 흰색일 경우와 검은색일 경우 두 가지를 모두 확인해야 함
 * 2. 8 * 8 체스판 조건 확인 :
 *  - 각 8*8 영역에 대해 체스판 규칙에 따라 칸마다 색을 확인하고 다시 칠해야 하는 칸의 수를 계산
 * 시간 복잡도
 * 1. 입력 처리 : O(N*M)
 * 2. 가능한 영역 탐색 : O((N-7)*(M-7))
 * 3. 칸 검사 및 색 비교 : O(128)
 * -----------------------------------------------------------------------

 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] NandM = bf.readLine().split(" ");
        int N = Integer.parseInt(NandM[0]);
        int M = Integer.parseInt(NandM[1]);

        boolean[][] check = new boolean[N][M];

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < M; j++) {
                if((i+j)%2 == 0 && line.charAt(j) != 'B'){
                    check[i][j] = false;
                } else if ((i+j)%2 == 1 && line.charAt(j) == 'B'){
                    check[i][j] = false;
                } else {
                    check[i][j] = true;
                }
            }
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int repair = 0;
                for (int k = i; k < i+8; k++) {
                    for (int l = j; l < j+8; l++) {
                        if(!check[k][l]) repair++;
                    }
                }
                min = Math.min(repair,min);
                max = Math.max(repair,max);
            }
        }

        int answer = Math.min(min, 64-max);
        System.out.println(answer);
    }
}
