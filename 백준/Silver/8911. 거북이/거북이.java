import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [==========================문제 분석============================]
 * 상근이는 2차원 평면 위에서 움직일 수 있는 거북이 로봇을 하나 가지고 있다.
 * 거북이 로봇에게 내릴 수 있는 명령은 다음과 같이 네가지가 있다.
 *
 *  F: 한 눈금 앞으로
 *  B: 한 눈금 뒤로
 *  L: 왼쪽으로 90도 회전
 *  R: 오른쪽으로 90도 회전
 *
 * L과 R명령을 내렸을 때, 로봇은 이동하지 않고, 방향만 바꾼다.
 * 명령을 나열한 것을 거북이 로봇의 컨트롤 프로그램이라고 한다.
 *
 * 거북이가 지나간 영역을 모두 포함할 수 있는 가장 작은 직사각형의 넓이를 구하는 프로그램을 작성하시오.
 *
 * [==예제==]
 * 아래 그림에서 거북이는 가장 처음에 (0, 0)에 있고, 북쪽을 쳐다보고 있다.
 * 컨트롤 프로그램이 FLFRFLBRBLB인 경우에 거북이는 아래와 같이 움직인다.
 * 회색으로 빗금친 부분이 거북이가 지나간 영역을 모두 포함할 수 있는 가장 작은 직사각형이다.
 * 넓이는 4가 된다.
 *
 *  FFLLFF인 경우에 거북이는 y축의 위로만 지나다닌다.
 *  이 경우에 거북이가 지나간 영역을 모두 포함하는 직사각형은 선분이고,
 *  선분은 한 변이 0인 직사각형으로 생각할 수 있다. 따라서, 선분의 경우에 넓이는 0이 된다.
 *
 * [==입력==]
 * 3
 * FFLF
 * FFRRFF
 * FFFBBBRFFFBBB
 * [==출력==]
 * 2
 * 0
 * 9
 * [==========================제한 조건============================]
 *  1. 입력값 범위
 *  2. 시간 제한 N초
 *  3. 메모리 제한 NMB
 * [==========================해결 전략============================]
 * [==========================슈도 코드============================]
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        Turtle turtle;
        for (int i = 0; i < N; i++) {
            turtle = new Turtle();
            String[] move = bf.readLine().split("");

            for (int j = 0; j < move.length; j++) {
                turtle.move(move[j]);
            }

            sb.append(turtle.getWidth() + "\n");
        }

        System.out.println(sb);
    }
}

class Turtle{
    int[] dx = {0,1,0,-1};
    int[] dy = {1, 0, -1, 0};

    int direct = 0;

    int x = 0;
    int y = 0;

    int maxX = 0;
    int minX = 0;
    int maxY = 0;
    int minY = 0;

    void move (String move){

        if(move.equals("L")){
            direct = direct == 0 ? 3 : direct - 1;
        }else if(move.equals("R")){
            direct = direct == 3 ? 0 : direct + 1;
        }else if(move.equals("F")){
            x += dx[direct];
            y += dy[direct];
        }else if(move.equals("B")){
            x -= dx[direct];
            y -= dy[direct];
        }

        updateMinMax(x,y);

    }

    void updateMinMax(int x, int y){
        maxX = Math.max(maxX, x);
        minX = Math.min(minX, x);
        maxY = Math.max(maxY, y);
        minY = Math.min(minY, y);
    }
    int getWidth() {
        return (maxX - minX) * (maxY - minY);
    }
}
