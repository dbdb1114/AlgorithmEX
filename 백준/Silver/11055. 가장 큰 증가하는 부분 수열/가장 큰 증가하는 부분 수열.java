import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		for(int i = 0; i < N; i++){
			arr[i][0] = Integer.parseInt(st.nextToken());
			for(int j = 0; j < i; j++){
				if(arr[j][0] < arr[i][0]){
					arr[i][1] = Math.max(arr[j][1] + arr[i][0], arr[i][1]);
				}
			}
			if(arr[i][1] == 0){
				arr[i][1] = arr[i][0];
			}
		}
		for (int[] ar : arr){
			answer = Math.max(answer, ar[1]);
		}
		System.out.println(answer);
	}
}
