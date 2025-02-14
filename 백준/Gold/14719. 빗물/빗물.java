import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] handw = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int H = handw[0];
		int W = handw[1];

		int[][] map = new int[H][W];

		int[] walls = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		for(int i = 0; i < walls.length; i++){
			for(int j = H - 1; j > H - walls[i] - 1; j--){
				map[j][i] = 1;
			}
		}
		int rain = 0;

		for(int i = 0; i < H; i++){
			int st = 0;
			int ed = st + 1;
			while(ed < W){
				while(st < W){
					if(map[i][st] == 1){
						break;
					}
					st++;
				}

				// ed 탐색
				ed = st+1;
				while(ed < W){
					if(map[i][ed] == 1){
						break;
					}
					ed++;
				}

				// 벽없이 끝남
				if(ed == W) {
					break;
				}

				rain += ed - st - 1;

				st = ed;
				ed = st+1;
			}
			// st 탐색
		}
		System.out.println(rain);
	}
}
