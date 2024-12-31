import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] houseRGBPrice;
    static int[][] RGBPrice;

    public static void main(String[] args) throws IOException{
        setN();
        setRGB();

        for (int i = 1; i < N; i++) {
            findMin(i,0);
            findMin(i,1);
            findMin(i,2);
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            answer = Math.min(answer, RGBPrice[N-1][i]);
        }

        System.out.println(answer);
    }

    public static void findMin(int house, int color) {// 0, 1, 2
        if (color == 0) {
            RGBPrice[house][color] = RGBPrice[house][color] + Math.min(RGBPrice[house - 1][1], RGBPrice[house - 1][2]);
        } else if (color == 1) {
            RGBPrice[house][color] = RGBPrice[house][color] + Math.min(RGBPrice[house - 1][0], RGBPrice[house - 1][2]);
        } else {
            RGBPrice[house][color] = RGBPrice[house][color] + Math.min(RGBPrice[house - 1][0], RGBPrice[house - 1][1]);
        }
    }

    public static void setN() throws IOException {
        N = Integer.parseInt(br.readLine());
        houseRGBPrice = new int[N][3];
        RGBPrice = new int[N][3];
    }

    public static void setRGB() throws IOException {
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                houseRGBPrice[i][j] = Integer.parseInt(line[j]);
                RGBPrice[i][j] = Integer.parseInt(line[j]);
            }
        }
    }
}
