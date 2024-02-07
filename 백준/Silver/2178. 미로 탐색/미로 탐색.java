import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int[][] Arr;
    static boolean[][] visited;

    static int N;
    static int M;

    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                Arr[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0});

        BFS(queue);


        System.out.println(Arr[N-1][M-1]);
    }

    public static void BFS(Queue<int[]> queue) {


        Queue<int[]> queArr = new LinkedList<>();

        while (!queue.isEmpty()) {

            int[] pos = queue.poll();

            int y = pos[0];
            int x = pos[1];

            visited[y][x] = true;

            //상
            if(y > 0 && !visited[y-1][x] && Arr[y-1][x] == 1){
                Arr[y-1][x] = Arr[y][x] + 1;
                queue.offer(new int[] {y-1,x});
            }
            //하
            if(y < N-1 && !visited[y+1][x] && Arr[y+1][x] == 1){
                Arr[y+1][x] = Arr[y][x] + 1;
                queue.offer(new int[] {y+1,x});
            }
            //좌
            if(x > 0 && !visited[y][x-1] && Arr[y][x-1] == 1){
                Arr[y][x-1] = Arr[y][x] + 1;
                queue.offer(new int[] {y,x-1});
            }
            //우
            if(x < M-1 && !visited[y][x+1] && Arr[y][x+1] == 1){
                Arr[y][x+1] = Arr[y][x] + 1;
                queue.offer(new int[] {y,x+1});
            }
        }

    }
}
