import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * [==========================문제 분석============================]
 * 상근이는 2차원 평면 위에서 움직일 수 있는 거북이 로봇을 하나 가지고 있다. 거북이 로봇에게 내릴 수 있는 명령은 다음과 같이 네가지가 있다.
 *
 * F: 한 눈금 앞으로
 * B: 한 눈금 뒤로
 * L: 왼쪽으로 90도 회전
 * R: 오른쪽으로 90도 회전
 * L과 R명령을 내렸을 때, 로봇은 이동하지 않고, 방향만 바꾼다.
 *
 * 명령을 나열한 것을 거북이 로봇의 컨트롤 프로그램이라고 한다.
 *
 * 상근이는 자신의 컨트롤 프로그램으로 거북이가 이동한 영역을 계산해보려고 한다.
 * 거북이는 항상 x축과 y축에 평행한 방향으로만 이동한다.
 * 거북이가 지나간 영역을 모두 포함할 수 있는 가장 작은 직사각형의 넓이를 구하는 프로그램을 작성하시오.
 * 단, 직사각형의 모든 변은 x축이나 y축에 평행이어야 한다.
 *
 * 아래 그림에서 거북이는 가장 처음에 (0, 0)에 있고, 북쪽을 쳐다보고 있다.
 * 컨트롤 프로그램이 FLFRFLBRBLB인 경우에 거북이는 아래와 같이 움직인다.
 * 회색으로 빗금친 부분이 거북이가 지나간 영역을 모두 포함할 수 있는 가장 작은 직사각형이다. 넓이는 4가 된다.
 *
 * 거북이가 지나간 영역이 직사각형을 만들지 않는 경우도 있다.
 * 예를 들어, FFLLFF인 경우에 거북이는 y축의 위로만 지나다닌다.
 * 이 경우에 거북이가 지나간 영역을 모두 포함하는 직사각형은 선분이고, 선분은 한 변이 0인 직사각형으로 생각할 수 있다.
 * 따라서, 선분의 경우에 넓이는 0이 된다.
 * [==예제==]
 * 3
 * FFLF
 * FFRRFF
 * FFFBBBRFFFBBB
 *
 * 2
 * 0
 * 9
 * [==입력==]
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
 * 각 테스트 케이스는 한 줄로 이루어져 있고, 컨트롤 프로그램이 주어진다.
 * 프로그램은 항상 문제의 설명에 나와있는 네가지 명령으로만 이루어져 있고, 길이는 500을 넘지 않는다.
 * [==출력==]
 * 각 테스트 케이스에 대해서, 거북이가 이동한 영역을 모두 포함하는 가장 작은 직사각형의 넓이를 출력한다.
 * [==========================제한 조건============================]
 *  1. 입력값 범위
 *  2. 시간 제한 1초
 *  3. 메모리 제한 128MB
 * [==========================해결 전략============================]
 * FF -> 앞으로 2
 * LF -> 왼쪽으로 2
 *
 * FF -> 앞으로 2
 * RRFF -> 아래로 2
 * FFF -> 앞으로 3
 * BBB -> 뒤로 3
 * RFFF -> 오른쪽으로 3
 * BBB -> 뒤로 3
 *
 * 방향을 저장하는 {1 -1 -1 1}
 * RR -> 오른쪽으로 두 번
 * [==========================슈도 코드============================]
*/
public class Main {
    static int[] directionArr = {1, -1, -1, 1};
    static int nowDirection = 0;
    static int minX = 0;
    static int maxX = 0;
    static int minY = 0;
    static int maxY = 0;
    static int nowX = 0;
    static int nowY = 0;

    static Map<String, Integer> moveMap = new HashMap<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        moveMap.put("F", 1);
        moveMap.put("B", -1);
        for (int i = 0; i < T; i++) {
            String line = br.readLine();

            for (int j = 0; j < line.length(); j++) {
                moveOrChange(line.charAt(j));
            }
            System.out.println((maxY - minY)*(maxX - minX));
            initZero();
        }
    }

    public static void initZero() {
        nowDirection = 0;
        minX = 0;
        maxX = 0;
        minY = 0;
        maxY = 0;
        nowX = 0;
        nowY = 0;
    }

    public static void moveOrChange(char ch){
        if(ch == 'F' || ch == 'B') {
            moveDirection(ch + "");
        } else {
            changeDirection(ch + "");
        }
    }

    public static void moveDirection(String move) {
        if(nowDirection == 0 || nowDirection == 2) {
            nowY += moveMap.get(move) * directionArr[nowDirection];
        } else {
            nowX += moveMap.get(move) * directionArr[nowDirection];
        }
        minY = Math.min(minY, nowY);
        minX = Math.min(minX, nowX);
        maxX = Math.max(maxX, nowX);
        maxY = Math.max(maxY, nowY);
    }

    public static void changeDirection(String direction){
        if (direction.equals("R")){
            nowDirection++;
        } else if (direction.equals("L")){
            nowDirection--;
        }

        if(nowDirection == -1) {
            nowDirection = 3;
        } else if (nowDirection == 4){
            nowDirection = 0;
        }
    }
}
