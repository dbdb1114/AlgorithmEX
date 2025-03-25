import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int days = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a->a[1] * -1));
		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int due = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			days = Math.max(due, days);
			pq.add(new int[] {due, score});
		}

		int[] arr = new int[days];
		int answer = 0;
		while(!pq.isEmpty()){
			int[] cur = pq.poll();
			int point = cur[0] - 1;
			while(point >= 0 && arr[point] != 0) {
				point--;
			}
			if(point >= 0){
				arr[point] = cur[1];
				answer += cur[1];
			}
		}
		System.out.println(answer);
	}
}
