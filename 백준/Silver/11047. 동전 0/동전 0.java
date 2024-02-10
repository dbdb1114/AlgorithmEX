import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] readline = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = readline[0];
        int money = readline[1];
        int totalCoin = 0;

        int[] currency = new int[N];

        for (int i = N-1; i >= 0; i--) {
            currency[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int i = 0; i < N; i++) {
            int price = currency[i];

            if(price <= money){
                totalCoin += money/price;
                money = money%price;
            }
        }
        System.out.println(totalCoin);
    }

}
