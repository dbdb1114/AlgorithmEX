import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int target = Integer.parseInt(br.readLine());

			if(target == 0){
				if(!pq.isEmpty()){
					System.out.println(pq.poll());
				} else {
					System.out.println(0);
				}
			} else {
				pq.add(target);
			}

		}
	}
}
