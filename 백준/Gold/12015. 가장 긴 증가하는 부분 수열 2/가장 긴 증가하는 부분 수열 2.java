import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		lis[0] = arr[0];
		int lisPointer = 0;
		for(int i = 1; i < N; i++){
			if(lis[lisPointer] < arr[i]){
				lis[++lisPointer] = arr[i];
				continue;
			}

			int low = 0;
			int high = lisPointer;
			while(low < high){
				int mid = low + (high - low)/2;
				if(lis[mid] < arr[i]){
					low = mid + 1;
				} else {
					high = mid;
				}
			}
			lis[high] = arr[i];
		}
		System.out.println(lisPointer + 1);

	}
}
