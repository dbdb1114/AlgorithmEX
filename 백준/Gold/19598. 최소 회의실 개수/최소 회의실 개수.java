import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		PriorityQueue<int[]> confferencePQ = new PriorityQueue<>(Comparator.comparing(ar->ar[0]));

		for(int i = 0; i < N; i++){
			confferencePQ.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
		}

		PriorityQueue<int[]> confferenceRoomPQ = new PriorityQueue<>(Comparator.comparing(ar->ar[1]));

		while(!confferencePQ.isEmpty()){
			int[] cur = confferencePQ.poll();
			if(!confferenceRoomPQ.isEmpty() && confferenceRoomPQ.peek()[1] <= cur[0]){
				confferenceRoomPQ.poll();
				confferenceRoomPQ.add(cur);
				continue;
			}
			confferenceRoomPQ.add(cur);
			answer++;
		}

		System.out.println(answer);

	}
}
