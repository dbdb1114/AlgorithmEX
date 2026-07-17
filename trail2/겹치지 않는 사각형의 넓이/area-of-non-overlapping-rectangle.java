import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int OFFSET = 1000;
        int[][] square = new int[2000][2000];

        for(int i = 0; i < 3; i++){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int[] spot = new int[4];
            for(int j = 0; j < 4; j++){
                spot[j] = Integer.parseInt(st.nextToken()) + OFFSET; 
            }

            for(int j = spot[0]; j < spot[2]; j++){
                for(int k = spot[1]; k < spot[3]; k++){
                    square[j][k] = i + 1;
                }
            }
        }


        int answer = 0;
        for(int i = 0; i < square.length; i++){
            for(int j = 0; j <square[i].length; j++){
                if(square[i][j] != 3 && square[i][j] != 0) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}