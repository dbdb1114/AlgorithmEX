import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        // 흰흰검검, 흰검흰검, 검검흰흰
        // => 이걸 우째 아노
        // => 최소 네 번의 흔적을 가지고 있어야 함. 
        // => 2차원배열 
        int[][] check = new int[200_001][4];
        int[] x1 = new int[1000];
        int[] x2 = new int[1000];
        int[] x3 = new int[1000];

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int pos = 100_000;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int x = Integer.parseInt(st.nextToken());
            String di = st.nextToken();
            int cur = pos;
            if(di.equals("L")) {
                pos -= x - 1; 
                x3[i] = 1;
            } else {
                pos += x - 1;
                x3[i] = 2;
            }
            x1[i] = Math.min(cur, pos);
            x2[i] = Math.max(cur, pos);
        }


        for(int i = 0; i < N; i++){
            for(int j = x1[i]; j <= x2[i]; j++){
                int color = x3[i];
                check[j][0] = color;
                check[j][color]++;
                if(check[j][1] >=2 && check[j][2] >= 2){
                    check[j][3] = 1;
                }
            }
        }
        
        int white = 0;
        int black = 0;
        int gray = 0;
        for(int i = 0; i < check.length; i++) {
            if(check[i][0] == 0) continue; 
            if(check[i][3] == 1) {
                gray++;
                continue;
            }

            if(check[i][0] == 1){
                white++;
            } else if(check[i][0] == 2) {
                black++;
            }
        }

        System.out.println(white + " " + black + " " + gray);
    }
}