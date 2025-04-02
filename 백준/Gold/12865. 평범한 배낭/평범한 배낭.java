import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static int N;
	static int K;
	static int[][] things;
	static int answer = 0;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		things = new int[N][2];
		dp = new int[N+1][K+1];
        for(int i = 0; i < N; i++){
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st1.nextToken());
			int V = Integer.parseInt(st1.nextToken());
			things[i][0] = W;
			things[i][1] = V;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				dp[i][j] = -1;
			}
		}
		tracking(0,0,0);

		System.out.println(answer);
	}

	public static void tracking(int weight, int value, int now){
		if(weight > K) {
			return;
		}

		if(dp[now][weight] >= value) return;
		dp[now][weight] = value;
		
		answer = Math.max(value, answer);

		for(int i = now; i < N; i++){
			tracking(weight + things[i][0], value + things[i][1], i + 1);
		}
	}
}
