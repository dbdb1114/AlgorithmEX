import java.util.*;

class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); // {x, y, 거리}
        visited[0][0] = true;  // 시작점 방문 체크

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], depth = cur[2];

            // 도착점 도달하면 즉시 반환 (최단 거리 보장)
            if (x == n - 1 && y == m - 1) return depth;

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // 유효한 좌표인지 체크
                if (newX >= 0 && newY >= 0 && newX < n && newY < m 
                    && !visited[newX][newY] && maps[newX][newY] == 1) {
                    
                    queue.add(new int[]{newX, newY, depth + 1});
                    visited[newX][newY] = true; // 방문 체크는 여기서!
                }
            }
        }
        return -1; // 도착 불가능할 경우
    }
}
