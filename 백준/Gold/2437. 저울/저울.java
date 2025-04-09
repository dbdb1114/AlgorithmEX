import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(a->a));

		long sum = 0;
		for(int n : arr){
			pq.add(n);
			sum += n;
		}

		long answer = 0;
		long nowSum = pq.poll();
		if (nowSum > 1) {
			System.out.println(1);
			return;
		}
		for(long i = 1; i < sum; i++){
			if(i <= nowSum){
				continue;
			}
			if(pq.peek() <= nowSum || i == pq.peek()){
				nowSum += pq.poll();
			} else {
				answer = i;
				break;
			}
		}

		if(answer == 0){
			System.out.println(sum + 1);
		} else {
			System.out.println(answer);
		}

	}
}
