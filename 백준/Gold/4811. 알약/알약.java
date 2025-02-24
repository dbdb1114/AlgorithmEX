import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static long[][] memo = new long[31][31];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp(new int[] {30, 0}, 60, 0);

		StringBuilder sb = new StringBuilder();
		while(N != 0){
			sb.append(memo[N][0]).append("\n");
			N = Integer.parseInt(br.readLine());
		}
		System.out.println(sb);
	}

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
