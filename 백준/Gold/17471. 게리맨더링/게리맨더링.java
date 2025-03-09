import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {

	static List<Integer> location1 = new ArrayList<>();

	static int N = 0;
	static List<Integer>[] adjacencyList;
	static int[] population;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		population = new int[N + 1];
		StringTokenizer pop = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(pop.nextToken());
		}

		adjacencyList = new List[N+1];
		for (int i = 1; i <= N; i++) {
			adjacencyList[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				int node = Integer.parseInt(st.nextToken());
				adjacencyList[i].add(node);
				adjacencyList[node].add(i);
			}
		}

		for (int i = 1; i <= N/2; i++) {
			combination(0, 0, i);
		}

		if(answer == Integer.MAX_VALUE){
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	static void combination(int now, int cnt, int goal){
		if(cnt == goal){
			answerCheck();
			return;
		}

		for (int i = now; i < N; i++) {
			location1.add(i+1);
			combination(i+1, cnt+1, goal);
			location1.remove(location1.size()-1);
		}
	}

	static void answerCheck() {
		ArrayList<Integer> location2 = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if(location1.contains(i)) continue;
			location2.add(i);
		}

		int location1Population = BFS(location1);
		int location2Population = BFS(location2);

		if(location1Population != 0 && location2Population != 0){
			answer = Math.min(answer, Math.abs(location1Population - location2Population));
		}
	}

	static int BFS(List<Integer> location){
		HashMap<Integer, Boolean> map = new HashMap<>();
		int thisPopulation = 0;
		for (int i = 0; i < location.size(); i++) {
			int node = location.get(i);
			map.put(node, false);
		}

		Queue<Integer> queue = new LinkedList<>();
		Integer startNode = location.get(0);
		queue.add(startNode);
		map.put(startNode,true);
		thisPopulation += population[startNode];

		while(!queue.isEmpty()){
			int now = queue.poll();
			for(int node : adjacencyList[now]){
				if(!map.containsKey(node)) continue;
				if(map.get(node)) continue;
				if(map.containsKey(node)){
					thisPopulation += population[node];
					map.put(node, true);
					queue.add(node);
				}
			}
		}

		boolean result = map.keySet().stream()
			.map(map::get)
			.filter(a -> !a)
			.count() == 0;
		if(result){
			return thisPopulation;
		} else {
			return 0;
		}
	}
}
