import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Predicate;

public class Main {
    static int ansI;
    static int ansJ;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[][] fiveGo = new int[19][19];
        for (int i = 0; i < 19; i++) {
            StringTokenizer tk = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 19; j++) {
                fiveGo[i][j] = Integer.parseInt(tk.nextToken());
            }
        }


        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if(fiveGo[i][j] != 0 && victory(fiveGo, i, j)){
                    System.out.println(fiveGo[ansI][ansJ]);
                    System.out.println((ansI + 1) + " " + (ansJ + 1));
                    return;
                }
            }
        }
        System.out.println(0);
    }

    /**
     * 고려사항
     * 1. 육목일 경우              => count변수로 체크
     * 2. 육목인데 중간부터 탐색된 경우 => 진행방향의 직전에 같은 숫자가 있는지 확인
     * */
    private static Predicate<Integer> isFive = x -> x == 5;
    private static boolean victory(int[][]ar, int i, int j){
        return diagonal(ar,i,j)
                || horizontal(ar,i,j)
                || vertical(ar,i,j);
    }

    // 선형적으로 완전 탐색을 하게되면, 위에서 아래로, 왼쪽에서 오른쪽으로만 검색하면 됨
    private static boolean diagonal(int[][] ar, int i, int j){
        return leftDiagonal(ar,i,j) || rightDiagonal(ar,i,j);
    }

    private static boolean horizontal(int[][]ar, int i, int j){
        int color = ar[i][j];
        int count = 0;
        ansI = i;
        ansJ = j;
        // 육목 중간탐색 제거
        // horizontal은 우측으로만 증가하기 때문에 j값만 이동
        if(j > 0 && ar[i][j-1] == ar[i][j]){
            return false;
        }

        while(j<19){
            if(color == ar[i][j]){
                count++;
            } else {
                break;
            }
            j++;
        }

        // 정확히 5목인지
        return isFive.test(count);
    }


    // 세로 탐지 로직
    private static boolean vertical(int[][]ar, int i, int j){
        int color = ar[i][j];
        int count = 0;

        ansI = i;
        ansJ = j;

        // 위로 올라가기 때문에
        if(i > 0 && ar[i][j] == ar[i-1][j]){
            return false;
        }

        while(i < 19){
            if(color == ar[i][j]){
                count++;
            }else{
                break;
            }
            i++;
        }

        return isFive.test(count);
    }

    // 대각선 탐지 로직
    private static boolean leftDiagonal(int[][] ar, int i, int j){
        int count=0;
        int color = ar[i][j];

        if(i > 0 && j < 18 && ar[i-1][j+1] == color){
            return false;
        }


        // 5목일 경우, true =>
        while(i < 19 && j >=0){
            if(color == ar[i][j]){
                count++;
            } else {
                break;
            }

            i++;
            j--;
        }
        ansI = i-1;
        ansJ = j+1;

        return isFive.test(count);
    }
    private static boolean rightDiagonal(int[][] ar, int i, int j){
        int count = 0;
        int color = ar[i][j];

        ansI = i;
        ansJ = j;

        if(i > 0 && j > 0 && ar[i-1][j-1] == color){
            return false;
        }
        while(i < 19 && j < 19){
            if(color==ar[i][j]){
                count++;
            } else {
                break;
            }

            i++;
            j++;
        }
        return isFive.test(count);
    }

}
