import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * [==========================문제 분석============================]
 * 강토는 자신의 기타 강의 동영상을 블루레이로 만들어 판매하려고 한다.
 * 블루레이에는 총 N개의 강의가 들어가는데, 블루레이를 녹화할 때, 강의의 순서가 바뀌면 안 된다.
 * 순서가 뒤바뀌는 경우에는 강의의 흐름이 끊겨, 학생들이 대혼란에 빠질 수 있기 때문이다.
 * 즉, i번 강의와 j번 강의를 같은 블루레이에 녹화하려면 i와 j 사이의 모든 강의도 같은 블루레이에 녹화해야 한다.
 *
 * 강토는 이 블루레이가 얼마나 팔릴지 아직 알 수 없기 때문에, 블루레이의 개수를 가급적 줄이려고 한다.
 * 오랜 고민 끝에 강토는 M개의 블루레이에 모든 기타 강의 동영상을 녹화하기로 했다.
 * 이때, 블루레이의 크기(녹화 가능한 길이)를 최소로 하려고 한다. 단, M개의 블루레이는 모두 같은 크기이어야 한다.
 *
 * 강토의 각 강의의 길이가 분 단위(자연수)로 주어진다. 이때, 가능한 블루레이의 크기 중 최소를 구하는 프로그램을 작성하시오.
 * [==예제==]
 * [==입력==]
 * 첫째 줄에 강의의 수 N (1 ≤ N ≤ 100,000)과 M (1 ≤ M ≤ N)이 주어진다.
 * 다음 줄에는 강토의 기타 강의의 길이가 강의 순서대로 분 단위로(자연수)로 주어진다. 각 강의의 길이는 10,000분을 넘지 않는다.
 * [==출력==]
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
		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);

		int[] arr = new int[N];
		String[] nList = br.readLine().split(" ");
		int sum = 0;

		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(nList[i]);
			arr[i] = number;
			sum += number;
		}

		int st = sum/M;
		int ed = sum;

		while(st < ed){
			int mid = (st + ed) / 2;
			int cnt = 0;
			int point = 0;
			int cd = 0;
			while(cnt < M && point < arr.length){
				if(cd + arr[point] > mid){
					cnt++;
					cd=0;
					continue;
				}

				cd += arr[point];
				point++;
			}

			if(point == arr.length){
				ed = mid;
			} else {
				st = mid + 1;
			}
		}

		System.out.println(st);
	}
}
