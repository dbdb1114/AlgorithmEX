import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [==========================문제 분석============================]
 * 집에서 시간을 보내던 오영식은 박성원의 부름을 받고 급히 달려왔다.
 * 박성원이 캠프 때 쓸 N개의 랜선을 만들어야 하는데 너무 바빠서 영식이에게 도움을 청했다.
 *
 * 이미 오영식은 자체적으로 K개의 랜선을 가지고 있다. 그러나 K개의 랜선은 길이가 제각각이다.
 * 박성원은 랜선을 모두 N개의 같은 길이의 랜선으로 만들고 싶었기 때문에 K개의 랜선을 잘라서 만들어야 한다.
 * 예를 들어 300cm 짜리 랜선에서 140cm 짜리 랜선을 두 개 잘라내면 20cm는 버려야 한다. (이미 자른 랜선은 붙일 수 없다.)
 *
 * 편의를 위해 랜선을 자르거나 만들 때 손실되는 길이는 없다고 가정하며,
 * 기존의 K개의 랜선으로 N개의 랜선을 만들 수 없는 경우는 없다고 가정하자.
 * 그리고 자를 때는 항상 센티미터 단위로 정수길이만큼 자른다고 가정하자.
 *
 * N개보다 많이 만드는 것도 N개를 만드는 것에 포함된다.
 * 이때 만들 수 있는 최대 랜선의 길이를 구하는 프로그램을 작성하시오.
 *
 * K개의 랜선을 같은 길이의 N 개의 랜선으로 만들어야함
 * 정수 단위로만 자름.
 * 항상 K개의 랜선으로 N개의 랜선을 만들 수 있음
 * 이때 만들 수 있는 최대 랜선의 길이를 구해야함.
 *
 * 이분 탐색으로 N개의 랜선 길이를 찾으면 어떨까
 *
 * [==예제==]
 * 4 11
 * 802
 * 743
 * 457
 * 539
 *
 * 200
 * [==입력==]
 * 첫째 줄에는 오영식이 이미 가지고 있는 랜선의 개수 K, 그리고 필요한 랜선의 개수 N이 입력된다.
 * K는 1이상 10,000이하의 정수이고,
 * N은 1이상 1,000,000이하의 정수이다.
 *
 * 그리고 항상 K ≦ N 이다.
 * 그 후 K줄에 걸쳐 이미 가지고 있는 각 랜선의 길이가 센티미터 단위의 정수로 입력된다.
 * 랜선의 길이는 2^31 - 1 보다 작거나 같은 자연수이다. // integer
 * [==출력==]
 * [==========================제한 조건============================]
 *  1. 입력값 범위
 *  1 <= K <= 10,000, 1 <= N <= 1,000,000
 *  2. 시간 제한 2초
 *  3. 메모리 제한 128MB
 * [==========================해결 전략============================]
 * 1부터 최대 N까지를 이분탐색 한다.
 * 최대 N의 길이는 K를 합해서 N으로 나눈 값이다.
 * 이분 탐색으로 만든 N의 길이로 자르는 시뮬레이션을 해서, 최대 길이를 구한다.
 * [==========================슈도 코드============================]
 * main() {
 *     int K, int N 입력받기
 *     K길이의 인트 배열
 *     int[] kArr = new int[K];
 *     Int max = 0;
 *     for(K){
 *          kArr[i] 입력받기
 *          max += 입력받기
 *     }
 *
 *     int st = 1;
 *     int ed = max;
 *     int answer = 0;
 *
 *     while( st < ed ) {
 *     		int point = st + ((ed - st) / 2) ;
 *     		int lanLine
 *         point로 kArr랜선 자르기
 *
 *         if(lanLine >= N) {
 *         		answer = Math.max(answer, point);
 *             st = point;
 *         } else {
 *             ed = point;
 *         }
 *
 *     }
 *     print(answer)
 * }
 *
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] KandN = br.readLine().split(" ");
		int K = Integer.parseInt(KandN[0]);
		int N = Integer.parseInt(KandN[1]);

		int[] kArr = new int[K];
		long max = 0;

		for (int i = 0; i < K; i++) {
			int k = Integer.parseInt(br.readLine());
			kArr[i] = k;
			max += k;
		}

		// 최대 랜선 길이
		max /= N;

		long st = 1;
		long ed = (int) max;
		long answer = 0;

		while (st <= ed) {
			long point = st + ((ed - (st - 1)) / 2);
			long lanLine = 0;

			for (int i = 0; i < K; i++) {
				lanLine += kArr[i]/point;
				if(lanLine >= N){
					break;
				}
			}

			if(lanLine >= N){
				st = point + 1;
				answer = Math.max(answer,point);
			} else {
				ed = point - 1;
			}
		}

		System.out.println(answer);

	}
}
