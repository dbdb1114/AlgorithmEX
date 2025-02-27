import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] NandC = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int N = NandC[0];
		int C = NandC[1];

		int[] arr = new int[N];

		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int max = (arr[N-1] - arr[0])/(C-1) + 1;
		int min = 0;
		int mid = 0;

		// min max mid
		//  0   8   4
		int answer = 0;
		while(min <= max){
			mid = max - (max - min)/2;
			int dist = mid;
			int prevMachine = arr[0];
			int count = 1;
			for(int i = 1; i < arr.length; i++){
				if(dist <= arr[i] - prevMachine){
					prevMachine = arr[i];
					count++;
				}
				if(count == C){
					break;
				}
			}

			if(count == C){
				answer = mid;
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}

		System.out.println(answer);
	}
}
