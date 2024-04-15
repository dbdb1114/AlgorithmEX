import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * [==========================문제 분석============================]
 *  어떤 나라에 N개의 도시가 있다. 이 도시들은 일직선 도로 위에 있다.
 *  편의상 일직선을 수평 방향으로 두자. 제일 왼쪽의 도시에서 제일 오른쪽의 도시로 자동차를 이용하여 이동하려고 한다.
 *  인접한 두 도시 사이의 도로들은 서로 길이가 다를 수 있다. 도로 길이의 단위는 km를 사용한다.
 *
 *  처음 출발할 때 자동차에는 기름이 없어서 주유소에서 기름을 넣고 출발하여야 한다.
 *  기름통의 크기는 무제한이어서 얼마든지 많은 기름을 넣을 수 있다.
 *  도로를 이용하여 이동할 때 1km마다 1리터의 기름을 사용한다.
 *  각 도시에는 단 하나의 주유소가 있으며, 도시 마다 주유소의 리터당 가격은 다를 수 있다. 가격의 단위는 원을 사용한다.
 *
 *  예를 들어, 이 나라에 다음 그림처럼 4개의 도시가 있다고 하자.
 *  원 안에 있는 숫자는 그 도시에 있는 주유소의 리터당 가격이다. 도로 위에 있는 숫자는 도로의 길이를 표시한 것이다.
 *
 *  각 도시에 있는 주유소의 기름 가격과, 각 도시를 연결하는 도로의 길이를 입력으로 받아
 *  제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는 최소의 비용을 계산하는 프로그램을 작성하시오.
 *  [==예제==]
 * [==입력==]
 * 첫 번째 줄에는 도시의 개수를 나타내는 정수 N
 * 다음 줄에는 인접한 두 도시를 연결하는 도로의 길이가 제일 왼쪽 도로부터 N-1개의 자연수
 * 다음 줄에는 주유소의 리터당 가격이 제일 왼쪽 도시부터 순서대로 N개의 자연수로 주어진다.
 * [==출력==]
 * [==========================제한 조건============================]
 *  1. 입력값 범위
 *  2 ≤ N ≤ 1,000,
 *  2. 시간 제한 2 초
 *  3. 메모리 제한 512MB
 * [==========================해결 전략============================]
 * 만약 Res(N) 이 결과라고 할 때,
 * Res(N)을 어떻게 표현할 수 있을까?
 *
 * Dis(N) = Dis(N-1)에서 Dis(N)까지의 거리 *
 *
 * 예제를 기준으로
 * Res(2) = Dis(1)에서 Dis(2)까지의 거리 * 리터당 기름값
 * Res(3) = Res(2) + Dis(2)에서 Dis(3)까지의 거리 * 리터당 기름값
 * ...
 * Res(N) = Res(N-1) + DIS(N-1)에서 Dis(N)까지의 거리 * 리터당 기름값
 *
 * 각 위치까지 가는동안 필요한 기름을 살때 최소 기름값을 구해야한다.
 * 예를 들어, 1->2는선택의 여지가 없지만, 2 -> 3은 리터당 5월과 리터당 2원이라는 선택지가 있다.
 * 그리고 4->1의 경우 거리 * 이전 최소 기름값을 곱해주면 기름값이 나온다.
 *
 * 즉, 각 노드를 순회하면서 그 지점까지의 가장 저렴한 기름값을 계속해서 최신화 해주면 된다 .
 * 그럼 Res(2) = Node1.dis * Node1.price;
 *    Res(3) = Math.min(minOil, Node2.price) * Node2.dis;
 *
 *
 * [==========================슈도 코드============================]
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] dist = new int[N-1];
        int[] price = new int[N];
        int answer = 0;

        dist[0] = 0;

        String[] line = bf.readLine().split(" ");
        for (int j = 0; j < N-1; j++) {
            dist[j] = Integer.parseInt(line[j]);
            
        }
        
        line = bf.readLine().split(" ");
        for (int j = 0; j < N; j++) {
            price[j] = Integer.parseInt(line[j]);
        }

        int minOil = price[0];
        
        for (int i = 0; i < dist.length; i++) {
            minOil = Math.min(minOil,price[i]);
            answer += minOil * dist[i];
        }

        System.out.println(answer);
    }

}
