import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * [==========================문제 분석============================]
 * 매일 아침, 세준이는 학교에 가기 위해서 차를 타고 D킬로미터 길이의 고속도로를 지난다.
 * 이 고속도로는 심각하게 커브가 많아서 정말 운전하기도 힘들다.
 *
 * 어느 날, 세준이는 이 고속도로에 지름길이 존재한다는 것을 알게 되었다. 모든 지름길은 일방통행이고, 고속도로를 역주행할 수는 없다.
 *
 * 세준이가 운전해야 하는 거리의 최솟값을 출력하시오.
 * [==예제==]
5 150
0 50 10
0 50 20
50 100 10
100 151 10
110 140 90
 *
 * 70
 *
 * 2 100
 * 10 60 40
 * 50 90 20
 *
 * 80
 *
 * 8 900
 * 0 10 9
 * 20 60 45
 * 80 190 100
 * 50 70 15
 * 160 180 14
 * 140 160 14
 * 420 901 5
 * 450 900 0
 *
 * 432
 * [==입력==]
 * 첫째 줄에 지름길의 개수 N과 고속도로의 길이 D가 주어진다. N은 12 이하인 양의 정수이고,
 * D는 10,000보다 작거나 같은 자연수이다.
 *
 * 다음 N개의 줄에 지름길의 시작 위치, 도착 위치, 지름길의 길이가 주어진다.
 * 모든 위치와 길이는 10,000보다 작거나 같은 음이 아닌 정수이다. 지름길의 시작 위치는 도착 위치보다 작다.
 *
 * [==출력==]
 * [==========================제한 조건============================]
 *  1. 입력값 범위
 *  2. 시간 제한 2초
 *  3. 메모리 제한 NMB
 * [==========================해결 전략============================]
 * 도착지 - 출발지 < 거리 여야함.
 *
 * 이득 길이 순으로 정렬해서, 이득인 곳들을 모으는 방향으로 가면 어떨까
 * ex)
 * 0 50 10 => 40
 * 0 50 20 => 30
 * 50 100 10 => 40
 * 100 151 10 => 41
 * 110 140 90 => -60
 *
 * => 0 50 10
 * => 50 100 10
 * => 100 151 10
 * =>
 *
 * 첫번째 정렬 기준은 이득거리
 * 두번째 정렬 기준은 이동거리
 * 세번째 정렬 기준은 시작지점
 * 
 * 0 ~ D 까지 
 * 
 * [==========================슈도 코드============================]
*/
public class Main{
	static int N;
	static int D;
	static List<Node> nodes = new ArrayList<>();
	static int[] answerArr;

	static class Node {
		int from;
		int to;
		int dist;

		public Node(int from, int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");

		N = Integer.parseInt(line[0]);
		D = Integer.parseInt(line[1]);

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			Node node = new Node(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
			if(node.to > D ||  node.dist >= node.to - node.from) {
				continue;
			}
			nodes.add(node);
		}

		nodes.sort(Comparator.comparingInt(node -> node.from));
		answerArr = new int[nodes.size()];
		Arrays.fill(answerArr, D);

		for (int i = 0; i < nodes.size(); i++) {
			dfs(i,i,nodes.get(i).to - nodes.get(i).from,nodes.get(i).dist);
		}

		int answer = D;
		for (int i = 0; i < answerArr.length; i++) {
			answer = Math.min(answerArr[i],answer);
		}

		System.out.println(answer);
	}

	static void dfs(int start, int now, int originDist, int shortDist){
		answerArr[start] = Math.min(answerArr[start], D - originDist + shortDist); // 50 10, 50 10,

		for (int i = now+1; i < nodes.size(); i++) {
			Node node = nodes.get(i);
			if(nodes.get(now).to <= node.from){
				dfs(start, i, originDist + node.to - node.from, shortDist + node.dist);
			}
		}
	}
}
