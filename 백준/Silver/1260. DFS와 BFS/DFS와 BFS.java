import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * [==========================문제 분석============================]
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
 * 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
 * [==예제==]
 * [==입력==]
 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000),
 * 탐색을 시작할 정점의 번호 V가 주어진다.
 * 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
 * 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
 * [==출력==]
 * 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
 * [==========================제한 조건============================]
 *  1. 입력값 범위
 *  2. 시간 제한 N초
 *  3. 메모리 제한 NMB
 * [==========================해결 전략============================]
 * [==========================슈도 코드============================]
 5 4 1
 2 3
 3 4
 4 5
 5 2
*/
public class Main {

	static int N;
	static int M;
	static int start;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static StringBuilder dfsSB = new StringBuilder();
	static StringBuilder bfsSB = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");

		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		start = Integer.parseInt(line[2]);
		list = new ArrayList[N+1];
		visited = new boolean[N+1];

		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			String[] line1 = br.readLine().split(" ");
			if(!list[Integer.parseInt(line1[0])].isEmpty() &&
				list[Integer.parseInt(line1[0])].contains(Integer.parseInt(line1[1]))){
				continue;
			}
			list[Integer.parseInt(line1[0])].add(Integer.parseInt(line1[1]));
			list[Integer.parseInt(line1[1])].add(Integer.parseInt(line1[0]));
		}

		for (int i = 0; i < list.length; i++) {
			list[i].sort(Comparator.naturalOrder());
		}

		DFS(start);

		Arrays.fill(visited,false);
		BFS(start);

		System.out.println(dfsSB.deleteCharAt(dfsSB.length()-1));
		System.out.println(bfsSB.deleteCharAt(bfsSB.length()-1));
	}

	private static void BFS(int number) {
		Queue<Integer> queue = new LinkedList();
		queue.add(number);
		visited[number] = true;

		while(!queue.isEmpty()){
			Integer poll = queue.poll();
			bfsSB.append(poll + " ");
			for(int num : list[poll]){
				if(!visited[num]){
					visited[num] = true;
					queue.add(num);
				}
			}
		}
	}

	private static void DFS(int number) {
		dfsSB.append(number + " ");
		visited[number] = true;
		for (int i = 0; i < list[number].size(); i++) {
			Integer num = list[number].get(i);
			if(!visited[num]) {
				DFS(num);
			}
		}
	}
}
