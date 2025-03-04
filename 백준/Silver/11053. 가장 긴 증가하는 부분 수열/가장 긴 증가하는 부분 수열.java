import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] ar = new int[N][2];

		for(int i = 0; i < N; i++){
			ar[i][0] = Integer.parseInt(st.nextToken());
			ar[i][1] = 0;
		}

		ar[0][1] = 1;
		int answer = 1;
		for(int i = 1; i < N; i++) {
			for(int j = i - 1; j >= 0; j--) {
				if(ar[j][0] < ar[i][0] && ar[i][1] <= ar[j][1]){
					ar[i][1] = ar[j][1] + 1;
				}

			}
			if(ar[i][1] == 0) {
				ar[i][1] = 1;
			}
			answer = Math.max(answer, ar[i][1]);
		}
		System.out.println(answer);
	}
}
