import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws Exception {
		int[][] bottomAndTop = new int[6][2];
		bottomAndTop[0] = new int[] {0,5};
		bottomAndTop[1] = new int[] {1,3};
		bottomAndTop[2] = new int[] {2,4};
		bottomAndTop[3] = new int[] {3,1};
		bottomAndTop[4] = new int[] {4,2};
		bottomAndTop[5] = new int[] {5,0};

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dices = new int[N][6];

		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 6; j++){
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		for(int[] bat : bottomAndTop){
			int prevTop = dices[0][bat[1]];
			int sum = findOutMaxNum(dices[0], bat[0], bat[1]);
			for(int i = 1; i < dices.length; i++){
				int nowBottom = nextBottom(dices[i], prevTop);
				int nowTop = bottomAndTop[nowBottom][1];
				int max = findOutMaxNum(dices[i],nowBottom,nowTop);
				prevTop = dices[i][nowTop];
				sum += max;
			}
			answer = Math.max(sum, answer);
		}

		System.out.println(answer);
	}

	public static int nextBottom(int[] ar, int prevTop){
		for (int i = 0; i < ar.length; i++) {
			if(ar[i] == prevTop){
				return i;
			}
		}
		return 0;
	}

	public static int findOutMaxNum(int[] ar, int exclude1, int exclude2){
		int max = 0;
		for (int i = 0; i < ar.length; i++) {
			if(i == exclude1 || i == exclude2) continue;
			max = Math.max(ar[i], max);
		}
		return max;
	}
}

