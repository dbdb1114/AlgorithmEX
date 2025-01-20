import java.awt.geom.Area;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * [==========================문제 분석============================]
 * 세준이는 위험한 지역에서 탈출하는 게임을 하고 있다. 이 게임에는 세준이가 들어갈 수 없는 죽음의 구역이 있고,
 * 들어가서 한 번 움직일 때 마다 생명이 1씩 소모되는 위험한 구역이 있다.
 * 그리고, 자유롭게 생명의 위협없이 움직일 수 있는 안전한 구역이 있다.
 * (안전한 구역은 죽음의 구역과 위험한 구역을 제외한 나머지 이다.)
 * - 안전구역, 죽음구역, 위험구역
 *
 * 세준이는 (0, 0)에서 출발해서 (500, 500)으로 가야 한다.
 * 세준이는 위, 아래, 오른쪽, 왼쪽으로만 이동할 수 있다.
 * 현재 세준이는 (0, 0)에 있다. 그리고, 게임 판을 벗어날 수는 없다.
 *
 * 세준이가 (0, 0)에서 (500, 500)으로 갈 때 잃는 생명의 최솟값을 구하는 프로그램을 작성하시오.
 * [==예제==]
 * [==입력==]
 * 첫째 줄에 위험한 구역의 수 N이 주어진다. 다음 줄부터 N개의 줄에는 X1 Y1 X2 Y2와 같은 형식으로 위험한 구역의 정보가 주어진다.
 * (X1, Y1)은 위험한 구역의 한 모서리이고, (X2, Y2)는 위험한 구역의 반대 모서리이다.
 * 그 다음 줄에는 죽음의 구역의 수 M이 주어진다.
 *
 * 다음 줄부터 M개의 줄에는 죽음의 구역의 정보가 위험한 구역의 정보와 같이 주어진다.
 * 주어지는 구역은 모두 겹칠 수 있으며, 서로 다른 구역이 겹칠 때는,
 * 더 심한 구역이 해당된다. 예를 들어, 죽음+위험 = 죽음, 위험+안전 = 위험,
 * 위험+위험 = 위험, 죽음+안전 = 죽음이다. 위험한 구역이 아무리 겹쳐도 생명은 1씩 감소된다.
 * 생명의 감소는 구역에 들어갈 때만, 영향을 미친다. 예를
 *
 * 들어, (500, 500)이 위험한 구역일 때는, (500, 500)에 들어갈 때, 생명이 1 감소되지만,
 * (0, 0)이 위험한 구역이더라도 생명은 감소되지 않는다.
 * 마찬가지로, (0, 0)이 죽음의 구역이더라도 세준이는 이미 그 곳에 있으므로 세준이에게 영향을 미치지 않는다.
 * N과 M은 50보다 작거나 같은 자연수이다.
 *
 * [==출력==]
 * [==========================제한 조건============================]
 *  1. 입력값 범위
 *  2. 시간 제한 2초
 *  3. 메모리 제한 128MB
 * [==========================해결 전략============================]
 * 위험구역과 죽음구역 등을 계산하는 게 첫 번째 포인트
 * 위험구역과 죽음구역이 겹치면 => 죽음구역이 된다.
 * 위험구역이 나오고, 죽음구역이 나온다.
 * 죽음 지역은 그냥 방문으로 처리
 *
 * x1이나 y1이
 *
 * daikjstra를  통해 최솟값을 구하는게 두 번째 포인트
 * [==========================슈도 코드============================]
 */
public class Main {

	static List<Area> dangerousList = new ArrayList<>();
	static List<Area> deathList = new ArrayList<>();
	static int[][] healthArray = new int[501][501];
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			List<Integer> dangerous = Arrays.stream(br.readLine().split(" "))
				.map(Integer::parseInt).collect(Collectors.toList());
			Area area = new Area(dangerous.get(0), dangerous.get(1), dangerous.get(2), dangerous.get(3));
			dangerousList.add(i,area);
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			List<Integer> death = Arrays.stream(br.readLine().split(" "))
				.map(Integer::parseInt).collect(Collectors.toList());
			Area area = new Area(death.get(0), death.get(1), death.get(2), death.get(3));
			deathList.add(i,area);
		}

		for (int i = 0; i < 501; i++) {
			Arrays.fill(healthArray[i], Integer.MAX_VALUE);
		}

		dikstra(0,0);

		if(healthArray[500][500] == Integer.MAX_VALUE){
			System.out.println(-1);
		} else {
			System.out.println(healthArray[500][500]);
		}
	}

	private static void dikstra(int x, int y) {
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		queue.add(new int[] {x,y,0});
		healthArray[x][y] = 0;

		while (!queue.isEmpty()){
			int[] poll = queue.poll();

			int nowX = poll[0];
			int nowY = poll[1];
			int nowCost = poll[2];

			for (int i = 0; i < 4; i++) {
				int newX = nowX + dx[i];
				int newY = nowY + dy[i];

				if(!isValidIdx(newX, newY) || isInArea(deathList, newX, newY)){
					continue;
				}
				int newCost = nowCost + (isInArea(dangerousList, newX, newY)? 1 : 0);

				if( newCost < healthArray[newX][newY] ){
					healthArray[newX][newY] = newCost;
					queue.add(new int[] {newX, newY, newCost});
				}
			}
		}
	}

	private static boolean isValidIdx(int x, int y) {
		return x >= 0 && y >= 0 && x <= 500 && y <= 500;
	}

	static boolean isInArea(List<Area> areaList, int x1, int y1) {
		for(Area area : areaList){
			if(area.isInThisArea(x1,y1)){
				return true;
			}
		}
		return false;
	}

	static class Area {
		int x1, y1, x2, y2;

		Area(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

		boolean isInThisArea(int x, int y) {
			if (x1 < x2) {
				if (y1 < y2) {
					return x1 <= x && x <= x2 && y1 <= y && y <= y2;
				} else {
					return x1 <= x && x <= x2 && y2 <= y && y <= y1;
				}
			} else {
				if (y1 < y2) {
					return x2 <= x && x <= x1 && y1 <= y && y <= y2;
				} else {
					return x2 <= x && x <= x1 && y2 <= y && y <= y1;
				}
			}
		}
	}

}
