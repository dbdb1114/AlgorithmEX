import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nandm = (br.readLine()).split(" ");

		int N = Integer.parseInt(nandm[0]);
		int M = Integer.parseInt(nandm[1]);

		int[][] square = new int[N][M];

		for(int i = 0; i < N; i++){
			String[] line = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				square[i][j] = Integer.parseInt(line[j]);
			}
		}

		int line = Math.min(N,M);
		for(int i = line; i > 1; i--){
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					int t1 = k + i - 1;
					int t2 = j + i - 1;


					if(t1 >= M || t2 >= N){
						break;
					}
					
					// t,k / t1,k / t,t2 / t1,t2
					if(square[j][k] == square[j][t1] &&
						square[j][k] == square[t2][k] &&
						square[j][k] == square[t2][t1] ){
						System.out.println(i * i);
						return;
					}
				}
			}
		}

		System.out.println(1);
	}
}
