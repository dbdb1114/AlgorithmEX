import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0});
		}

		// 컴퓨터 배정 완료
		list.sort(Comparator.comparingInt(a -> a[0]));

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // 종료시간 순으로 정렬
		PriorityQueue<int[]> pq2 = new PriorityQueue<>(Comparator.comparing(a -> a[1]));

		int comNum = 1;
		for (int i = 0; i < list.size(); i++) {
			int[] user = list.get(i);

			while(!pq.isEmpty() && pq.peek()[0] <= user[0]){
				pq2.add(pq.poll());
			}

			if(pq2.isEmpty()){
				user[0] = user[1];
				user[1] = comNum++;
				user[2] = 1;
				pq.add(user);
				continue;
			}

			int[] cur = pq2.poll();
			cur[0] = user[1];
			cur[2] += 1;
			pq.add(cur);
		}

		while(!pq2.isEmpty()){
			pq.add(pq2.poll());
		}


		StringBuilder sb = new StringBuilder();
		sb.append(pq.size()).append("\n");
		pq.stream().sorted(Comparator.comparing(a -> a[1]))
			.forEach(a->sb.append(a[2]).append(" "));
		sb.deleteCharAt(sb.length()-1);

		System.out.print(sb);
	}
}
