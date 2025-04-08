import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

	static int N;
	static int S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] left = Arrays.copyOfRange(arr, 0, N/2);
		int[] right = Arrays.copyOfRange(arr, N/2, N);

		Map<Integer,Integer> leftMap = new HashMap<>();
		Map<Integer,Integer> rightMap = new HashMap<>();

		subsetSum(left, 0, 0, leftMap);
		subsetSum(right, 0, 0, rightMap);

		long answer = 0;
		for (int key : leftMap.keySet()){
			answer += (long)leftMap.get(key) * rightMap.getOrDefault(S - key, 0);
		}

		if(S == 0) answer--;

		System.out.println(answer);
	}

	public static void subsetSum(int[] arr, int index, int sum, Map<Integer, Integer> map){
		if(index == arr.length){
			map.put(sum, map.getOrDefault(sum,0) + 1);
			return;
		}

		subsetSum(arr, index+1, sum + arr[index], map);
		subsetSum(arr, index+1, sum, map);
	}

}
