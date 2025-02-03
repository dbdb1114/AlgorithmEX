import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Stack<int[]> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) { // 인덱스를 1부터 사용
			int height = Integer.parseInt(st.nextToken());

			// 현재 탑보다 낮은 탑들은 수신할 수 없으므로 제거
			while (!stack.isEmpty() && stack.peek()[0] < height) {
				stack.pop();
			}

			// 스택이 비어 있으면 신호를 받을 탑이 없음 (0)
			if (stack.isEmpty()) {
				sb.append("0 ");
			} else {
				// 가장 가까운 높은 탑의 인덱스를 출력
				sb.append(stack.peek()[1]).append(" ");
			}

			// 현재 탑을 스택에 저장 (탑의 높이, 인덱스)
			stack.push(new int[]{height, i});
		}

		System.out.println(sb);
	}
}
