import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
/**
 인하은행에는 ATM이 1대밖에 없다. 지금 이 ATM앞에 N명의 사람들이 줄을 서있다.
 사람은 1번부터 N번까지 번호가 매겨져 있으며, i번 사람이 돈을 인출하는데 걸리는 시간은 Pi분이다.

 첫째 줄에 사람의 수 N(1 ≤ N ≤ 1,000)이 주어진다.
 둘째 줄에는 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어진다. (1 ≤ Pi ≤ 1,000)

 첫째 줄에 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 출력한다.

 정렬후 누적합
 *
*/

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer tk = new StringTokenizer(bf.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(tk.nextToken()));
        }

        Collections.sort(list);

        for (int i = 1; i < list.size(); i++) {
            Integer prev = list.get(i-1);
            list.set(i, list.get(i) + prev);
        }

        int answer = list.stream().sorted().reduce((a,b)->a+b).get();

        System.out.println(answer);
    }
}
