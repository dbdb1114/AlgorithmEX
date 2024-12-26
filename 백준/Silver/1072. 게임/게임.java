import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 *문제
 * 김형택은 지금 몰래 Spider Solitaire(스파이더 카드놀이)를 하고 있다. 형택이는 이 게임을 이길 때도 있었지만, 질 때도 있었다.
 * 누군가의 시선이 느껴진 형택이는 게임을 중단하고 코딩을 하기 시작했다. 의심을 피했다고 생각한 형택이는 다시 게임을 켰다.
 * 그 때 형택이는 잠시 코딩을 하는 사이에 자신의 게임 실력이 눈에 띄게 향상된 것을 알았다.
 *
 * 이제 형택이는 앞으로의 모든 게임에서 지지 않는다.
 * 하지만, 형택이는 게임 기록을 삭제 할 수 없기 때문에, 자신의 못하던 예전 기록이 현재 자신의 엄청난 실력을 증명하지 못한다고 생각했다.
 *
 * 게임 기록은 다음과 같이 생겼다.
 *
 * 게임 횟수 : X
 * 이긴 게임 : Y (Z%)
 * Z는 형택이의 승률이고, 소수점은 버린다. 예를 들어, X=53, Y=47이라면, Z=88이다.
 * X와 Y가 주어졌을 때, 형택이가 게임을 최소 몇 번 더 해야 Z가 변하는지 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 각 줄에 정수 X와 Y가 주어진다.
 *
 * 출력
 * 첫째 줄에 형택이가 게임을 최소 몇 판 더 해야하는지 출력한다. 만약 Z가 절대 변하지 않는다면 -1을 출력한다.
 *
 * 제한
 * 1 ≤ X ≤ 1,000,000,000
 * 0 ≤ Y ≤ X
 *
 * 해결방법
 *
 * */
public class Main {

    static long X;
    static long Y;
    static long Z;

    static PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        X = Long.parseLong(line[0]);
        Y = Long.parseLong(line[1]);
        Z = (Y*100/X);

        binarySearch(0,X*2);
        if(pq.isEmpty()){
            System.out.println(-1);
        } else{
            System.out.println(pq.poll());
        }
    }

    public static void binarySearch(long start, long end) {
        if(end < start){
            return;
        }
        long newGame = end - ((end - start)/2);
        long newX = X + newGame;
        long newY = Y + newGame;
        long newZ = (newY*100/newX);

        if(newZ > Z){
            pq.add(newGame);
            binarySearch(start, newGame - 1);
        } else {
            binarySearch(newGame + 1, end);
        }
    }
}
