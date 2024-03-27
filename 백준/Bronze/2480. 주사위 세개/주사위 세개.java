import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] numArr = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();
        int numOfSame = 1; // 같은 갯수
        int num = numArr[2];    // 같은 수

        for (int i = 0; i < 3; i++) {
            for (int j = i+1; j < 3; j++) {
                if(numArr[i] == numArr[j]){
                    num = numArr[i];
                    numOfSame++;
                }
            }
            if(numOfSame >= 2){
                break;
            }
        }

        int baseMoney = numOfSame == 3 ? 10000 : numOfSame == 2 ? 1000 : 0;
        int multiMoney = numOfSame < 3 ? 100 * num : 1000 * num;

        System.out.println(baseMoney + multiMoney);
    }
}
