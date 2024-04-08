import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.BiFunction;

public class Main {

    static int N;
    static String[][] picture;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        visit = new boolean[N][N];
        picture = new String[N][N];

        for (int i = 0; i < N; i++) {
            picture[i] = bf.readLine().split("");
        }

        int normal = BFS(false);
        visit = new boolean[N][N];

        int blind = BFS(true);
        System.out.println(normal + " " + blind);
    }

    public static int BFS(boolean rgBlind){
        int count = 0;
        for (int i = 0; i < N; i++) {
            Queue<int[]> queue = new LinkedList<>();
            for (int j = 0; j < N; j++) {

                if(visit[i][j]) continue;;

                // 이번 구역에 대한 컬러 설정과
                // 큐에 인덱스 추가
                queue.add(new int[] {i,j});
                // 방문 체크
                visit[i][j] = true;
                String color = getColor.apply(picture[i][j],rgBlind);

                while(!queue.isEmpty()){

                    int[] poll = queue.poll();
                    
                    int i1 = poll[0];
                    int j1 = poll[1];

                    // 상하좌우 인덱스 체크
                    boolean hasLeft = j1-1 >= 0;
                    boolean hasRight = j1+1 < N;
                    boolean hasDown = i1+1 < N;
                    boolean hasUp = i1-1 >=0;

                    // 좌측 탐색
                    if(hasLeft && getColor.apply(picture[i1][j1-1],rgBlind).equals(color) && !visit[i1][j1-1]){
                        visit[i1][j1-1] = true;
                        queue.add(new int[] {i1, j1-1});
                    }

                    // 우측 탐색
                    if(hasRight && getColor.apply(picture[i1][j1+1],rgBlind).equals(color) && !visit[i1][j1+1]){
                        visit[i1][j1+1] = true;
                        queue.add(new int[] {i1, j1+1});
                    }

                    // 하단 탐색
                    if(hasDown && getColor.apply(picture[i1+1][j1],rgBlind).equals(color) && !visit[i1+1][j1]){
                        visit[i1+1][j1] = true;
                        queue.add(new int[] {i1+1, j1});
                    }

                    // 상단 탐색
                    if(hasUp && getColor.apply(picture[i1-1][j1],rgBlind).equals(color) && !visit[i1-1][j1]){
                        visit[i1-1][j1] = true;
                        queue.add(new int[] {i1-1, j1});
                    }

                }
                count++;
            }
        }

        return count;
    }

    // 적록색약인지에 따라 R이면 G로 바꾸고, G면 R로 변경
    static BiFunction<String,Boolean,String> getColor = (a, b)->{
        if(b && a.equals("R")){
            return "G";
        } else {
            return a;
        }
    };
}
