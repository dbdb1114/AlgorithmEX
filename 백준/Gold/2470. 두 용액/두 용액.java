import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * [==========================문제 분석============================]
 * KOI 부설 과학연구소에서는 많은 종류의 산성 용액과 알칼리성 용액을 보유하고 있다.
 * 각 용액에는 그 용액의 특성을 나타내는 하나의 정수가 주어져있다.
 * 산성 용액의 특성값은 1부터 1,000,000,000까지의 양의 정수로 나타내고,
 * 알칼리성 용액의 특성값은 -1부터 -1,000,000,000까지의 음의 정수로 나타낸다.
 *
 * 같은 양의 두 용액을 혼합한 용액의 특성값은 혼합에 사용된 각 용액의 특성값의 합으로 정의한다.
 * 이 연구소에서는 같은 양의 두 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들려고 한다.
 *
 * 예를 들어, 주어진 용액들의 특성값이 [-2, 4, -99, -1, 98]인 경우에는
 * 특성값이 -99인 용액과 특성값이 98인 용액을 혼합하면 특성값이 -1인 용액을 만들 수 있고,
 * 이 용액이 특성값이 0에 가장 가까운 용액이다. 참고로,
 * 두 종류의 알칼리성 용액만으로나 혹은 두 종류의 산성 용액만으로 특성값이 0에 가장 가까운 혼합 용액을 만드는 경우도 존재할 수 있다.
 *
 * 산성 용액과 알칼리성 용액의 특성값이 주어졌을 때, 이 중 두 개의 서로 다른 용액을 혼합하여
 * 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액을 찾는 프로그램을 작성하시오.
 * [==예제==]
 * [==입력==]
 * 첫째 줄에는 전체 용액의 수 N이 입력된다. N은 2 이상 100,000 이하이다.
 * 둘째 줄에는 용액의 특성값을 나타내는 N개의 정수가 빈칸을 사이에 두고 주어진다.
 * 이 수들은 모두 -1,000,000,000 이상 1,000,000,000 이하이다.
 * N개의 용액들의 특성값은 모두 다르고, 산성 용액만으로나 알칼리성 용액만으로 입력이 주어지는 경우도 있을 수 있다.
 * [==출력==]
 * 첫째 줄에 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액의 특성값을 출력한다.
 * 출력해야 하는 두 용액은 특성값의 오름차순으로 출력한다. 특성값이 0에 가장 가까운 용액을 만들어내는 경우가 두 개 이상일 경우에는 그 중 아무것이나 하나를 출력한다.
 * [==========================제한 조건============================]
 *  1. 입력값 범위 N은 2 이상 100,000 이하
 *  2. 시간 제한 1초
 *  3. 메모리 제한 128MB
 * [==========================해결 전략============================]
 * [==========================슈도 코드============================]
*/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Long> list = new ArrayList<>();
		String[] line = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			list.add(Long.parseLong(line[i]));
		}

		list.sort(Comparator.comparing(num -> Math.abs(num)));
		long answerSum = Long.MAX_VALUE;
		String answer="";

		for (int i = 1; i < N; i++) {
			long abs = Math.abs(list.get(i - 1) + list.get(i));
			if(abs < answerSum){
				answerSum = abs;
				if(list.get(i-1) > list.get(i)){
					answer = list.get(i) + " " + list.get(i-1);
				} else {
					answer = list.get(i-1) + " " + list.get(i);
				}
			}
		}
		System.out.println(answer);
	}
}
