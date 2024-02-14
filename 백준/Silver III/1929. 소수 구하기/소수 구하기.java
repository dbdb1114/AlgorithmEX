import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] primeArr = new boolean[m+1];
        Arrays.fill(primeArr,2,m+1,true);

        for (int i = 2; i <= Math.sqrt(m); i++) {
            checkNotPrime(primeArr,i);
        }

        for (int i = n; i < m+1; i++) {
            if(primeArr[i]){
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void checkNotPrime(boolean[] primeArr, int now){
        for (int i = 2; now*i < primeArr.length; i++) {
            primeArr[now*i] = false;
        }
    }
}
