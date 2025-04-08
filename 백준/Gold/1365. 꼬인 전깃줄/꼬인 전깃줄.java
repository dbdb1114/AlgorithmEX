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
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] lis = new int[N];
		int len = 0;
		for(int i = 0; i < N; i++){
			int index = Arrays.binarySearch(lis, 0, len, arr[i]);
			if(index < 0) index = -index - 1;
			lis[index] = arr[i];
			if(index == len) len++;
		}

		System.out.println(N - len);
	}
}
