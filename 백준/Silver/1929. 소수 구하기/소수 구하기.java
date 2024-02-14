import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] primeArr = new int[m+1];
        for (int i = n; i <= m; i++) {
            primeArr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(m); i++) {
            checkNotPrime(primeArr,i);
        }

        for (int i = 2; i < m+1; i++) {
            if(primeArr[i] != 0) {
                System.out.println(primeArr[i]);
            }
        }

    }

    static void checkNotPrime(int[] primeArr, int now){
        for (int i = 2; now*i < primeArr.length; i++) {
            primeArr[now*i] = 0;
        }
    }
}
