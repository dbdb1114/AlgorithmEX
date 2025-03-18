import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[][] triangle = new long[N][N];

		for (int i = 0; i < N; i++) {
			triangle[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				if(j == 0){
					triangle[i][j] += triangle[i-1][j];
					continue;
				}

				if(j == triangle[i].length - 1){
					triangle[i][j] += triangle[i-1][j-1];
					continue;
				}
				
				triangle[i][j] += Math.max(triangle[i-1][j-1],triangle[i-1][j]);
			}
		}
		long answer = 0;
		for (int i = 0; i < triangle[N-1].length; i++) {
			answer = Math.max(answer, triangle[N-1][i]);
		}

		System.out.println(answer);
	}
}
