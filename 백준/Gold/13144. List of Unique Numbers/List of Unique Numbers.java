import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nArr = new int[N];
        String[] input = br.readLine().split(" ");
        
        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(input[i]);
        }

        long answer = 0; // 부분 수열의 개수가 많을 수 있으므로 long 사용
        Set<Integer> set = new HashSet<>();
        int st = 0;

        for (int ed = 0; ed < N; ed++) {
            while (set.contains(nArr[ed])) {
                set.remove(nArr[st]); // 중복 제거
                st++; // 시작 위치 이동
            }
            set.add(nArr[ed]);
            answer += (ed - st + 1); // 현재 구간의 모든 부분 수열 개수 추가
        }

        System.out.println(answer);
    }
}
