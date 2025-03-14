import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		BigInteger[] dp = new BigInteger[N+1];
		dp[0] = BigInteger.ONE;
		for(int i = 1; i < N+1; i++){
			dp[i] = dp[i-1].multiply(BigInteger.valueOf(i));
		}
		BigInteger answer = dp[N].divide(dp[N-K].multiply(dp[K])).mod(BigInteger.valueOf(10007L));
		System.out.println(answer);
	}
}
