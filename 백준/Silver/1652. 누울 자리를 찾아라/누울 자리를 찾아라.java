import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{

        int N = Integer.parseInt(bf.readLine());
        int[] answer = new int[2];
        String [] bed = new String[N];

        for (int i = 0; i < N; i++) {
            bed[i] = bf.readLine();
        }

        for (int i = 0; i < N; i++) {
            boolean vertFind = false;
            boolean horiFind = false;
            for (int j = 1; j < N; j++) {
                if(!horiFind && bed[i].charAt(j) == '.' && bed[i].charAt(j-1) == '.'){
                    answer[0]++;
                    horiFind = true;
                } else if (bed[i].charAt(j) == 'X'){
                    horiFind = false;
                }
                if(!vertFind && bed[j].charAt(i) == '.' && bed[j-1].charAt(i) == '.'){
                    answer[1]++;
                    vertFind = true;
                } else if (bed[j].charAt(i) == 'X'){
                    vertFind = false;
                }
            }
        }
        System.out.print(answer[0] + " " + answer[1]);
    }
}
