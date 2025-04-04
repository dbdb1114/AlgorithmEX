import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[][] dustMap = new int[R][C];
		List<int[]> airCleaner = new ArrayList<>();
		for(int i = 0; i < R; i++){
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++){
				dustMap[i][j] = Integer.parseInt(st1.nextToken());
				if(dustMap[i][j] == -1){
					airCleaner.add(new int[]{i,j});
				}
			}
		}
		for(int i = 0; i < T; i++) {
			diffusion(dustMap);
			cleanAir(dustMap, airCleaner);
		}

		int answer = 0;
		for(int i = 0; i < dustMap.length; i++){
			for(int j = 0; j < dustMap[i].length; j++){
				if(dustMap[i][j] != -1){
					answer += dustMap[i][j];
				}
			}
		}
		System.out.println(answer);
	}

	public static void diffusion(int[][] dustMap){
		int dx[] = {-1, 0, 1, 0};
		int dy[] = {0, 1, 0, -1};

		int[][] prevMap = new int[dustMap.length][dustMap[0].length];
		for (int i = 0; i < dustMap.length; i++) {
			for (int j = 0; j < dustMap[i].length; j++) {
				prevMap[i][j] = dustMap[i][j];
			}
		}

		for(int i = 0; i < dustMap.length; i++){
			for(int j = 0; j < dustMap[i].length; j++){
				if(prevMap[i][j] > 0){
					int difussionDust = prevMap[i][j] / 5;
					for(int k = 0; k < 4; k++){
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(nx >= 0 && nx < dustMap.length &&
							ny >= 0 && ny < dustMap[i].length &&
							dustMap[nx][ny] != -1){
							dustMap[nx][ny] += difussionDust;
							dustMap[i][j] -= difussionDust;
						}
					}
				}
			}
		}

	}

	public static void cleanAir(int[][] dustMap, List<int[]> airCleaner){
		for(int i = 0; i < airCleaner.size(); i++){
			int x = airCleaner.get(i)[0];
			int y = airCleaner.get(i)[1];
			int[] dx;
			if(i == 0){
				dx = new int[] {0, -1, 0, 1};
			} else {
				dx = new int[] {0, 1, 0, -1};
			}

			int[] dy = new int[] {1, 0, -1, 0};;
			int prevDust = 0;
			int d = 0;

			x += dx[d];
			y += dy[d];
			
			while(x != airCleaner.get(i)[0] || y != airCleaner.get(i)[1]){
				if((x < 0 || x >= dustMap.length || y < 0 || y >= dustMap[0].length) ||
					(i == 0 && x > airCleaner.get(i)[0]) || 
					(i == 1 && x < airCleaner.get(i)[0])
				){
					x -= dx[d];
					y -= dy[d];
					d = ++d % 4;
					x += dx[d];
					y += dy[d];
					continue;
				}

				int temp = dustMap[x][y];
				dustMap[x][y] = prevDust;
				prevDust = temp;
				x += dx[d];
				y += dy[d];
			}

		}
	}

}
