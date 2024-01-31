import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static ArrayList<Integer>[] relationShip;
    static boolean[] visited;
    static boolean answer = false;
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] NandM = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = NandM[0];
        int m = NandM[1];

        relationShip = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            relationShip[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int[] AandB = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = AandB[0];
            int b = AandB[1];
            relationShip[a].add(b);
            relationShip[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            checkDepth(i,1);
            if(answer)break;
        }

        if(answer){
            System.out.println(1);
        } else{
            System.out.println(0);
        }

    }


    /**
     * 이전 방문을 체크해야함.
     * 해당 방문 기록은 삭제해야함.
     * */
    public static void checkDepth(int now, int depth) {
        if(depth == 5 || answer) {
            answer = true;
            return;
        }


        visited[now] = true;

        relationShip[now].stream().forEach(number -> {
            if(!visited[number]) {
                checkDepth(number, depth + 1);
            }
        });
        
        visited[now] = false;

    }

}
