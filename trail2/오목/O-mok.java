import java.util.*;

public class Main {
    
    static int[][] goMap = new int[19][19];
    static int[] dx = {1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1};
    static boolean[][] checked = new boolean[19][19];
    static boolean findAnswer = false;

    public static void main(String[] args) {
        // 방문 배열을 만들어서, 방문한 곳은 체크하지 않고, 
        // DFS 하면 될 것 같은데 
        // Please write your code here.
        // 좌하, 하, 우하, 우 네 가지 방향으로만 dfs를 하면 된다. 
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            for(int j = 0; j < 19; j++) {
                goMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 19; i++) {
            for(int j = 0; j < 19; j++) {
                if(checked[i][j] || goMap[i][j] == 0) continue;

                for(int k = 0; k < 4; k++) {
                    int di = k;
                    DFS(i, j, di, 1);
                    if(findAnswer) {
                        System.out.println(goMap[i][j]);
                        System.out.print((i + 1 + (dx[di] * 2)) + " " + (j + 1 +  (dy[di] * 2)) );
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    static void DFS(int i, int j, int di, int count) {
        if(count == 5) {
            findAnswer = true;
            return;
        }
        
        int x = i + dx[di];
        int y = j + dy[di];

        if(fineIndex(x,y) && goMap[x][y] == goMap[i][j]) {
            DFS(x, y, di, count + 1);
        } else {
            return;
        }
    }

    static boolean fineIndex(int x, int y) {
        if(x < 0 || x >= 19 || y < 0 || y >= 19) {
            return false;
        }

        return true;
    }
}