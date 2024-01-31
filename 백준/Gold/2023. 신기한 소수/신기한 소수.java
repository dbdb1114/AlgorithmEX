import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class Main {
    static int n;
    static int[] oddNums = {1,3,5,7,9};
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        int[] primeNumber = {2,3,5,7};

        Arrays.stream(primeNumber).forEach(number->{
            recurFindPrimeNumber(number,1);
        });

    }

    public static void recurFindPrimeNumber(int number, int numberLength){
        if(!isPrimeNumber(number)){
            return;
        }

        if(isPrimeNumber(number) && numberLength == n){
            System.out.println(number);
            return ;
        }

        Arrays.stream(oddNums).forEach(oddNum -> {
            int testNumber = number * 10 + oddNum;
            recurFindPrimeNumber(testNumber, numberLength + 1);
        });
    }

    public static boolean isPrimeNumber(int number){
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number%i == 0){
                return false;
            }
        }
        return true;
    }
}