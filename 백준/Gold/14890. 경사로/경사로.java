import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
	static int answer = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];

		for(int i = 0; i < N; i++){
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				map[i][j] = Integer.parseInt(st1.nextToken());
			}
		}

		for(int i = 0; i < N; i++) {
			int[] vertical = new int[N];
			for(int j = 0; j < N; j++){
				vertical[j] = map[j][i];
			}

			int[] reverseHorizontal = new int[N];
			int[] reverseVertical = new int[N];
			for (int j = N-1; j >= 0; j--) {
				reverseVertical[j] = vertical[N - 1 - j];
				reverseHorizontal[j] = map[i][N - 1 - j];
			}

			if(check(map[i], L) || check(reverseHorizontal, L)){
				answer++;
			}
			if(check(vertical, L) || check(reverseVertical, L)){
				answer++;
			}
		}
		System.out.println(answer);
	}

	public static boolean check(int[] ar, int L) {
		boolean[] isV = new boolean[ar.length];
		for(int i = 1; i < ar.length; i++){
			if(ar[i] == ar[i-1]) continue;

			boolean isSame = true;

			if(ar[i] < ar[i-1] && ar[i] + 1 == ar[i-1]){
				if(i + L > ar.length){
					return false;
				}
				for (int j = i; j < i + L; j++){
					if(ar[i] != ar[j] || isV[j]){
						isSame = false;
					}
				}
				if(isSame){
					for(int j = i; j < i + L; j++){
						isV[j] = true;
					}
					i = i + L - 1;
				} else {
					return false;
				}
			} else if (ar[i] > ar[i-1] && ar[i] - 1 == ar[i - 1]) {
				if(i - L < 0){
					return false;
				}
				for(int j = i - 1; j >= i - L; j--){
					if(ar[i - 1] != ar[j] || isV[j]) {
						isSame = false;
					}
				}
				if(isSame){
					for(int j = i - 1; j >= i - L; j--){
						isV[j] = true;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		}

		return true;
	}
}
