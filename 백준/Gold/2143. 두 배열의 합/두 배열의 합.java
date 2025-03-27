import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[] A = new int[Integer.parseInt(br.readLine())];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for (int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(st1.nextToken());
		}

		int[] B = new int[Integer.parseInt(br.readLine())];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < B.length; i++) {
			B[i] = Integer.parseInt(st2.nextToken());
		}

		HashMap<Integer, Integer> aMap = new HashMap<>();
		long answer = 0;
		for (int i = 0; i < A.length; i++) {
			int sum = 0;
			for (int j = i; j < A.length; j++) {
				sum += A[j];
				if(aMap.containsKey(sum)){
					aMap.put(sum, aMap.get(sum) + 1);
				} else {
					aMap.put(sum, 1);
				}
			}
		}

		for (int i = 0; i < B.length; i++) {
			int sum = 0;
			for (int j = i; j < B.length; j++) {
				sum += B[j];
				if(aMap.containsKey(T - sum)){
					answer += aMap.get(T-sum);
				}
			}
		}

		System.out.println(answer);
	}
}
