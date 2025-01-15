import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [==========================문제 분석============================]
 * 일차원 좌표상의 점 N개와 선분 M개가 주어진다.
 * 이때, 각각의 선분 위에 입력으로 주어진 점이 몇 개 있는지 구하는 프로그램을 작성하시오.
 * [==예제==]
 * [==입력==]
 * 첫째 줄에 점의 개수 N과 선분의 개수 M이 주어진다. (1 ≤ N, M ≤ 100,000)
 * 둘째 줄에는 점의 좌표가 주어진다.
 * 두 점이 같은 좌표를 가지는 경우는 없다.
 * 셋째 줄부터 M개의 줄에는 선분의 시작점과 끝점이 주어진다.
 * 입력으로 주어지는 모든 좌표는 1,000,000,000보다 작거나 같은 자연수이다.
 * [==출력==]
 * 입력으로 주어진 각각의 선분 마다, 선분 위에 입력으로 주어진 점이 몇 개 있는지 출력한다.
 * [==========================제한 조건============================]
 *  1. 입력값 범위
 *  2. 시간 제한 N초
 *  3. 메모리 제한 NMB
 * [==========================해결 전략============================]
 * [==========================슈도 코드============================]
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NandM = br.readLine().split(" ");

		int N = Integer.parseInt(NandM[0]);
		int M = Integer.parseInt(NandM[1]);

		int[] dots = new int[N];
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < dots.length; i++) {
			dots[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		Arrays.sort(dots);

		for (int i = 0; i < M; i++) {
			String[] line = br.readLine().split(" ");

			int lineSt = Integer.parseInt(line[0]);
			int lineEd = Integer.parseInt(line[1]);

			int dotSt = 0;
			int dotEd = dots.length - 1;

			int stIdx = 0;
			int edIDx = 0;

			while(dotSt <= dotEd){
				int mid = (dotSt + dotEd)/2;
				if(dots[mid] < lineSt){
					dotSt = mid + 1;
				} else {
					dotEd = mid - 1;
				}
			}
			stIdx = dotSt;

			dotSt = 0;
			dotEd = dots.length - 1;
			while(dotSt <= dotEd){
				int mid = (dotSt + dotEd)/2;
				if(lineEd < dots[mid]){
					dotEd = mid - 1;
				} else {
					dotSt = mid + 1;
				}
			}
			edIDx = dotEd;
			System.out.println(edIDx - stIdx + 1);
		}
	}
}
