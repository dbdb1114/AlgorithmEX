import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		br.readLine();
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int st = 0;
		int ed = arr.length - 1;
		int answer = Integer.MAX_VALUE;
		while(st < ed){
			int nowAbs = Math.abs(arr[st] + arr[ed]);
			int answerAbs = Math.abs(answer);
			if(nowAbs < answerAbs){
				answer = arr[st] + arr[ed];
			}
			if(arr[st] + arr[ed] <= 0){
				st++;
			} else if(arr[st] + arr[ed] > 0){
				ed--;
			}
		}
		System.out.println(answer);
	}
}
