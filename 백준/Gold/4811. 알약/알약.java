import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		while(N != 0){
			long result = dp(new int[] {N, 0}, 2 * N, 0);
			System.out.println(result);
			N = Integer.parseInt(br.readLine());
		}
	}

	private static long[][] memo = new long[50][50];
	private static long dp(int[] pill, int totDay, int nowDay){
		if(nowDay == totDay){
			return 1;
		}

		if(memo[pill[0]][pill[1]] != 0){
			return memo[pill[0]][pill[1]];
		}

		if(pill[0] >= 1 && pill[1] >= 1){
			memo[pill[0]][pill[1]] = dp(new int[]{pill[0] - 1, pill[1] + 1}, totDay, nowDay + 1) +
				dp(new int[]{pill[0], pill[1] - 1}, totDay, nowDay + 1);
		} else if (pill[0] >= 1){
			memo[pill[0]][pill[1]] = dp(new int[]{pill[0] - 1, pill[1] + 1}, totDay, nowDay + 1);
		} else {
			memo[pill[0]][pill[1]] = dp(new int[]{pill[0], pill[1] - 1}, totDay, nowDay + 1);
		}

		return memo[pill[0]][pill[1]];
	}
}
