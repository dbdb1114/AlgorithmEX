import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparing(ar->ar[1]));
		PriorityQueue<long[]> pq1 = new PriorityQueue<>(Comparator.comparing(ar->ar[0]));
		for(int i = 0; i < N; i++) {
			long[] ar = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			pq1.add(ar);
		}

		while(!pq1.isEmpty()){
			if(!pq.isEmpty() && pq.peek()[1] <= pq1.peek()[0]){
				pq.poll();
			}
			pq.add(pq1.poll());
		}

		int answer = 0;
		while(!pq.isEmpty()) {
			answer++;
            pq.poll();
		}

		System.out.println(answer);
	}
}
