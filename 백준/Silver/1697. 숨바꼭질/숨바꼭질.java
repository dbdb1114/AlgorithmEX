import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**



 * */
/**
 * [==========================문제 분석============================]
 *  수빈이는 동생과 숨바꼭질을 하고 있다.
 *  현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
 *  수빈이는 걷거나 순간이동을 할 수 있다.
 *  만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
 *  순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
 * [==예제==]
 * 수빈이가 5-10-9-18-17 순으로 가면 4초만에 동생을 찾을 수 있다.
 * [==입력==]
 * 5 17
 * [==출력==]
 * 4
 * [==========================제한 조건============================]
 *  1. 입력값 범위  점 N(0 ≤ N ≤ 100,000)에 있고  동생은 점 K(0 ≤ K ≤ 100,000)
 *  2. 시간 제한 N초 2초
 *  3. 메모리 제한 128MB
 * [==========================해결 전략============================]
 * 내 생각에는 목적지에 도착하는데 순간이동을 가장 잘 쓰면 좋지 않을까 싶다.
 * 그래서 순간이동을 위주로 이동한다고 했을 때
 * K /= 2 를 누적하여 중간 지점들을 탐색하고, 그 지점들까지 가는 경우의 수를 모두 파악하면 되지 않을까?
 * 하지만 만약에 도착 지점이 홀수라면, 순간이동으로는 절대 갈 수 없다.
 * 따라서 도착지점이 홀수일 경우에는 앞 뒤 짝수를 도착 지점으로 고르고, 둘 중하나로 도착한다는 가정하에 하면 될 것 같다.
 *
 * 5 17
 * 홀수 일땐 그 다음 칸 기준으로 계산
 * 5 10 18
 *
 *
 * BFS
 * 각 지점별로 한 칸 혹은 두 칸 갈 수 있음.
 * [==========================슈도 코드============================]
*/
public class Main {

    static boolean[] visit;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        visit = new boolean[200001];

        int answer = BFS(N,K);

        System.out.println(answer);
    }

    public static int BFS(int st, int ed){
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {st,0});

         while(!queue.isEmpty() && queue.peek()[0] != ed){
            int[] poll = queue.poll();

            if(poll[0] * 2 < ed * 2 && !visit[poll[0] * 2]){
                visit[poll[0]*2] = true;
                queue.add(new int[] {poll[0] * 2, poll[1] + 1});
            }

            if(poll[0]+1 < ed * 2 && !visit[poll[0] + 1]){
                visit[poll[0]+1] = true;
                queue.add(new int[]{poll[0] + 1, poll[1] + 1});
            }
            if(poll[0] > 0 && !visit[poll[0] - 1]){
                visit[poll[0]-1] = true;
                queue.add(new int[] {poll[0] - 1, poll[1] + 1});
            }
        }

        return queue.poll()[1];
    }

}
