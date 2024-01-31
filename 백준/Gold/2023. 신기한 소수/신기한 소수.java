import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class Main {
    static int n;
    static String[] oddNums = {"1","3","5","7","9"};
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        String[] primeNumber = {"2","3","5","7"};

        Arrays.stream(primeNumber).forEach(number->{
            recurFindPrimeNumber(number);
        });

    }
    public static void recurFindPrimeNumber(String number){
        if(!isPrimeNumber(number)){
            return;
        }

        if(isPrimeNumber(number) && number.length() == n){
            System.out.println(number);
            return ;
        }

        Arrays.stream(oddNums).forEach(oddNum -> recurFindPrimeNumber(number+oddNum));
    }

    public static boolean isPrimeNumber(String number){
        int testNumber = Integer.parseInt(number);
        for(int i = 2; i <= Math.sqrt(testNumber); i++){
            if(testNumber%i == 0){
                return false;
            }
        }
        return true;
    }
}